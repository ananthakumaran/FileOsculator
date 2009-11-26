/********************************************************************************
** Form generated from reading ui file 'SettingsWidget.jui'
**
** Created: Thu Nov 26 09:47:53 2009
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.fileosculator.ui.generated;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Settings implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QVBoxLayout TitleLayout;
    public QFrame frame;
    public QFormLayout formLayout;
    public QLabel username;
    public QTextEdit usernametextEdit;
    public QLabel userimage;
    public QLabel change;
    public QLabel sampleimage;
    public QSpacerItem verticalSpacer_2;
    public QLabel update;

    public Ui_Settings() { super(); }

    public void setupUi(QWidget Settings)
    {
        Settings.setObjectName("Settings");
        Settings.resize(new QSize(386, 288).expandedTo(Settings.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(Settings.sizePolicy().hasHeightForWidth());
        Settings.setSizePolicy(sizePolicy);
        verticalLayout = new QVBoxLayout(Settings);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        TitleLayout = new QVBoxLayout();
        TitleLayout.setSpacing(0);
        TitleLayout.setObjectName("TitleLayout");

        verticalLayout.addLayout(TitleLayout);

        frame = new QFrame(Settings);
        frame.setObjectName("frame");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(frame.sizePolicy().hasHeightForWidth());
        frame.setSizePolicy(sizePolicy1);
        frame.setStyleSheet("QFrame#frame{\n"+
"border-width:3px;\n"+
"border-top-width:0;\n"+
"border-style:solid;\n"+
"border-color:grey;\n"+
"background:white;\n"+
"border-bottom-left-radius:10px;\n"+
"border-bottom-right-radius:10px;\n"+
"padding: 10px 3px;\n"+
"}");
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        formLayout = new QFormLayout(frame);
        formLayout.setObjectName("formLayout");
        formLayout.setFieldGrowthPolicy(com.trolltech.qt.gui.QFormLayout.FieldGrowthPolicy.ExpandingFieldsGrow);
        formLayout.setHorizontalSpacing(20);
        formLayout.setVerticalSpacing(20);
        formLayout.setContentsMargins(10, 5, 5, 5);
        username = new QLabel(frame);
        username.setObjectName("username");

        formLayout.addWidget(username);

        usernametextEdit = new QTextEdit(frame);
        usernametextEdit.setObjectName("usernametextEdit");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(usernametextEdit.sizePolicy().hasHeightForWidth());
        usernametextEdit.setSizePolicy(sizePolicy2);
        usernametextEdit.setMinimumSize(new QSize(0, 25));
        usernametextEdit.setMaximumSize(new QSize(16777215, 25));

        formLayout.addWidget(usernametextEdit);

        userimage = new QLabel(frame);
        userimage.setObjectName("userimage");

        formLayout.addWidget(userimage);

        change = new QLabel(frame);
        change.setObjectName("change");

        formLayout.addWidget(change);

        sampleimage = new QLabel(frame);
        sampleimage.setObjectName("sampleimage");

        formLayout.addWidget(sampleimage);

        verticalSpacer_2 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        formLayout.addItem(verticalSpacer_2);

        update = new QLabel(frame);
        update.setObjectName("update");
        update.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        formLayout.addWidget(update);


        verticalLayout.addWidget(frame);

        username.setBuddy(usernametextEdit);
        retranslateUi(Settings);

        Settings.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Settings)
    {
        Settings.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Settings", "Form", null));
        username.setText(com.trolltech.qt.core.QCoreApplication.translate("Settings", "User Name     ", null));
        userimage.setText(com.trolltech.qt.core.QCoreApplication.translate("Settings", "User Image", null));
        change.setText(com.trolltech.qt.core.QCoreApplication.translate("Settings", "<html>\n"+
"<head>\n"+
"<style>\n"+
"a{\n"+
"color:grey;\n"+
"}\n"+
"\n"+
"a:hover{\n"+
"color:red;\n"+
"}\n"+
"\n"+
"</style>\n"+
"</head>\n"+
"<body>\n"+
"<a href='#' >change</a>\n"+
"</body>\n"+
"</html>\n"+
"", null));
        sampleimage.setText("");
        update.setText(com.trolltech.qt.core.QCoreApplication.translate("Settings", "<a href='#' style='color:grey'>update</a>(click update and  then restart)", null));
    } // retranslateUi

}

