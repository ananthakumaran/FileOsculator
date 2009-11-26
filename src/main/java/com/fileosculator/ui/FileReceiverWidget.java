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
