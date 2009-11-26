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
import com.fileosculator.model.User;
import com.fileosculator.users.PeerList;
import com.trolltech.qt.QThread;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sends a message to all the
 *
 * @author Ananth
 */
public class SendToAll
{

    /**
     * costructor
     */
    public SendToAll(Message message)
    {
        for (User user : PeerList.getPeers())
        {
            try
            {
                Message msg = message.clone();
                msg.setReceiver(user);
                QThread thread = new QThread(new Client(msg));
                thread.start();
            } catch (CloneNotSupportedException ex)
            {
                Logger.getLogger(SendToAll.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
