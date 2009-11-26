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

package com.fileosculator.users;

import com.fileosculator.model.User;
import com.trolltech.qt.core.QEventLoop;
import com.trolltech.qt.core.QObject;
import com.trolltech.qt.gui.QApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Ananth
 */
public class PeerListTest extends QObject
{

    boolean userAdded;
    boolean userRemoved;

    @BeforeClass
    public void setUp()
    {
        QApplication.initialize(new String[]
                {
                });
        userAdded = false;
        userRemoved = false;
    }

    @Test
    public void addandRemoveTest()
    {
        System.out.println("Testing add method in PeerList");

        // add a new User
        PeerList.get().add(CurrentUser.getUserInstance());

        assertEquals(PeerList.getPeers().size(), 1, "There should be one user in the peerlist ");

        PeerList.get().remove(CurrentUser.getUserInstance());

        assertEquals(PeerList.getPeers().size(), 0, "There should be no in the peerlist ");
    }

    @AfterClass
    public void cleanUp()
    {
    }
}
