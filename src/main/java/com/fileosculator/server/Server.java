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

package com.fileosculator.server;

import com.fileosculator.client.Client;
import com.fileosculator.handler.FileRequestHandler;
import com.fileosculator.handler.MessageHandler;
import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.users.CurrentUser;
import com.fileosculator.users.PeerList;
import com.fileosculator.utils.Const;
import com.trolltech.qt.QThread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listens for incomming messages from other
 * peers
 *
 * @author Ananth
 */
public class Server implements Runnable
{

    /** server Socket */
    private ServerSocket serverSocket;
    /** server thread */
    private static QThread serverThread;
    /**  singleton server */
    private static Server server;
    /** finish flag */
    private boolean finished = false;

    /**
     * constructor
     */
    private Server()
    {
    }

    public void run()
    {
        try
        {
            System.out.println("waiting for messages");
            serverSocket = new ServerSocket(Const.SERVER);
            while (!finished)
            {
                Socket worker = serverSocket.accept();
                System.out.println("message received by server");
                ObjectInputStream reader = new ObjectInputStream(worker.getInputStream());
                final Message receivedMessage = (Message) reader.readObject();
                System.out.println("message from " + receivedMessage.getUser() + receivedMessage.getMessageType());

                switch (receivedMessage.getMessageType())
                {
                    case USER_INFO_REQUEST:
                        sendUserInfo(receivedMessage);
                        PeerList.get().add(receivedMessage.getUser());
                        System.out.println("user info request received from" + receivedMessage.getUser());
                        break;
                    case USER_INFO:
                        System.out.println("user info received from " + receivedMessage.getUser());
                        PeerList.get().add(receivedMessage.getUser());
                        break;
                    case TEXT_MESSAGE:
                        //TODO display the text
                        System.out.println("message received");
                        MessageHandler.getInstance().messageReceived(receivedMessage);
                        break;
                    case FILE:
                        // save the file
                        new QThread(new FileReader(receivedMessage, reader)).start();
                        break;
                    case EXIT_ALERT:
                        PeerList.get().remove(receivedMessage.getUser());
                        System.out.println("exit message received");
                        break;
                    case FOLDER:
                        new QThread(new FolderReader(reader)).start();
                        break;
                    case FILE_RESPONSE:
                    case FOLDER_RESPONSE:
                        FileRequestHandler.getInstance().fileReceived.emit(receivedMessage);
                        break;
                    case FILE_REQUEST:
                        receivedMessage.setMessageType(MessageType.FILE);
                        receivedMessage.setReceiver(receivedMessage.getUser());
                        new QThread(new Client(receivedMessage)).start();
                        break;
                    case FOLDER_REQUEST:
                        receivedMessage.setMessageType(MessageType.FOLDER);
                        receivedMessage.setReceiver(receivedMessage.getUser());
                        new QThread(new Client(receivedMessage)).start();
                        break;
                }
            }

            serverSocket.close();
            System.out.println("server  socket closed");

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * starts the server
     */
    public static void init()
    {
        if (serverThread == null)
        {
            serverThread = new QThread(server = new Server());
            serverThread.start();
        }
    }

    /**
     * send the user info in reply to
     * the user info request by other peer on
     * the network
     * @param receivedMessage received messge from the peer
     */
    public void sendUserInfo(Message receivedMessage)
    {
        Message userInfo = new Message(MessageType.USER_INFO);
        userInfo.setUser(CurrentUser.getUserInstance());
        userInfo.setReceiver(receivedMessage.getUser());
        (new QThread(new Client(userInfo))).start();
        System.out.println("message send info");
    }

    /**
     * quits the server
     */
    public void close()
    {
        try
        {
            finished = true;

            System.out.println("trying to close server ");
            Message message = new Message(MessageType.USER_INFO);
            message.setReceiver(CurrentUser.getUserInstance());
            QThread finishThread = new QThread(new Client(message));
            finishThread.start();
            finishThread.join();

            getServerThread().join(100);

            System.out.println("server thread closed");


        } catch (InterruptedException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * getter for the server
     */
    public static Server getInstance()
    {
        return server;
    }

    public static QThread getServerThread()
    {
        return serverThread;
    }
}
