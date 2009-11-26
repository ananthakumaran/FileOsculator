/********************************************************************************
** Form generated from reading ui file 'MainUserWidget.jui'
**
** Created: Thu Nov 26 09:47:53 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainUserWidget implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QVBoxLayout verticalLayout;
    public QFrame frame;
    public QVBoxLayout verticalLayout_2;
    public QHBoxLayout horizontalLayout_3;
    public QLabel UserName;
    public QSpacerItem horizontalSpacer_2;
    public QLabel image;
    public QFrame line;
    public QTextEdit MessagetextEdit;
    public QFrame line_2;
    public QPushButton SendMessage;

    public Ui_MainUserWidget() { super(); }

    public void setupUi(QMainWindow MainUserWidget)
    {
        MainUserWidget.setObjectName("MainUserWidget");
        MainUserWidget.resize(new QSize(300, 210).expandedTo(MainUserWidget.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainUserWidget.sizePolicy().hasHeightForWidth());
        MainUserWidget.setSizePolicy(sizePolicy);
        MainUserWidget.setMinimumSize(new QSize(300, 200));
        MainUserWidget.setMaximumSize(new QSize(16777215, 210));
        MainUserWidget.setMouseTracking(true);
        MainUserWidget.setAutoFillBackground(true);
        MainUserWidget.setStyleSheet("");
        centralwidget = new QWidget(MainUserWidget);
        centralwidget.setObjectName("centralwidget");
        centralwidget.setAutoFillBackground(false);
        centralwidget.setStyleSheet("#centralwidget{\n"+
"\n"+
"background:white;\n"+
"border-width: 10px;\n"+
"border-color: black;\n"+
"}");
        verticalLayout = new QVBoxLayout(centralwidget);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        frame = new QFrame(centralwidget);
        frame.setObjectName("frame");
        frame.setStyleSheet("\n"+
"QFrame#frame{\n"+
"\n"+
"border-width:3px;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"padding:3px;\n"+
"\n"+
"border-radius:10px;\n"+
"\n"+
"\n"+
"}");
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_2 = new QVBoxLayout(frame);
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setMargin(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        UserName = new QLabel(frame);
        UserName.setObjectName("UserName");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(UserName.sizePolicy().hasHeightForWidth());
        UserName.setSizePolicy(sizePolicy1);
        QFont font = new QFont();
        font.setFamily("MS Shell Dlg 2");
        font.setPointSize(14);
        UserName.setFont(font);
        UserName.setAutoFillBackground(false);
        UserName.setText("TextLabel");
        UserName.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        UserName.setWordWrap(false);

        horizontalLayout_3.addWidget(UserName);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_3.addItem(horizontalSpacer_2);

        image = new QLabel(frame);
        image.setObjectName("image");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(image.sizePolicy().hasHeightForWidth());
        image.setSizePolicy(sizePolicy2);
        image.setMinimumSize(new QSize(128, 128));
        image.setPixmap(new QPixmap(("classpath:com/fileosculator/images/users/personal-128.png")));

        horizontalLayout_3.addWidget(image);


        verticalLayout_2.addLayout(horizontalLayout_3);

        line = new QFrame(frame);
        line.setObjectName("line");
        line.setMinimumSize(new QSize(0, 5));
        line.setStyleSheet("");
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);

        verticalLayout_2.addWidget(line);

        MessagetextEdit = new QTextEdit(frame);
        MessagetextEdit.setObjectName("MessagetextEdit");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)40);
        sizePolicy3.setHeightForWidth(MessagetextEdit.sizePolicy().hasHeightForWidth());
        MessagetextEdit.setSizePolicy(sizePolicy3);
        MessagetextEdit.setMaximumSize(new QSize(16777215, 50));
        MessagetextEdit.setAcceptDrops(false);

        verticalLayout_2.addWidget(MessagetextEdit);

        line_2 = new QFrame(frame);
        line_2.setObjectName("line_2");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(line_2.sizePolicy().hasHeightForWidth());
        line_2.setSizePolicy(sizePolicy4);
        line_2.setMinimumSize(new QSize(0, 5));
        line_2.setFrameShape(QFrame.Shape.HLine);
        line_2.setFrameShadow(QFrame.Shadow.Sunken);

        verticalLayout_2.addWidget(line_2);

        SendMessage = new QPushButton(frame);
        SendMessage.setObjectName("SendMessage");
        SendMessage.setMinimumSize(new QSize(0, 32));
        SendMessage.setStyleSheet("QPushButton {\n"+
"padding:3px;\n"+
"border-radius: 6px;\n"+
"border: 2px solid #8f8f91;\n"+
"background-color: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #f6f7fa, stop: 1 #dadbde);\n"+
"}\n"+
"QPushButton:pressed {\n"+
"background-color: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #dadbde, stop: 1 #f6f7fa);\n"+
"}");
        SendMessage.setIcon(new QIcon(new QPixmap("classpath:com/fileosculator/images/icon/mail_send.png")));
        SendMessage.setIconSize(new QSize(22, 22));

        verticalLayout_2.addWidget(SendMessage);


        verticalLayout.addWidget(frame);

        MainUserWidget.setCentralWidget(centralwidget);
        retranslateUi(MainUserWidget);

        MainUserWidget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainUserWidget)
    {
        MainUserWidget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainUserWidget", "UserMainWindow", null));
        image.setText("");
        SendMessage.setText(com.trolltech.qt.core.QCoreApplication.translate("MainUserWidget", "Send Message", null));
    } // retranslateUi

}

