/********************************************************************************
** Form generated from reading ui file 'FileReceiverWidget.jui'
**
** Created: Thu Nov 26 18:20:20 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_FileReceiver implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QVBoxLayout TitleLayout;
    public QFrame frame;
    public QVBoxLayout verticalLayout_2;
    public QLabel Filename;
    public QProgressBar Progressbar;

    public Ui_FileReceiver() { super(); }

    public void setupUi(QWidget FileReceiver)
    {
        FileReceiver.setObjectName("FileReceiver");
        FileReceiver.resize(new QSize(305, 123).expandedTo(FileReceiver.minimumSizeHint()));
        FileReceiver.setStyleSheet("QWidget#FileReceiver{\n"+
"\n"+
"background:white;\n"+
"}");
        verticalLayout = new QVBoxLayout(FileReceiver);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        TitleLayout = new QVBoxLayout();
        TitleLayout.setSpacing(0);
        TitleLayout.setObjectName("TitleLayout");

        verticalLayout.addLayout(TitleLayout);

        frame = new QFrame(FileReceiver);
        frame.setObjectName("frame");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(frame.sizePolicy().hasHeightForWidth());
        frame.setSizePolicy(sizePolicy);
        frame.setStyleSheet("QFrame#frame{\n"+
"border-width:3px;\n"+
"border-top-width:0;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"background:white;\n"+
"border-bottom-left-radius:10px;\n"+
"border-bottom-right-radius:10px;\n"+
"padding:3px;\n"+
"}");
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_2 = new QVBoxLayout(frame);
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setMargin(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        Filename = new QLabel(frame);
        Filename.setObjectName("Filename");

        verticalLayout_2.addWidget(Filename);

        Progressbar = new QProgressBar(frame);
        Progressbar.setObjectName("Progressbar");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(Progressbar.sizePolicy().hasHeightForWidth());
        Progressbar.setSizePolicy(sizePolicy1);
        Progressbar.setMaximum(0);
        Progressbar.setValue(-1);
        Progressbar.setTextVisible(false);

        verticalLayout_2.addWidget(Progressbar);


        verticalLayout.addWidget(frame);

        retranslateUi(FileReceiver);

        FileReceiver.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget FileReceiver)
    {
        FileReceiver.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("FileReceiver", "Form", null));
        Filename.setText(com.trolltech.qt.core.QCoreApplication.translate("FileReceiver", "TextLabel", null));
    } // retranslateUi

}

