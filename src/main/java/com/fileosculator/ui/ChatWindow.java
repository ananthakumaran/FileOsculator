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

import com.fileosculator.client.Client;
import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.model.User;
import com.fileosculator.ui.generated.Ui_ChatWindow;
import com.fileosculator.utils.widgets.ChatTextEdit;
import com.fileosculator.utils.widgets.FrameLessWidget;
import com.trolltech.qt.QThread;
import com.trolltech.qt.gui.QCloseEvent;

/**
 *
 * @author Ananth
 */
public class ChatWindow extends FrameLessWidget
{

    private Ui_ChatWindow chatWindow = new Ui_ChatWindow();
    /** text box for messages */
    private ChatTextEdit chatTextEdit;
    /** Title Bar of the Window */
    private TitleBar titleBar;
    private UserWidget parent;
    private User user;

    public ChatWindow(UserWidget parent, User user)
    {
        chatWindow.setupUi(this);

        this.parent = parent;
        this.user = user;

        // message box
        chatTextEdit = new ChatTextEdit(this);
        chatWindow.ChatLayout.addWidget(chatTextEdit);

        chatTextEdit.textEntered.connect(this, "textEntered(String)");
        addTitleBar();

    }

    /**
     * adds titleBar to the Main Window
     */
    private void addTitleBar()
    {
        titleBar = new TitleBar(this);
        chatWindow.TitleLayout.addWidget(titleBar);
        titleBar.titleBar.close.clicked.connect(this,"close()");
    }

    @Override
    protected void closeEvent(QCloseEvent arg__1)
    {
        parent.chatWindow = null;
        super.closeEvent(arg__1);
    }

    public void textEntered(String text)
    {
        chatWindow.ChatlistWidget.addItem(text);



        Message textMessage = new Message(MessageType.TEXT_MESSAGE);
        textMessage.setMessage(text);
        textMessage.setReceiver(user);


        new QThread(new Client(textMessage)).start();
        // new MessageWidget(text);
    }
}

