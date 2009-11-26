/********************************************************************************
** Form generated from reading ui file 'TitleBar.jui'
**
** Created: Thu Nov 26 09:47:53 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_TitleBar implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QFrame TitleFrame;
    public QHBoxLayout horizontalLayout;
    public QLabel icon;
    public QLabel fileosculator;
    public QSpacerItem horizontalSpacer;
    public QToolButton close;

    public Ui_TitleBar() { super(); }

    public void setupUi(QWidget TitleBar)
    {
        TitleBar.setObjectName("TitleBar");
        TitleBar.resize(new QSize(200, 25).expandedTo(TitleBar.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(TitleBar.sizePolicy().hasHeightForWidth());
        TitleBar.setSizePolicy(sizePolicy);
        TitleBar.setMinimumSize(new QSize(200, 25));
        TitleBar.setAutoFillBackground(false);
        TitleBar.setStyleSheet("QWidget#TitleBar {\n"+
"\n"+
"\n"+
"background:qlineargradient(spread:pad, x1:0, y1:0, x2:0.568, y2:0.0340909, stop:0.0340909 rgba(43, 43, 43, 0));\n"+
"\n"+
"}");
        verticalLayout = new QVBoxLayout(TitleBar);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        TitleFrame = new QFrame(TitleBar);
        TitleFrame.setObjectName("TitleFrame");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(TitleFrame.sizePolicy().hasHeightForWidth());
        TitleFrame.setSizePolicy(sizePolicy1);
        TitleFrame.setStyleSheet("\n"+
"QFrame#TitleFrame{\n"+
"\n"+
"background:qlineargradient(spread:pad, x1:0.500682, y1:1, x2:0.5, y2:0.460864, stop:0 rgba(178, 199, 214, 0), stop:0.00568182 rgba(130, 135, 156, 255), stop:0.0227273 rgba(172, 173, 190, 255), stop:0.971591 rgba(209, 225, 253, 248), stop:1 rgba(208, 224, 253, 255));\n"+
"\n"+
"border-width:2px;\n"+
"border-bottom-width:0;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"\n"+
"border-top-left-radius:7px;\n"+
"border-top-right-radius:7px;\n"+
"\n"+
"padding: 0 5px 0 0;\n"+
"\n"+
"}");
        TitleFrame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        TitleFrame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout = new QHBoxLayout(TitleFrame);
        horizontalLayout.setSpacing(0);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        icon = new QLabel(TitleFrame);
        icon.setObjectName("icon");
        icon.setPixmap(new QPixmap(("classpath:com/fileosculator/images/icon/chat_22.png")));

        horizontalLayout.addWidget(icon);

        fileosculator = new QLabel(TitleFrame);
        fileosculator.setObjectName("fileosculator");
        fileosculator.setStyleSheet("QLabel#fileosculator{\n"+
"\n"+
"color:rgb(0, 0, 68);\n"+
"font:15px ;\n"+
"font-family:Helvetica;\n"+
"\n"+
"}");

        horizontalLayout.addWidget(fileosculator);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        close = new QToolButton(TitleFrame);
        close.setObjectName("close");
        close.setMinimumSize(new QSize(20, 16));
        close.setMaximumSize(new QSize(20, 16));
        close.setIcon(new QIcon(new QPixmap("classpath:com/fileosculator/images/icon/button-close-focused.png")));
        close.setIconSize(new QSize(20, 16));
        close.setAutoRepeat(false);
        close.setAutoExclusive(false);
        close.setAutoRaise(false);

        horizontalLayout.addWidget(close);


        verticalLayout.addWidget(TitleFrame);

        retranslateUi(TitleBar);

        TitleBar.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget TitleBar)
    {
        TitleBar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TitleBar", "Form", null));
        icon.setText("");
        fileosculator.setText(com.trolltech.qt.core.QCoreApplication.translate("TitleBar", "  File Osculator", null));
    } // retranslateUi

}

