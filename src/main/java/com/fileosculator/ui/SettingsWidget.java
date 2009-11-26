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
