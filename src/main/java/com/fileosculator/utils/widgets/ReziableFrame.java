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

import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.MouseButton;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QWidget;

/**
 *
 * @author Ananth
 */
public class ReziableFrame extends QLabel
{

    //
    private QPoint m_old_pos;
    private boolean m_mouse_down;
    private boolean left, right, bottom;

    private QWidget parent;

    public ReziableFrame(QWidget parent)
    {
        super(parent);

        this.parent = parent;
        setSizePolicy(new QSizePolicy(QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Fixed));
        setMinimumSize(22,22);
        setPixmap(new QPixmap(("classpath:com/fileosculator/images/icon/resize-22.png")));
        setAlignment(Qt.AlignmentFlag.AlignRight);
        // Track the mouse
        setMouseTracking(true);
        show();
    }

    @Override
    public void mousePressEvent(QMouseEvent e)
    {
        m_old_pos = e.pos();
        m_mouse_down = e.button() == MouseButton.LeftButton;
    }

    @Override
    public void mouseMoveEvent(QMouseEvent e)
    {
        int x = e.x();
        int y = e.y();

        if (m_mouse_down)
        {
            int dx = x - m_old_pos.x();
            int dy = y - m_old_pos.y();

            QRect g = parent.geometry();

            if (left)
            {
                g.setLeft(g.left() + dx);
            }
            if (right)
            {
                g.setRight(g.right() + dx);
            }
            if (bottom)
            {
                g.setBottom(g.bottom() + dy);
            }

            parent.setGeometry(g);
            m_old_pos = new QPoint(!left ? e.x() : m_old_pos.x(), e.y());
        } else
        {
            
            QRect r = rect();

           left = Math.abs(x - r.left()) <= 7;
           right = Math.abs(x - r.right()) <= 7;
            bottom = Math.abs(y - r.bottom()) <= 7;
            boolean hor = left | right;

            if (hor && bottom)
            {
                if (left)
                {
                    setCursor(new QCursor(Qt.CursorShape.SizeBDiagCursor));
                } else
                {
                    setCursor(new QCursor(Qt.CursorShape.SizeFDiagCursor));
                }
            } else if (hor)
            {
                setCursor(new QCursor(Qt.CursorShape.SizeHorCursor));
            } else if (bottom)
            {
                setCursor(new QCursor(Qt.CursorShape.SizeVerCursor));
            } else
            {
                setCursor(new QCursor(Qt.CursorShape.ArrowCursor));
            }
        }
    }

    @Override
    public void mouseReleaseEvent(QMouseEvent e)
    {
        m_mouse_down = false;
    }
}
