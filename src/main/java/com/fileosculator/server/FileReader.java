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
package com.fileosculator.server;

import com.fileosculator.handler.FileHandler;
import com.fileosculator.message.Message;
import com.fileosculator.utils.Const;
import com.trolltech.qt.gui.QFileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ananth
 */
public class FileReader implements Runnable
{

    private Message message;
    private ObjectInputStream objectInputStream;
    private Long id;

    public FileReader(Message message, ObjectInputStream objectInputStream)
    {
        this.message = message;
        this.objectInputStream = objectInputStream;
    }

    public void run()
    {
        FileOutputStream fileOutputStream = null;
        try
        {
            int totalDataRead = 0;
            int totalSizeWritten = 0;
            byte[] inData = new byte[Const.PACKET_SIZE];
            long flength = objectInputStream.readLong();

            String folderName = QFileDialog.getExistingDirectory();

            File file = new File(folderName, message.getFileName());
            fileOutputStream = new FileOutputStream(file);

            id = new Date().getTime();

            FileHandler fileHandler = FileHandler.getInstance();

            fileHandler.fileReceived.emit(id);

            fileHandler.fileNameChanged.emit(id, message.getFileName());
            fileHandler.marginChanged.emit(id, (int) flength);
            System.out.println(file.getAbsolutePath());

            // used to slow up the rate at whic the ui is updated
            int slowup = 0;

            while (totalSizeWritten < flength && totalDataRead != -1)
            {
                if (flength - totalSizeWritten < Const.PACKET_SIZE)
                {
                    totalDataRead = objectInputStream.read(inData, 0, (int) (flength - totalSizeWritten));
                    if (totalDataRead != -1)
                    {
                        fileOutputStream.write(inData, 0, totalDataRead);
                    }
                } else
                {
                    totalDataRead = objectInputStream.read(inData);
                    if (totalDataRead != -1)
                    {
                        fileOutputStream.write(inData, 0, totalDataRead);
                    }
                    fileOutputStream.flush();
                }
                totalSizeWritten += totalDataRead;

                if (slowup++ == 500)
                {
                    fileHandler.valueChanged.emit(id, totalSizeWritten);
                    slowup = 0;
                }
            }
            fileHandler.valueChanged.emit(id, totalSizeWritten);
        } catch (IOException ex)
        {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                FileHandler.getInstance().transferOver.emit(id);
                fileOutputStream.close();
            } catch (Exception ex)
            {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
