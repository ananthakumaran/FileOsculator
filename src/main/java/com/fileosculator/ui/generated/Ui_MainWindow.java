/********************************************************************************
** Form generated from reading ui file 'MainWindow.jui'
**
** Created: Thu Nov 26 18:20:20 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QVBoxLayout TitleLayout;
    public QVBoxLayout UserListLayout;
    public QScrollArea scrollArea;
    public QWidget scrollAreaWidgetContents;
    public QVBoxLayout verticalLayout_3;
    public QSpacerItem verticalSpacer;
    public QHBoxLayout resize;
    public QFrame frame;
    public QHBoxLayout horizontalLayout_4;
    public QLabel settings;
    public QLabel about;
    public QSpacerItem horizontalSpacer;

    public Ui_MainWindow() { super(); }

    public void setupUi(QWidget MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(300, 393).expandedTo(MainWindow.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth());
        MainWindow.setSizePolicy(sizePolicy);
        MainWindow.setAcceptDrops(false);
        MainWindow.setWindowIcon(new QIcon(new QPixmap("classpath:com/fileosculator/images/icon/chat_48.png")));
        MainWindow.setAutoFillBackground(false);
        MainWindow.setStyleSheet("\n"+
"QWidget#scrollAreaWidgetContents{\n"+
"background:white;\n"+
"}\n"+
"\n"+
"\n"+
"\n"+
"\n"+
"\n"+
"");
        verticalLayout = new QVBoxLayout(MainWindow);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        verticalLayout.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        TitleLayout = new QVBoxLayout();
        TitleLayout.setSpacing(0);
        TitleLayout.setObjectName("TitleLayout");
        TitleLayout.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetNoConstraint);

        verticalLayout.addLayout(TitleLayout);

        UserListLayout = new QVBoxLayout();
        UserListLayout.setSpacing(0);
        UserListLayout.setObjectName("UserListLayout");
        scrollArea = new QScrollArea(MainWindow);
        scrollArea.setObjectName("scrollArea");
        scrollArea.setEnabled(true);
        scrollArea.setAcceptDrops(false);
        scrollArea.setAutoFillBackground(true);
        scrollArea.setStyleSheet("\n"+
"QScrollArea#scrollArea{\n"+
"\n"+
"border-width:0;\n"+
"\n"+
"}");
        scrollArea.setLineWidth(0);
        scrollArea.setWidgetResizable(true);
        scrollArea.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents");
        scrollAreaWidgetContents.setGeometry(new QRect(0, 0, 296, 361));
        scrollAreaWidgetContents.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        scrollAreaWidgetContents.setMouseTracking(true);
        scrollAreaWidgetContents.setAcceptDrops(false);
        scrollAreaWidgetContents.setAutoFillBackground(false);
        verticalLayout_3 = new QVBoxLayout(scrollAreaWidgetContents);
        verticalLayout_3.setSpacing(0);
        verticalLayout_3.setMargin(0);
        verticalLayout_3.setObjectName("verticalLayout_3");
        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout_3.addItem(verticalSpacer);

        scrollArea.setWidget(scrollAreaWidgetContents);

        UserListLayout.addWidget(scrollArea);


        verticalLayout.addLayout(UserListLayout);

        resize = new QHBoxLayout();
        resize.setObjectName("resize");
        frame = new QFrame(MainWindow);
        frame.setObjectName("frame");
        frame.setStyleSheet("\n"+
"QFrame#frame{\n"+
"\n"+
"background:white;\n"+
"\n"+
"\n"+
"border-width:1px;\n"+
"border-top-width:0;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"background:white;\n"+
"border-bottom-left-radius:10px;\n"+
"border-bottom-right-radius:10px;\n"+
"padding:0 0 3px 3px;\n"+
"\n"+
"}");
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout_4 = new QHBoxLayout(frame);
        horizontalLayout_4.setSpacing(5);
        horizontalLayout_4.setMargin(0);
        horizontalLayout_4.setObjectName("horizontalLayout_4");
        settings = new QLabel(frame);
        settings.setObjectName("settings");

        horizontalLayout_4.addWidget(settings);

        about = new QLabel(frame);
        about.setObjectName("about");
        about.setOpenExternalLinks(true);

        horizontalLayout_4.addWidget(about);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_4.addItem(horizontalSpacer);


        resize.addWidget(frame);


        verticalLayout.addLayout(resize);

        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Form", null));
        settings.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<a href='#'>settings</a>", null));
        about.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<a href='http://fileosculator.kenai.com'>about</a>", null));
    } // retranslateUi

}

