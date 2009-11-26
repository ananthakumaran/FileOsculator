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
import com.trolltech.qt.gui.QPixmap;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Contains the details the user of the application
 * @author Ananth
 */
public class CurrentUser
{

    /**  singleton */
    private static User user;
    /**  user preferences*/
    private static Preferences userPreferences;

    static
    {
        userPreferences = Preferences.systemNodeForPackage(CurrentUser.class);
    }

    /**
     * constructor
     */
    private CurrentUser()
    {
    }

    /** getter for the current instance */
    public static User getUserInstance()
    {
        if (user == null)
        {
            System.out.println("trying to get user details");
            try
            {
                if (!userPreferences.nodeExists("prefers"))
                {
                    System.out.println("user not exits");
                    // new User
                    user = new User("unKnown");

                    user.setSmallIcon(new QPixmap("classpath:com/fileosculator/images/users/personal-48.png"));
                    user.setLargeIcon(new QPixmap("classpath:com/fileosculator/images/users/personal-128.png"));

                    update();
                    try
                    {
                        // remove
                        user = (User) PrefObj.getObject(userPreferences, "prefers");
                    } catch (IOException ex)
                    {
                        Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex)
                    {
                        Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else
                {
                    System.out.println("no node");
                    try
                    {
                        System.out.println("getting pref");
                        user = (User) PrefObj.getObject(userPreferences, "prefers");
                    } catch (IOException ex)
                    {
                        Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex)
                    {
                        Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("setting localhost");
                user.setAddress(InetAddress.getLocalHost());
            } catch (BackingStoreException ex)
            {
                Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex)
            {
                Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
            }

            try
            {
                user.setAddress(InetAddress.getLocalHost());
            } catch (UnknownHostException ex)
            {
                Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("returning current user");
        return user;
    }

    /**
     * saves the modified user details
     */
    public static void update()
    {
        try
        {

            PrefObj.putObject(userPreferences, "prefers", user);
        } catch (IOException ex)
        {
            Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BackingStoreException ex)
        {
            Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO send the updated info to all the clients
    }
}
