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
