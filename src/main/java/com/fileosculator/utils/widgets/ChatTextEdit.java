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

package com.fileosculator.utils.widgets;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QKeyEvent;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QTextEdit;
import com.trolltech.qt.gui.QWidget;

/**
 *
 * TextEdit box that handle
 * return key pressed event
 *
 * @author Ananth
 */
public class ChatTextEdit extends QTextEdit
{

    public Signal1<String> textEntered = new Signal1<String>();

    public ChatTextEdit(QWidget parent)
    {
        super(parent);
        setupUi();
    }

    public void setupUi()
    {
        setObjectName("chatTextEdit");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte) 0);
        sizePolicy1.setVerticalStretch((byte) 0);
        sizePolicy1.setHeightForWidth(sizePolicy().hasHeightForWidth());
        setSizePolicy(sizePolicy1);
        setMinimumSize(new QSize(150, 25));
        setMaximumSize(new QSize(16777215, 25));
    }

    @Override
    protected void keyPressEvent(QKeyEvent e)
    {
        if (e.key() == Qt.Key.Key_Return.value())
        {
            textEntered.emit(toPlainText());
            setText("");
        }
        super.keyPressEvent(e);
    }
}
