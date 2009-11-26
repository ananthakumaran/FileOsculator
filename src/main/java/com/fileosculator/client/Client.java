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
package com.fileosculator.client;

import com.fileosculator.message.Message;
import com.fileosculator.users.CurrentUser;
import com.fileosculator.utils.Const;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * send a message to another
 * peer
 * @author Ananth
 */
public class Client implements Runnable
{

    /** client socket */
    private Socket clientSocket;
    /** message */
    private Message message;

    /**
     * constructor
     * @param message message to be send
     */
    public Client(Message message)
    {
        this.message = message;
        this.message.setUser(CurrentUser.getUserInstance());
    }

    @Override
    public void run()
    {
        try
        {
            // send the message to the receiver
            clientSocket = new Socket(message.getReceiver().getAddress(), Const.SERVER_TEMP);
            ObjectOutputStream objectSender = new ObjectOutputStream(clientSocket.getOutputStream());
            objectSender.writeObject(message);
            objectSender.flush();

            switch (message.getMessageType())
            {
                case FILE:
                    // input file stream
                    File file = new File(message.getFileUrl());
                    FileInputStream fileInputStream = new FileInputStream(file);
                    DataInputStream fileReader = new DataInputStream(fileInputStream);

                    //
                    int totalSizeTransferred = 0;
                    int totalSizeRead;
                    byte[] packet = new byte[Const.PACKET_SIZE];

                    // send the file length
                    objectSender.writeLong(file.length());
                    objectSender.flush();

                    // send the data
                    while ((totalSizeRead = fileReader.read(packet, 0, packet.length)) >= 0)
                    {
                        objectSender.write(packet, 0, totalSizeRead);
                        totalSizeTransferred = totalSizeTransferred + totalSizeRead;
                        // clientSocket.flush();
                    }
                    // flush and close all the streams
                    objectSender.flush();
                    objectSender.close();
                    fileReader.close();
                    break;
                case FOLDER:
                    new FolderZip(objectSender, message.getFileNames());
                    break;
            }
        } catch (IOException ex)
        {
            // fails when the recepient is not active
            // don't do anything
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                clientSocket.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
