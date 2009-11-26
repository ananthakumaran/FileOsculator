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

import com.fileosculator.message.Message;
import com.fileosculator.ui.generated.Ui_MessageWidget;
import com.fileosculator.utils.Position;
import com.fileosculator.utils.widgets.FrameLessWidget;
import com.trolltech.qt.core.QEvent;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QTimer;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.WindowType;

/**
 *
 * @author Ananth
 */
public class MessageWidget extends FrameLessWidget
{

    private Ui_MessageWidget messageWdiget = new Ui_MessageWidget();
    QTimer animate = new QTimer();
    /** Title Bar of the Window */
    private TitleBar titleBar;
    boolean focused = false;
    private QRect rect;
    private Message message;

    public MessageWidget(Message message)
    {
        messageWdiget.setupUi(this);

        this.message = message;
        setText();

        setWindowFlags(WindowType.WindowStaysOnTopHint, WindowType.CustomizeWindowHint, WindowType.Window.FramelessWindowHint);

        // for rounded corners
        setAttribute(Qt.WidgetAttribute.WA_TranslucentBackground, true);

        addTitleBar();

        animate.timeout.connect(this, "timeout()");
        animate.start(40);
        rect = geometry();
        rect.setCoords(Position.SCREEN_SIZE.width() - sizeHint().width(), Position.SCREEN_SIZE.height(), Position.SCREEN_SIZE.width(), Position.SCREEN_SIZE.height());


        // reply

        messageWdiget.Reply.linkActivated.connect(this, "reply()");


        setGeometry(rect);
        show();

    }

    public void setText()
    {
        messageWdiget.Message.setText(message.getMessage());
        messageWdiget.User.setText("Message from " + message.getUser().getUserName());
    }

    public void timeout()
    {
        if (rect.top() > Position.SCREEN_SIZE.height() - sizeHint().height())
        {
            rect.setY(rect.y() - 5);
            setGeometry(rect);
        } else
        {
            animate.stop();
            QTimer.singleShot(5000, this, "closeMessage()");
        }
    }

    @Override
    protected void enterEvent(QEvent arg__1)
    {
        focused = true;
        super.enterEvent(arg__1);
    }

    public void closeMessage()
    {
        if (!focused)
        {
            close();
        }
    }

    /**
     * adds titleBar to the Main Window
     */
    private void addTitleBar()
    {
        titleBar = new TitleBar(this);
        messageWdiget.TitleLayout.addWidget(titleBar);
        titleBar.titleBar.close.clicked.connect(this, "close()");
    }

    private void reply()
    {

        MainUserWidget mainUserWidget = MainUserWidget.getInstance();

        mainUserWidget.setModel(message.getUser());
        mainUserWidget.ui_MainUserWidget.MessagetextEdit.setText(message.getMessage());
        close();
        mainUserWidget.show();
        mainUserWidget.setGeometry(Position.SCREEN_SIZE.width()-300, Position.SCREEN_SIZE.height()-210, 300, 210);
    }
}
