package com.fileosculator.ui;

import com.fileosculator.App;
import com.fileosculator.ui.generated.Ui_Settings;
import com.fileosculator.users.CurrentUser;
import com.fileosculator.utils.widgets.FrameLessWidget;
import com.trolltech.qt.core.Qt.AspectRatioMode;
import com.trolltech.qt.gui.QFileDialog;
import com.trolltech.qt.gui.QImage;
import com.trolltech.qt.gui.QPixmap;

/**
 *
 * @author Ananth
 */
public class SettingsWidget extends FrameLessWidget
{

    private Ui_Settings settingsWidget = new Ui_Settings();
    // Title Bar of the Window
    private TitleBar titleBar;

    public SettingsWidget()
    {
        settingsWidget.setupUi(this);
        addTitleBar();
        show();


        settingsWidget.update.linkActivated.connect(this, "updateSettings()");
        settingsWidget.change.linkActivated.connect(this, "changeImage()");
    }

    /**
     * adds titleBar to the Main Window
     */
    private void addTitleBar()
    {
        titleBar = new TitleBar(this);
        settingsWidget.TitleLayout.addWidget(titleBar);
        titleBar.titleBar.close.clicked.connect(this, "close()");
    }

    private void updateSettings()
    {
        String username = settingsWidget.usernametextEdit.toPlainText();
        if (!username.equals(""))
        {
            CurrentUser.getUserInstance().setUserName(username);
        }
        CurrentUser.update();
        close();
    }

    private void changeImage()
    {
        String fileName = QFileDialog.getOpenFileName(this, "select the Image", "", new QFileDialog.Filter("Image Files (*.png *.jpg *.bmp)"));
        QImage image = new QImage(fileName);
        image = image.scaled(128, 128, AspectRatioMode.IgnoreAspectRatio);
        image.convertToFormat(QImage.Format.Format_ARGB32);
        QPixmap userpix = QPixmap.fromImage(image);
        CurrentUser.getUserInstance().setLargeIcon(userpix);

        image = image.scaled(48, 48, AspectRatioMode.IgnoreAspectRatio);

        QPixmap smallpix = QPixmap.fromImage(image);
        CurrentUser.getUserInstance().setSmallIcon(smallpix);

        settingsWidget.sampleimage.setPixmap(userpix);
    }
}
