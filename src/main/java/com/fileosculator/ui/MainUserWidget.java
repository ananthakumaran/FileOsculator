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

package com.fileosculator.ui;

import com.fileosculator.client.Client;
import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.model.User;
import com.fileosculator.ui.generated.Ui_MainUserWidget;
import com.trolltech.qt.QThread;
import com.trolltech.qt.core.QEvent;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.WindowFlags;
import com.trolltech.qt.core.Qt.WindowType;
import com.trolltech.qt.gui.QHideEvent;
import com.trolltech.qt.gui.QMainWindow;

/**
 *
 * @author Ananth
 */
public class MainUserWidget extends QMainWindow
{

    public Ui_MainUserWidget ui_MainUserWidget = new Ui_MainUserWidget();
    // main user widget singleton
    private static MainUserWidget mainUserWidget = new MainUserWidget();
    private User user;

    /**
     * constructor
     */
    private MainUserWidget()
    {
      ui_MainUserWidget.setupUi(this);
        // hide the Title bar
        setWindowFlags(new WindowFlags(WindowType.FramelessWindowHint));
        // for rounded corners
        setAttribute(Qt.WidgetAttribute.WA_TranslucentBackground, true);

        ui_MainUserWidget.SendMessage.clicked.connect(this, "sendMessage()");
    }

    /**
     * factory method for obtaining the instance of
     * MainUserWidget
     *
     * @return MainUserWidget
     */
    public static MainUserWidget getInstance()
    {
        return mainUserWidget;
    }

    /**
     * sets the details of the user in
     * the widget
     * @param user user object
     */
    public void setModel(User user)
    {
        // set the username
        ui_MainUserWidget.UserName.setText(user.getUserName());

        System.out.println("large icon" + user.getLargeIcon());
        ui_MainUserWidget.image.setPixmap(user.getLargeIcon());

        this.user = user;
    }

    @Override
    protected void enterEvent(QEvent arg__1)
    {
        mainUserWidget.show();
        super.enterEvent(arg__1);
    }

    @Override
    protected void leaveEvent(QEvent arg__1)
    {

        // TODO check whether the user
        // is focusing the mainwindow and hide
        // only if he is going out of the two window
        //(ie avoid the flickr)
        mainUserWidget.hide();
        super.leaveEvent(arg__1);
    }

    @Override
    protected void hideEvent(QHideEvent arg__1)
    {
        super.hideEvent(arg__1);
    }

    private void sendMessage()
    {
        Message textMessage = new Message(MessageType.TEXT_MESSAGE);
        textMessage.setMessage(ui_MainUserWidget.MessagetextEdit.toPlainText());
        textMessage.setReceiver(user);


        new QThread(new Client(textMessage)).start();

        hide();
    }
}
