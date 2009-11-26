package com.fileosculator.handler;

import com.trolltech.qt.QSignalEmitter;

/**
 *
 * @author Ananth
 */
public class FileHandler extends QSignalEmitter
{

    private static FileHandler fileHandler;
    public Signal1<Long> fileReceived;
    public Signal2<Long, Integer> valueChanged;
    public Signal2<Long, Integer> marginChanged;
    public Signal1<Long> transferOver;
    public Signal2<Long, String> fileNameChanged;

    private FileHandler()
    {
        fileReceived = new Signal1<Long>();
        valueChanged = new Signal2<Long, Integer>();
        marginChanged = new Signal2<Long, Integer>();
        transferOver = new Signal1<Long>();
        fileNameChanged = new Signal2<Long, String>();
    }

    public static FileHandler getInstance()
    {
        if (fileHandler == null)
        {
            fileHandler = new FileHandler();
        }
        return fileHandler;
    }
}
