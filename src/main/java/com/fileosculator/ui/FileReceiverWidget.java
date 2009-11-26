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
 *     contacts <ananthakumaran[at]gmail.com>
 */

package com.fileosculator.ui;

import com.fileosculator.ui.generated.Ui_FileReceiver;
import com.fileosculator.utils.widgets.FrameLessWidget;
import com.trolltech.qt.core.Qt.FocusReason;

/**
 *
 * @author Ananth
 */
public class FileReceiverWidget extends FrameLessWidget
{

    private Ui_FileReceiver fileReceiver = new Ui_FileReceiver();
    /** Title Bar of the Window */
    private TitleBar titleBar;

    public FileReceiverWidget()
    {
        fileReceiver.setupUi(this);
        addTitleBar();
        show();
        setFocus(FocusReason.PopupFocusReason);
    }

    public void onValueChanged(Integer value)
    {
        System.out.println(" value changed");
        fileReceiver.Progressbar.setValue(value);
    }

    public void onMarginChanged(Integer value)
    {
        System.out.println("margin changed");
        fileReceiver.Progressbar.setMaximum(value);
    }

    public void onFileNameChange(String fileName)
    {
        fileReceiver.Filename.setText("Downloading " + fileName);
    }

    public void onTransferOver()
    {

        System.out.println("closing ");
        //   hide();
        close();
        dispose();
    }

    /**
     * adds titleBar to the Main Window
     */
    private void addTitleBar()
    {
        titleBar = new TitleBar(this);
        fileReceiver.TitleLayout.addWidget(titleBar);
        titleBar.titleBar.close.clicked.connect(this, "close()");
    }
}
