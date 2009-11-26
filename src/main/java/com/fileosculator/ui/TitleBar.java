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

import com.fileosculator.ui.generated.Ui_TitleBar;
import com.trolltech.qt.core.QEvent;
import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QMouseEvent;
import com.trolltech.qt.gui.QPalette;
import com.trolltech.qt.gui.QWidget;

/**
 * Title bar of the application
 *
 * @author Ananth
 */
public class TitleBar extends QWidget
{

    // Generated Title Bar
    Ui_TitleBar titleBar = new Ui_TitleBar();
    boolean maxNormal;
    QPoint startPos;
    QPoint clickPos;

    /**
     * constructor
     * @param parent parent widget
     */
    public TitleBar(QWidget MainWindow)
    {
        titleBar.setupUi(this);

        QPalette col = palette();
        col.setColor(backgroundRole(), QColor.transparent);
        setPalette(col);

        setAutoFillBackground(true);
        maxNormal = false;
    }

    @Override
    public void mousePressEvent(QMouseEvent me)
    {
        startPos = me.globalPos();
        clickPos = mapToParent(me.pos());
    }

    @Override
    public void mouseMoveEvent(QMouseEvent me)
    {
        if (maxNormal)
        {
            return;
        }
        parentWidget().move(me.globalPos().subtract(clickPos));
    }

    @Override
    protected void enterEvent(QEvent arg__1)
    {

        // hide the MainUserWidget
        MainUserWidget.getInstance().hide();

        super.enterEvent(arg__1);
    }
}
