/********************************************************************************
** Form generated from reading ui file 'UserWidget.jui'
**
** Created: Thu Nov 26 09:47:53 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_UserWidget implements com.trolltech.qt.QUiForm<QWidget>
{
    public QHBoxLayout horizontalLayout;
    public QLabel label;
    public QLabel userimage;

    public Ui_UserWidget() { super(); }

    public void setupUi(QWidget UserWidget)
    {
        UserWidget.setObjectName("UserWidget");
        UserWidget.resize(new QSize(250, 50).expandedTo(UserWidget.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(UserWidget.sizePolicy().hasHeightForWidth());
        UserWidget.setSizePolicy(sizePolicy);
        UserWidget.setMinimumSize(new QSize(250, 50));
        UserWidget.setMouseTracking(true);
        UserWidget.setContextMenuPolicy(com.trolltech.qt.core.Qt.ContextMenuPolicy.DefaultContextMenu);
        UserWidget.setAcceptDrops(false);
        UserWidget.setAutoFillBackground(true);
        UserWidget.setStyleSheet("\n"+
"\n"+
"QLabel#label{\n"+
"background:white;\n"+
"padding: 10px 10px;\n"+
"font: 12px;\n"+
"}\n"+
"\n"+
"QLabel#label:hover{\n"+
"padding: 20px 20px;\n"+
"font:14px;\n"+
"background:qconicalgradient(cx:0, cy:0, angle:135, stop:0 rgba(220, 221, 204, 69), stop:0.0681818 rgba(255, 218, 71, 130), stop:0.147727 rgba(247, 255, 0, 208), stop:0.153409 rgba(255, 255, 0, 255), stop:0.159091 rgba(255, 255, 0, 69), stop:0.1875 rgba(251, 255, 0, 145), stop:0.198864 rgba(255, 244, 71, 130), stop:0.375 rgba(255, 255, 0, 69), stop:1 rgba(255, 255, 0, 69));\n"+
"}");
        horizontalLayout = new QHBoxLayout(UserWidget);
        horizontalLayout.setSpacing(3);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        label = new QLabel(UserWidget);
        label.setObjectName("label");
        label.setMinimumSize(new QSize(0, 0));
        label.setAcceptDrops(false);
        label.setAutoFillBackground(false);

        horizontalLayout.addWidget(label);

        userimage = new QLabel(UserWidget);
        userimage.setObjectName("userimage");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(userimage.sizePolicy().hasHeightForWidth());
        userimage.setSizePolicy(sizePolicy1);
        userimage.setMinimumSize(new QSize(48, 48));
        userimage.setAcceptDrops(false);

        horizontalLayout.addWidget(userimage);

        retranslateUi(UserWidget);

        UserWidget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UserWidget)
    {
        UserWidget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UserWidget", "Form", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("UserWidget", "User Name", null));
        userimage.setText("");
    } // retranslateUi

}

