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

package com.fileosculator.client;

import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.server.Server;
import com.fileosculator.users.CurrentUser;
import com.fileosculator.users.PeerList;
import com.trolltech.qt.QThread;
import com.trolltech.qt.QtJambiObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 *
 * @author Ananth
 */
public class ClientTest extends QtJambiObject
{

    QThread client;

    public ClientTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @BeforeTest
    public void setUp()
    {
        Server.init();
        PeerList.getPeers().clear();
    }

    @AfterTest
    public void tearDown()
    {
        Server.getInstance().close();
    }

    /**
     * Test of run method, of class Client.
     */
    @Test(invocationCount = 10)
    public void testSendingUserInfoMessage()
    {
        try
        {
            Message m = new Message(MessageType.USER_INFO_REQUEST);
            m.setReceiver(CurrentUser.getUserInstance());
            client = new QThread(new Client(m));
            client.start();
            client.join();

            assertEquals(PeerList.getPeers().size(), 1, "There should be one user in the list");
        } catch (Exception ex)
        {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
