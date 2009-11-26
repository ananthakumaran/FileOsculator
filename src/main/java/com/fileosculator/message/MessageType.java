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

package com.fileosculator.message;

/**
 * MessageTypes transferred between peers
 * @author Ananth
 */
public enum MessageType
{

    /** Text messages */
    TEXT_MESSAGE,
    /** Represents a message contains the user details */
    USER_INFO,
    /** User info reqest message **/
    USER_INFO_REQUEST,
    /** Contains a file */
    FILE,
    /** Contains a folder */
    FOLDER,
    /** exit message  send this to all before quit */
    EXIT_ALERT,
    /** File request */
    FILE_REQUEST,
    /** File response */
    FILE_RESPONSE,
    /** Folder request */
    FOLDER_REQUEST,
    /** Folder response */
    FOLDER_RESPONSE
}
