/********************************************************************************
** Form generated from reading ui file 'MessageWidget.jui'
**
** Created: Thu Nov 26 18:20:19 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MessageWidget implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QVBoxLayout TitleLayout;
    public QFrame MessageFrame;
    public QVBoxLayout verticalLayout_2;
    public QHBoxLayout horizontalLayout_2;
    public QLabel User;
    public QLabel Reply;
    public QFrame line;
    public QLabel Message;

    public Ui_MessageWidget() { super(); }

    public void setupUi(QWidget MessageWidget)
    {
        MessageWidget.setObjectName("MessageWidget");
        MessageWidget.resize(new QSize(312, 112).expandedTo(MessageWidget.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MessageWidget.sizePolicy().hasHeightForWidth());
        MessageWidget.setSizePolicy(sizePolicy);
        MessageWidget.setStyleSheet("QWidget#MessageWidget{\n"+
"\n"+
"background:white;\n"+
"border-width:3px;\n"+
"border-color:black;\n"+
"}\n"+
"\n"+
"QLabel#Message{\n"+
"background:white;\n"+
"}");
        verticalLayout = new QVBoxLayout(MessageWidget);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        TitleLayout = new QVBoxLayout();
        TitleLayout.setSpacing(0);
        TitleLayout.setObjectName("TitleLayout");

        verticalLayout.addLayout(TitleLayout);

        MessageFrame = new QFrame(MessageWidget);
        MessageFrame.setObjectName("MessageFrame");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(MessageFrame.sizePolicy().hasHeightForWidth());
        MessageFrame.setSizePolicy(sizePolicy1);
        MessageFrame.setStyleSheet("\n"+
"QFrame#MessageFrame{\n"+
"border-width:3px;\n"+
"border-top-width:0;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"background:white;\n"+
"border-bottom-left-radius:10px;\n"+
"border-bottom-right-radius:10px;\n"+
"padding:3px;\n"+
"\n"+
"}");
        MessageFrame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        MessageFrame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_2 = new QVBoxLayout(MessageFrame);
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setMargin(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setSpacing(0);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        User = new QLabel(MessageFrame);
        User.setObjectName("User");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(User.sizePolicy().hasHeightForWidth());
        User.setSizePolicy(sizePolicy2);
        User.setMinimumSize(new QSize(0, 30));
        User.setMaximumSize(new QSize(16777215, 30));
        QFont font = new QFont();
        font.setPointSize(12);
        User.setFont(font);
        User.setStyleSheet("\n"+
"QLabel#User{\n"+
"\n"+
"background:white;\n"+
"\n"+
"}");

        horizontalLayout_2.addWidget(User);

        Reply = new QLabel(MessageFrame);
        Reply.setObjectName("Reply");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(Reply.sizePolicy().hasHeightForWidth());
        Reply.setSizePolicy(sizePolicy3);
        Reply.setStyleSheet("QLabel#Reply{\n"+
"\n"+
"padding:0 10px;\n"+
"\n"+
"}\n"+
"\n"+
"QLabel#Reply:hover{\n"+
"color:red;\n"+
"}\n"+
"");

        horizontalLayout_2.addWidget(Reply);


        verticalLayout_2.addLayout(horizontalLayout_2);

        line = new QFrame(MessageFrame);
        line.setObjectName("line");
        line.setMinimumSize(new QSize(0, 5));
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);

        verticalLayout_2.addWidget(line);

        Message = new QLabel(MessageFrame);
        Message.setObjectName("Message");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(Message.sizePolicy().hasHeightForWidth());
        Message.setSizePolicy(sizePolicy4);
        Message.setMinimumSize(new QSize(300, 50));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        Message.setFont(font1);
        Message.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        Message.setStyleSheet("");
        Message.setScaledContents(true);
        Message.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        Message.setWordWrap(true);
        Message.setTextInteractionFlags(com.trolltech.qt.core.Qt.TextInteractionFlag.createQFlags(com.trolltech.qt.core.Qt.TextInteractionFlag.LinksAccessibleByMouse,com.trolltech.qt.core.Qt.TextInteractionFlag.TextSelectableByMouse));

        verticalLayout_2.addWidget(Message);


        verticalLayout.addWidget(MessageFrame);

        retranslateUi(MessageWidget);

        MessageWidget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget MessageWidget)
    {
        MessageWidget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MessageWidget", "Form", null));
        User.setText(com.trolltech.qt.core.QCoreApplication.translate("MessageWidget", "TextLabel", null));
        Reply.setText(com.trolltech.qt.core.QCoreApplication.translate("MessageWidget", "<a href='#' style='color:grey'>Reply<a>", null));
        Message.setText(com.trolltech.qt.core.QCoreApplication.translate("MessageWidget", "TextLabel", null));
    } // retranslateUi

}

