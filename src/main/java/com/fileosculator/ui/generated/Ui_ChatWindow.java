/********************************************************************************
** Form generated from reading ui file 'ChatWindow.jui'
**
** Created: Thu Nov 26 18:20:20 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_ChatWindow implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout ChatWindowLayout;
    public QVBoxLayout TitleLayout;
    public QVBoxLayout ChatLayout;
    public QListWidget ChatlistWidget;

    public Ui_ChatWindow() { super(); }

    public void setupUi(QWidget ChatWindow)
    {
        ChatWindow.setObjectName("ChatWindow");
        ChatWindow.resize(new QSize(258, 200).expandedTo(ChatWindow.minimumSizeHint()));
        ChatWindowLayout = new QVBoxLayout(ChatWindow);
        ChatWindowLayout.setSpacing(0);
        ChatWindowLayout.setMargin(0);
        ChatWindowLayout.setObjectName("ChatWindowLayout");
        TitleLayout = new QVBoxLayout();
        TitleLayout.setObjectName("TitleLayout");

        ChatWindowLayout.addLayout(TitleLayout);

        ChatLayout = new QVBoxLayout();
        ChatLayout.setObjectName("ChatLayout");
        ChatlistWidget = new QListWidget(ChatWindow);
        ChatlistWidget.setObjectName("ChatlistWidget");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(ChatlistWidget.sizePolicy().hasHeightForWidth());
        ChatlistWidget.setSizePolicy(sizePolicy);

        ChatLayout.addWidget(ChatlistWidget);


        ChatWindowLayout.addLayout(ChatLayout);

        retranslateUi(ChatWindow);

        ChatWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget ChatWindow)
    {
        ChatWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("ChatWindow", "Form", null));
    } // retranslateUi

}

