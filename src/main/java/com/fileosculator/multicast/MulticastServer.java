/**
 *     Copyright fileosculator (C) 2009 Anantha Kumaran
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *     contacts <ananthakumaran[at]gmail.com>
 */

package com.fileosculator.multicast;

import com.fileosculator.client.Client;
import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.model.User;
import com.fileosculator.utils.Const;
import com.trolltech.qt.QThread;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages the discovery of
 * peers in the network
 *
 * @author Ananth
 */
public class MulticastServer implements Runnable
{

    /** multicast socket */
    private MulticastSocket socket;
    /** multicast group address */
    private InetAddress group;
    /** Multicast server Thread */
    private static QThread multicastServerThread;
    /** Multicast server singleton */
    private static MulticastServer multicastServer;
    /** used as a flag to close the multicast server*/
    private boolean finished = false;

    /**
     * constructor
     * singleton
     *
     */
    private MulticastServer()
    {
    }

    public void run()
    {
        try
        {
            // join the multicast group
            socket = new MulticastSocket(Const.MULTICAST_SERVER);
            group = InetAddress.getByName(Const.MULTICAST_GROUP);
            socket.joinGroup(group);

            // data packet
            DatagramPacket packet;
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);

            while (!finished)
            {
                // wait for packets
                socket.receive(packet);

                // send a reply message to the peer
                // whenever a packet is received
                Message reply = new Message(MessageType.USER_INFO_REQUEST);
                reply.setReceiver(new User(packet.getAddress()));
                QThread client = new QThread(new Client(reply));
                client.start();
                try
                {
                    System.out.println("waiting for client to finish");
                    client.join();

                    System.out.println("client finished");
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // close the sockets
            socket.leaveGroup(group);
            socket.close();

        } catch (IOException ex)
        {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * closes the multicast socket and
     * the thread that opened it
     */
    public void close()
    {
        try
        {
            finished = true;

            // send a message to unblock the
            // multicast server
            QThread unblocker = new QThread(new MulticastClient());
            unblocker.start();
            unblocker.join();

            // wait atleast for 1 min for the completion of multicast server thread
            getMulticastServerThread().join(100);

        } catch (InterruptedException ex)
        {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * getter
     * Lazily initializes the singleton
     *
     * @return multicast singleton
     */
    public static MulticastServer getInstance()
    {
        if (multicastServerThread == null)
        {
            multicastServerThread = new QThread(multicastServer = new MulticastServer());
            multicastServerThread.start();
        }
        return multicastServer;
    }

    public static QThread getMulticastServerThread()
    {
        return multicastServerThread;
    }
}
