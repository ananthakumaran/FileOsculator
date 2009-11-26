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
import com.fileosculator.client.SendToAll;
import com.fileosculator.handler.FileHandler;
import com.fileosculator.handler.FileRequestHandler;
import com.fileosculator.handler.MessageHandler;
import com.fileosculator.message.Message;
import com.fileosculator.message.MessageType;
import com.fileosculator.model.User;
import com.fileosculator.multicast.MulticastClientDemon;
import com.fileosculator.multicast.MulticastServer;
import com.fileosculator.server.Server;
import com.fileosculator.ui.generated.Ui_MainWindow;
import com.fileosculator.users.PeerList;
import com.fileosculator.utils.widgets.FrameLessWidget;
import com.fileosculator.utils.widgets.ReziableFrame;
import com.trolltech.qt.QThread;
import com.trolltech.qt.core.QEvent;
import com.trolltech.qt.gui.QBoxLayout.Direction;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main Window of the application
 * @author Ananth
 */
public class MainWindow extends FrameLessWidget
{

    // Generated Widow
    private Ui_MainWindow uiMainWindow = new Ui_MainWindow();
    // Title Bar of the Window
    private TitleBar titleBar;
    /** contains the list of all the user widget */
    private List<UserWidget> userWidgetList = new ArrayList<UserWidget>();
    /** contains the list of file receiver widget */
    private Map<Long, FileReceiverWidget> fileReceiverWidgetList = new HashMap<Long, FileReceiverWidget>();

    /**
     * constructor
     */
    public MainWindow()
    {
        this(null);
    }

    /**
     * constructor
     * @param parent parent widget
     */
    public MainWindow(QWidget parent)
    {
        super(parent);
        uiMainWindow.setupUi(this);


        // add the title bar
        addTitleBar();

        uiMainWindow.horizontalLayout_4.addWidget(new ReziableFrame(this));

        uiMainWindow.verticalLayout_3.setDirection(Direction.BottomToTop);



        PeerList.get().userAdded.connect(this, "addWidget(User)");
        PeerList.get().userRemoved.connect(this, "removeWidget(User)");

        MessageHandler.getInstance().messageReceived.connect(this, "receive(Message)");

        FileHandler fileHandler = FileHandler.getInstance();

        fileHandler.fileReceived.connect(this, "fileReceived(Long)");

        fileHandler.marginChanged.connect(this, "onMarginChange(Long,Integer)");
        fileHandler.valueChanged.connect(this, "onValueChange(Long,Integer)");
        fileHandler.transferOver.connect(this, "onTransferOver(Long)");
        fileHandler.fileNameChanged.connect(this, "onFileNameChange(Long,String)");

        FileRequestHandler.getInstance().fileReceived.connect(this, "fileRequest(Message)");


        uiMainWindow.settings.linkActivated.connect(this, "settings()");


        new TrayWidget(this);
    }

    /**
     * adds titleBar to the Main Window
     */
    private void addTitleBar()
    {
        titleBar = new TitleBar(this);
        uiMainWindow.TitleLayout.addWidget(titleBar);

        titleBar.titleBar.close.clicked.connect(this, "hide()");
    }

    @Override
    protected void closeEvent(QCloseEvent arg__1)
    {
        MainUserWidget.getInstance().close();
        closeAll();
        super.closeEvent(arg__1);
    }

    @Override
    protected void leaveEvent(QEvent arg__1)
    {

        // hide the MainUserWidget
        MainUserWidget current = MainUserWidget.getInstance();
        if (!current.isActiveWindow())
        {
            current.hide();
        }

        super.leaveEvent(arg__1);
    }

    /**
     * add the user to the user list
     * 
     */
    public void addWidget(User user)
    {
        System.out.println("trying to add user");


        UserWidget userWidget = new UserWidget(user);

        userWidgetList.add(userWidget);

        uiMainWindow.verticalLayout_3.addWidget(userWidget);

        System.out.println(userWidget);
        System.out.println("added");
    }

    /**
     * removes the user widget from the list
     */
    public void removeWidget(User user)
    {
        for (UserWidget userWidget : userWidgetList)
        {
            if (userWidget.user.equals(user))
            {
                uiMainWindow.verticalLayout_3.removeWidget(userWidget);
                userWidget.dispose();
                System.out.println("user removed");
                return;
            }
        }
    }

    public void receive(Message message)
    {
        new MessageWidget(message);
    }

    public void closeAll()
    {
        try
        {
            System.out.println("sending message to all");
            hide();
            new SendToAll(new Message(MessageType.EXIT_ALERT));
            QThread.sleep(1000);
            System.out.println("message send to all");
            MulticastServer.getInstance().close();
            Server.getInstance().close();
            MulticastClientDemon.getInstance().close();
            close();

        } catch (InterruptedException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fileReceived(Long key)
    {
        FileReceiverWidget fileReceiverWidget = new FileReceiverWidget();
        fileReceiverWidgetList.put(key, fileReceiverWidget);
    }

    public void onMarginChange(Long id, Integer value)
    {
        fileReceiverWidgetList.get(id).onMarginChanged(value);
    }

    public void onValueChange(Long id, Integer valude)
    {
        fileReceiverWidgetList.get(id).onValueChanged(valude);
    }

    public void onFileNameChange(Long id, String fileName)
    {
        fileReceiverWidgetList.get(id).onFileNameChange(fileName);
    }

    public void onTransferOver(Long id)
    {
        fileReceiverWidgetList.get(id).onTransferOver();
        fileReceiverWidgetList.remove(id);
    }

    public void settings()
    {
        new SettingsWidget();

    }

    public void fileRequest(Message message)
    {
        QMessageBox.StandardButton result = QMessageBox.question(this, "File received From" + message.getUser().getUserName(),
                "File(s) received from " + message.getUser().getUserName() + "\n Do you Want to save ",
                new QMessageBox.StandardButtons(QMessageBox.StandardButton.Yes, QMessageBox.StandardButton.No));

        if (result == QMessageBox.StandardButton.Yes)
        {
            if (message.getMessageType() == MessageType.FILE_RESPONSE)
            {
                message.setMessageType(MessageType.FILE_REQUEST);
                message.setReceiver(message.getUser());
                new QThread(new Client(message)).start();
            } else
            {
                message.setMessageType(MessageType.FOLDER_REQUEST);
                message.setReceiver(message.getUser());
                new QThread(new Client(message)).start();
            }
        }
    }
}
