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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fileosculator.server;

import com.fileosculator.handler.FileHandler;
import com.fileosculator.utils.Const;
import com.trolltech.qt.gui.QFileDialog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * reads multiple files or folder send by other
 * peer and writes it in the disk
 *
 * @author Ananth
 */
public class FolderReader implements Runnable
{

    /** Zip outputstream */
    private ZipInputStream inputStream;

    Long id;

    /**
     * constructor
     * @param inputStream stream contains the zipped data
     */
    public FolderReader(InputStream inputStream)
    {
        this.inputStream = new ZipInputStream(inputStream);
    }

    public void run()
    {
        // Destination folder
        String folderName = QFileDialog.getExistingDirectory();

        FileHandler fileHandler = FileHandler.getInstance();
        id = new Date().getTime();

        fileHandler.fileReceived.emit(id);

        try
        {
            ZipEntry entry;
            while ((entry = inputStream.getNextEntry()) != null)
            {
                System.out.println("Extracting: " + entry);
                fileHandler.fileNameChanged.emit(id, entry.getName());
                int count;
                byte[] data = new byte[Const.PACKET_SIZE];
                if (entry.isDirectory())
                {
                    File f = new File(folderName + File.separator + entry.getName());
                    f.mkdirs();
                } else
                {
                    // write the files to the disk
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(folderName + File.separator + entry.getName()));
                    while ((count = inputStream.read(data, 0, Const.PACKET_SIZE)) != -1)
                    {
                        outputStream.write(data, 0, count);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            inputStream.close();
        } catch (IOException ex)
        {
            Logger.getLogger(FolderReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            fileHandler.transferOver.emit(id);
        }
    }
}
