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
import com.fileosculator.ui.generated.Ui_UserWidget;
import com.fileosculator.utils.Position;
import com.trolltech.qt.QThread;
import com.trolltech.qt.core.QEvent;
import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.core.QUrl;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QDragEnterEvent;
import com.trolltech.qt.gui.QDropEvent;
import com.trolltech.qt.gui.QMouseEvent;
import com.trolltech.qt.gui.QPalette;
import com.trolltech.qt.gui.QWidget;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ananth
 */
public class UserWidget extends QWidget
{

    Ui_UserWidget userWidget = new Ui_UserWidget();
    User user;
    ChatWindow chatWindow;

    public UserWidget(User user)
    {
        userWidget.setupUi(this);
        this.user = user;

        userWidget.label.setText(user.getUserName());

        userWidget.userimage.setPixmap(user.getSmallIcon());

        // set the background color
        QPalette backgroundColor = palette();
        backgroundColor.setColor(backgroundRole(), QColor.white);
        setPalette(backgroundColor);

        // enable mouse tracking
        setMouseTracking(true);

        setAcceptDrops(true);

        System.out.println("accept drop" + acceptDrops());
    }

    @Override
    protected void enterEvent(QEvent arg__1)
    {
        // show the current user details
        MainUserWidget current = MainUserWidget.getInstance();
        current.setModel(user);
        Position.setScreenPosition(mapToGlobal(new QPoint(0, 0)));
        current.show();
        super.enterEvent(arg__1);
    }

    @Override
    protected void mousePressEvent(QMouseEvent arg__1)
    {

        if (arg__1.button() == Qt.MouseButton.LeftButton)
        {
            MainUserWidget.getInstance().hide();
            if (chatWindow == null)
            {
                createChatWindow();
                chatWindow.show();
            }
            chatWindow.setFocus();

        }
        super.mousePressEvent(arg__1);
    }

    public void createChatWindow()
    {
        chatWindow = new ChatWindow(this, user);
        chatWindow.setGeometry(Position.getChatWindowScreenPosition(mapToGlobal(new QPoint(0, 0))));

    }

    @Override
    protected void dragEnterEvent(QDragEnterEvent dragEvent)
    {
        System.out.println("draging");
     //   if (dragEvent.mimeData().hasUrls())
    //    {
            dragEvent.acceptProposedAction();
     //   }
        
    }

    @Override
    protected void dropEvent(QDropEvent dropEvent)
    {

        List<QUrl> urls = dropEvent.mimeData().urls();

        if (urls.isEmpty())
        {
            return;
        }

        if (urls.size() == 1 && new File(urls.get(0).toLocalFile()).isFile())
        {

            File file = new File(urls.get(0).toLocalFile());
            Message message = new Message(MessageType.FILE_RESPONSE);
            message.setReceiver(user);
            message.setFileName(file.getName());
            message.setFileUrl(urls.get(0).toLocalFile());
            new QThread(new Client(message)).start();

        } else
        {
            List<String> fileList = new ArrayList<String>();
            for (QUrl url : urls)
            {
                fileList.add(url.toLocalFile());
            }
            Message message = new Message(MessageType.FOLDER_RESPONSE);
            message.setReceiver(user);
            message.setFileNames(fileList);
            new QThread(new Client(message)).start();

        }
    }
}
