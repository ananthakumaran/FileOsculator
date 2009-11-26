package com.fileosculator.multicast;

import com.fileosculator.model.User;
import com.fileosculator.server.Server;
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

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of run method, of class MulticastServer.
     */
    @Test
    public void testRun()
    {
        try
        {
            PeerList.get().userAdded.connect(this,"userAdded(User)");
            System.out.println("run");
            MulticastServer.getInstance();
            Server.init();
            // send a message to the multicast server
            QThread client = new QThread(new MulticastClient());
            client.start();
            client.join();

            // now the multicast server should send a info request to
            // the server and the should add a user to the peer list


            


        

            System.out.println("getting details");
        //    assertEquals("There should be one user present in the peer list ", 1, PeerList.getPeers().size());
            

        } catch (InterruptedException ex)
        {
            fail("exception  ");
            Logger.getLogger(MulticastServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void userAdded(User user)
    {
        System.out.println("user added test suite");
        this.user = user;
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

    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        // starts the server
        assertNotNull(MulticastServer.getInstance());
        assertNotNull(MulticastServer.getMulticastServerThread());

        try
        {
            MulticastServer.getMulticastServerThread().start();
            fail("The thread is not yet started");
        } catch (IllegalThreadStateException ex)
        {
        }

    }
}
