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

package com.fileosculator.message;

import com.fileosculator.model.User;
import java.io.Serializable;
import java.util.List;

/**
 * Model of the message
 * contains the details like the type of the message , filename
 * etc
 * 
 * @author Ananth
 */
public class Message implements Serializable, Cloneable
{

    /** Type of the message */
    private MessageType messageType;
    /** name of the file */
    private String fileName;
    /** absolute path of the file */
    private String fileUrl;
    /** message string */
    private String message;
    /**  sender of the message */
    private User user;
    /**  receiver of the message */
    private User receiver;
    /** list of files or folder to send */
    private List<String> fileNames;

    public Message()
    {
    }

    public Message(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public Message(MessageType messageType, String Message)
    {
        this.messageType = messageType;
        this.message = Message;
    }

    public Message(MessageType messageType, String FileName, String Message, User user)
    {
        this.messageType = messageType;
        this.fileName = FileName;
        this.message = Message;
        this.user = user;
    }

    /******** setters and getters for the message field ********************/
    //
    public MessageType getMessageType()
    {
        return messageType;
    }

    public void setMessageType(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public List<String> getFileNames()
    {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames)
    {
        this.fileNames = fileNames;
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getMessage()
    {
        return message;
    }

    public void setFileName(String FileName)
    {
        this.fileName = FileName;
    }

    public void setMessage(String Message)
    {
        this.message = Message;
    }

    public void setReceiver(User receiver)
    {
        this.receiver = receiver;
    }

    public User getReceiver()
    {
        return receiver;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl()
    {
        return fileUrl;
    }

    @Override
    public Message clone() throws CloneNotSupportedException
    {
        Message msg = new Message();
        msg.setFileName(fileName);
        msg.setMessageType(messageType);
        msg.setUser(user);
        msg.setReceiver(receiver);
        msg.setMessage(message);
        return msg;
    }
}
