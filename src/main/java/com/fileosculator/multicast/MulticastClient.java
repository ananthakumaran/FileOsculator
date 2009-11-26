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
 *     contacts <ananthakumaran@gmail.com>
 */

package com.fileosculator.multicast;

import com.fileosculator.utils.Const;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sends message to  the
 * peers in the multicast group
 * @author Ananth
 */
public class MulticastClient implements Runnable
{

    /**
     * constructor
     */
    public MulticastClient()
    {
    }

    public void run()
    {
        try
        {
            // create a socket
            DatagramSocket socket = new DatagramSocket();
            InetAddress group = InetAddress.getByName(Const.MULTICAST_GROUP);
            // send a message to the group
            DatagramPacket packet = new DatagramPacket("hello".getBytes(), 5, group, Const.MULTICAST_TEMP);
            socket.send(packet);

            System.out.println("multicast message send");

        } catch (IOException ex)
        {
            Logger.getLogger(MulticastClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
