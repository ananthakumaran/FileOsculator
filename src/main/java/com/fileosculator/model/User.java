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
package com.fileosculator.model;

import com.trolltech.qt.core.QBuffer;
import com.trolltech.qt.core.QByteArray;
import com.trolltech.qt.core.QIODevice.OpenModeFlag;
import com.trolltech.qt.gui.QImage;
import com.trolltech.qt.gui.QPixmap;
import java.io.Serializable;
import java.net.InetAddress;

/**
 * contails all the details about
 * a user
 *
 * @author Ananth
 */
public class User implements Serializable
{

    /** user name */
    private String userName;
    /** ip of the user */
    private InetAddress address;
    /** small icon data */
    private byte[] smallIconData;
    /** large icon data */
    private byte[] largeIconData;
    /** small size icon of the user */
    private transient QPixmap smallIcon;
    /** largeSize icon of the user */
    private transient QPixmap largeIcon;

    /**
     * constructor
     */
    public User()
    {
        this("unknown");
    }

    /**
     * constructor
     * @param userName userName
     */
    public User(String userName)
    {
        this.userName = userName;
    }

    public User(InetAddress address)
    {
        this.address = address;
    }

    /**
     * constructor
     * @param userName userName
     * @param  address inet address
     */
    public User(String userName, InetAddress address)
    {
        this.userName = userName;
        this.address = address;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setAddress(InetAddress address)
    {
        this.address = address;
    }

    public InetAddress getAddress()
    {
        return address;
    }

    public QPixmap getLargeIcon()
    {
        if (largeIcon == null)
        {
            largeIcon = QPixmap.fromImage(QImage.fromData(new QByteArray(largeIconData)));
        }
        return largeIcon;
    }

    public void setLargeIcon(QPixmap largeIcon)
    {
        this.largeIcon = largeIcon;
        setLargeIconData(getImageBytes(largeIcon.toImage()));
    }

    public QPixmap getSmallIcon()
    {
        if (smallIcon == null)
        {
            smallIcon = QPixmap.fromImage(QImage.fromData(new QByteArray(smallIconData)));
        }
        return smallIcon;
    }

    public void setSmallIcon(QPixmap smallIcon)
    {
        this.smallIcon = smallIcon;
        setSmallIconData(getImageBytes(smallIcon.toImage()));
    }

    public byte[] getLargeIconData()
    {
        return largeIconData;
    }

    public void setLargeIconData(byte[] largeIconData)
    {
        this.largeIconData = largeIconData;
    }

    public byte[] getSmallIconData()
    {
        return smallIconData;
    }

    public void setSmallIconData(byte[] smallIconData)
    {
        this.smallIconData = smallIconData;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User)
        {
            User other = (User) obj;
            return other.getAddress().equals(getAddress());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return getAddress().hashCode();
    }

    @Override
    public String toString()
    {
        // TODO return other fields as well

        return userName;
    }

    public byte[] getImageBytes(QImage image)
    {

        QByteArray ba = new QByteArray();
        QBuffer buffer = new QBuffer(ba);
        buffer.open(OpenModeFlag.WriteOnly);
        if (image != null)
        {
            image.save(buffer, "PNG");
            image = null;
        }
        byte[] returnbyteArray = ba.toByteArray();
        return returnbyteArray;
    }
}
