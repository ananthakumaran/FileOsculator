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

package com.fileosculator.model;

import com.trolltech.qt.gui.QListWidgetItem;

/**
 *
 * @author Ananth
 */
public class UserListModel extends QListWidgetItem
{

    public String name = "hello";

    public UserListModel(String name)
    {
        super(name);
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
