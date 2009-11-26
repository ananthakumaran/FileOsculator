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

package com.fileosculator.utils;

/**
 *
 * @author Ananth
 */
public class Const
{

    /** port for the serever */
    public static int SERVER = 6666;
    /** port for the multicast server */
    public static int MULTICAST_SERVER = 4446;
    /** port for the multicast client */
    public static int MULTICAST_CLIENT = 4445;
    /** multicast ip address */
    public static String MULTICAST_GROUP = "230.0.0.1";
    /** packet size for file transferF */
    public static final int PACKET_SIZE = 20240;

    public static int MULTICAST_TEMP = 4446;
    public static int SERVER_TEMP = 6666;
    

    private Const()
    {
    }
}
