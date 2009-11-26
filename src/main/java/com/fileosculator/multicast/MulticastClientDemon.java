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

import com.trolltech.qt.QThread;
import com.trolltech.qt.core.QTimer;

/**
 *
 * sends multicast packets every 3 minutes
 *
 * @author Ananth
 */
public class MulticastClientDemon
{

    /** timer */
    private QTimer timer = new QTimer();
    /**  singleton */
    private static MulticastClientDemon demon;

    /**
     * allow a singleton only
     * constructor
     */
    private MulticastClientDemon()
    {
    }

    /**
     * initiate the demon
     */
    public static void Init()
    {
        if (demon == null)
        {
            demon = new MulticastClientDemon();
            demon.timer.timeout.connect(demon, "sendMessage()");
            demon.timer.start(1000 * 60 * 1);
        }
        demon.sendMessage();
    }

    /**
     * sends message when the
     * timeout happens
     */
    private void sendMessage()
    {
        System.out.println(this + "sending message");
        new QThread(new MulticastClient()).start();
    }

    public static MulticastClientDemon getInstance()
    {
        return demon;
    }

    /**
     * stop the time before the application
     * exists
     */
    public void close()
    {
        timer.stop();
    }
}
