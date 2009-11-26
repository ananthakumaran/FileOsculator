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

package com.fileosculator.ui;

import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QSystemTrayIcon;
import com.trolltech.qt.gui.QWidget;

/**
 *
 * @author Ananth
 */
public class TrayWidget
{

    private QSystemTrayIcon trayIcon;
    private QMenu trayIconMenu;
    private QWidget parent;

    public TrayWidget(QWidget parent)
    {
        this.parent = parent;
        if (QSystemTrayIcon.isSystemTrayAvailable())
        {
            trayIconMenu = new QMenu(parent);
            trayIconMenu.aboutToShow.connect(this, "updateMenu()");



            QAction restoreAction = new QAction("Restore", parent);
            restoreAction.triggered.connect(this, "showNormal()");
            trayIconMenu.addAction(restoreAction);


            trayIconMenu.addSeparator();

            QAction quitAction = new QAction("Quit", parent);
            quitAction.triggered.connect(this, "close()");
            trayIconMenu.addAction(quitAction);


            trayIcon = new QSystemTrayIcon(parent);
            trayIcon.setToolTip("System trayIcon example");
            trayIcon.setContextMenu(trayIconMenu);
            trayIcon.setIcon(new QIcon("classpath:com/fileosculator/images/icon/chat_22.png"));

            trayIcon.activated.connect(this, "activated(com.trolltech.qt.gui.QSystemTrayIcon$ActivationReason)");

            trayIcon.show();
        }

    }

    public void updateMenu()
    {
    }

    public void showNormal()
    {
        parent.show();
    }

    public void close()
    {
        trayIcon.hide();
        parent.close();
    }

    public void activated(QSystemTrayIcon.ActivationReason reason)
    {
        if(reason == QSystemTrayIcon.ActivationReason.Trigger)
        {
            parent.show();
            parent.setFocus();
        }
    }
}
