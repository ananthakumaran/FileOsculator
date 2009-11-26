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

import com.fileosculator.model.User;
import com.fileosculator.server.Server;
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
import static org.testng.Assert.*;

/**
 *
 * @author Ananth
 */
public class MulticastServerTest extends QtJambiObject
{

    User user = null;

    public MulticastServerTest()
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
    }

    @AfterTest
    public void tearDown()
    {
        Server.getInstance().close();
    }

    /**
     * Test of run method, of class MulticastServer.
     */
    @Test(invocationCount = 10)
    public void testRun()
    {
        try
        {
            System.out.println("run");

            MulticastServer.getInstance();
            // send a message to the multicast server
            QThread client = new QThread(new MulticastClient());

            client.start();
            client.join();

            MulticastServer.getInstance().close();
            assertEquals(PeerList.getPeers().size(), 1, "There should be one user present in the peer list ");

        } catch (InterruptedException ex)
        {
            fail("exception  ");
            Logger.getLogger(MulticastServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of close method, of class MulticastServer.
     */
    @Test
    public void testClose()
    {
        MulticastServer.getInstance().close();
    }

    /**
     * Test of getInstance method, of class MulticastServer.
     */
    @Test(expectedExceptions =
    {
        IllegalThreadStateException.class
    })
    public void testGetInstance()
    {
        System.out.println("getInstance");
        // starts the server
        assertNotNull(MulticastServer.getInstance());
        assertNotNull(MulticastServer.getMulticastServerThread());

        // should throw illegalThreadstateException
        MulticastServer.getMulticastServerThread().start();
    }
}
