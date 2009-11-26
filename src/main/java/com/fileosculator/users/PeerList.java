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
package com.fileosculator.users;

import com.fileosculator.model.User;
import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.QSignalEmitter.Signal1;
import java.util.HashSet;
import java.util.Set;

/**
 * constains the list of
 * users in the network
 * @author Ananth
 */
public class PeerList extends QSignalEmitter
{

    /** List of the peers current in the network */
    private static Set<User> peerList = new HashSet();
    /** signals when a new user joined  the network */
    public  Signal1<User> userAdded;
    /** signals whena a user unjoined the network */
    public  Signal1<User> userRemoved;
    /** singleton */
    private static PeerList peer;

    /**
     * constructor
     */
    private PeerList()
    {
        userAdded = new Signal1<User>();
        userRemoved = new Signal1<User>();
    }

    /**
     * getter for peerlist
     */
    public static synchronized Set<User> getPeers()
    {
        return peerList;
    }

    /**
     * add a new user to the peer list
     * and signals it
     */
    public void add(User user)
    {
        boolean added = false;

        synchronized (this)
        {
            added = peerList.add(user);
        }

        if (added)
        {
            userAdded.emit(user);
        }
    }

    /**
     * removes the user from the list
     * and signals it
     *
     * @param user user to be removed from the peerlist
     */
    public void remove(User user)
    {
        boolean removed = false;

        synchronized (this)
        {
            removed = peerList.add(user);
        }
        if (removed)
        {
            userRemoved.emit(user);
        }
    }

    /** getter for peerlist  singleton */
    public static synchronized PeerList get()
    {
        if (peer == null)
        {
            peer = new PeerList();
        }
        return peer;
    }
}
