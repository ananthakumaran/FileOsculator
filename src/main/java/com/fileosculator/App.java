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
package com.fileosculator;

import com.fileosculator.multicast.MulticastClient;
import com.fileosculator.multicast.MulticastClientDemon;
import com.fileosculator.multicast.MulticastServer;
import com.fileosculator.server.Server;
import com.fileosculator.ui.MainWindow;
import com.fileosculator.utils.Const;
import com.trolltech.qt.QThread;
import com.trolltech.qt.gui.QApplication;
import java.util.Properties;

/**
 * Starter of the application
 *
 */
public class App
{

    /** Main window of the application */
    private static MainWindow mainWindow;

    /**
     * starting point
     */
    public static void main(String[] args)
    {
        QApplication.initialize(args);
        mainWindow = new MainWindow();
        mainWindow.show();

        // TODO remove it during release
        //   setPort();

        // start all the servers
        initServers();
        QApplication.exec();
    }

    /**
     * getter for the main window
     * @return main window instance
     */
    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    /**
     * set the ports to allow
     * testing in the same machine
     *
     * NOTE don't call this method other
     * than for testing
     */
    private static void setPort()
    {
        Properties prop = System.getProperties();
        Const.SERVER = Integer.parseInt(prop.getProperty("server"));
        Const.MULTICAST_CLIENT = Integer.parseInt(prop.getProperty("mc"));
        Const.MULTICAST_SERVER = Integer.parseInt(prop.getProperty("ms"));
        Const.MULTICAST_TEMP = Integer.parseInt(prop.getProperty("mt"));
        Const.SERVER_TEMP = Integer.parseInt(prop.getProperty("st"));
    }

    /**
     * intializes the servers
     */
    private static void initServers()
    {
        // intiate sthe server
        Server.init();
        // initiate the multicast server
        MulticastServer.getInstance();
        // initiate the multicast client
        new QThread(new MulticastClient()).start();
        // start the multicast demon
        MulticastClientDemon.Init();
        System.out.println("All the servers are started");
    }
}
