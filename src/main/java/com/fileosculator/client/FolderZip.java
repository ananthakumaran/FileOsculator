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

package com.fileosculator.client;

import com.fileosculator.utils.Const;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * used to send multiple files or folder
 * over the network
 * @author Ananth
 */
public class FolderZip
{

    /** Stream where the zipped entry should go */
    private ZipOutputStream outputStream;
    /** List of files or folder to be zipped */
    private List<String> fileNames;

    /**
     * constructor
     * @param fileNames list of the file names to be added to the outputstream
     * @param outputStream outputstream where the data will be written
     */
    public FolderZip(OutputStream outputStream, List<String> fileNames)
    {
        this.outputStream = new ZipOutputStream(outputStream);
        this.outputStream.setLevel(ZipOutputStream.STORED);
        this.fileNames = fileNames;
        zip();
    }

    /**
     * archive all the files/folders in the
     * list
     */
    public void zip()
    {
        for (String fileName : fileNames)
        {
            addToZip("", fileName);
        }
        try
        {
            outputStream.close();
        } catch (IOException ex)
        {
            Logger.getLogger(FolderZip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * adds the given file or folder to the
     * zip stream
     * @param path relative path for file in the zip stream
     * @param fileName absolute path of the file
     */
    public void addToZip(String path, String fileName)
    {
        File file = new File(fileName);

        if (file.isDirectory())
        {
            try
            {
                // add a directory entry in the zip stream
                ZipEntry entry = new ZipEntry(path + File.separator + file.getName() + "/");
                outputStream.putNextEntry(entry);
                outputStream.flush();
                // process other files in the zip stream
                addFolder(path, fileName);
            } catch (IOException ex)
            {
                Logger.getLogger(FolderZip.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            try
            {
                // write the file contents to the zip stream
                BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(file));
                ZipEntry entry = new ZipEntry(path + File.separator + file.getName());
                outputStream.putNextEntry(entry);
                byte data[] = new byte[Const.PACKET_SIZE];
                int count;
                while ((count = fileStream.read(data, 0,
                        Const.PACKET_SIZE)) != -1)
                {
                    outputStream.write(data, 0, count);
                }
                outputStream.flush();
                fileStream.close();
            } catch (IOException ex)
            {
                Logger.getLogger(FolderZip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * adds all the file in the given folder to
     * the zip stream
     * @param path relative path of the folder in the zip stream
     * @param folderName absolute path of the directory 
     *
     */
    public void addFolder(String path, String folderName)
    {

        File folder = new File(folderName);
        for (String file : folder.list())
        {
            addToZip(path + File.separator + folder.getName(), folderName + File.separator + file);
        }
    }
}
