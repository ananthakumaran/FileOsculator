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

import com.fileosculator.App;
import com.fileosculator.ui.MainUserWidget;
import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.gui.QApplication;

/**
 *
 * @author Ananth
 */
public class Position
{

    /** Screen size */
    public static final QRect SCREEN_SIZE;

    static
    {
        SCREEN_SIZE = QApplication.desktop().availableGeometry();
    }

    /**
     * constructor
     */
    private Position()
    {
    }

    /**
     * get the position for the
     * @param widgetPos current user widget pos
     */
    public static void setScreenPosition(QPoint widgetPos)
    {
        // postion of the MainWindow
        QRect mainWindowPos = App.getInstance().geometry();
        // calculate the top position of the WidgetF
        int top = Math.min(widgetPos.y() + 210, SCREEN_SIZE.height()) - 210;
        QRect pos = new QRect(0, top, 210, 300);
        // check for enough space on the left
        if (mainWindowPos.left() > 300)
        {
            pos.setLeft(mainWindowPos.left() - 295);
        } else
        {
            pos.setLeft(mainWindowPos.left() + 295);
        }
        // set the new Screen position
        MainUserWidget.getInstance().setGeometry(pos);

    }

    public static QRect getChatWindowScreenPosition(QPoint widgetPos)
    {
        // postion of the MainWindow
        QRect mainWindowPos = App.getInstance().geometry();
        // calculate the top position of the WidgetF
        int top = Math.min(widgetPos.y() + 300, SCREEN_SIZE.height()) - 300;
        QRect pos = new QRect(0, top, 300, 200);
        // check for enough space on the left
        if (mainWindowPos.left() > 250)
        {
            pos.setLeft(mainWindowPos.left() - 250);
        } else
        {
            pos.setLeft(mainWindowPos.left() + 250);
        }
        return pos;
    }
}
