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

package com.fileosculator.handler;

import com.trolltech.qt.QSignalEmitter;

/**
 *
 * @author Ananth
 */
public class FileHandler extends QSignalEmitter
{

    private static FileHandler fileHandler;
    public Signal1<Long> fileReceived;
    public Signal2<Long, Integer> valueChanged;
    public Signal2<Long, Integer> marginChanged;
    public Signal1<Long> transferOver;
    public Signal2<Long, String> fileNameChanged;

    private FileHandler()
    {
        fileReceived = new Signal1<Long>();
        valueChanged = new Signal2<Long, Integer>();
        marginChanged = new Signal2<Long, Integer>();
        transferOver = new Signal1<Long>();
        fileNameChanged = new Signal2<Long, String>();
    }

    public static FileHandler getInstance()
    {
        if (fileHandler == null)
        {
            fileHandler = new FileHandler();
        }
        return fileHandler;
    }
}
