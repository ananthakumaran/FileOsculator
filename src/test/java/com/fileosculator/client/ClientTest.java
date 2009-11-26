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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Before
    public void setUp()
    {
        Server.init();
    }

    @After
    public void tearDown()
    {
        Server.getInstance().close();
    }

    /**
     * Test of run method, of class Client.
     */
    @Test
    public void testSendingUserInfoMessage()
    {
        try
        {
            Message m = new Message(MessageType.USER_INFO_REQUEST);
            m.setReceiver(CurrentUser.getUserInstance());
            client = new QThread(new Client(m));
            client.start();
            client.join();
       //     assertEquals("There should be one user present in the peer list ", 1, PeerList.getPeers().size());

            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex)
        {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
