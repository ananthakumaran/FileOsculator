package com.fileosculator.handler;

import com.fileosculator.message.Message;
import com.trolltech.qt.QSignalEmitter;

/**
 *
 * @author Ananth
 */
public class FileRequestHandler extends QSignalEmitter
{

    private static FileRequestHandler fileRequestHandler;
    public Signal1<Message> fileReceived;

    private FileRequestHandler()
    {
        fileReceived = new Signal1<Message>();

    }

    public static FileRequestHandler getInstance()
    {
        if (fileRequestHandler == null)
        {
            fileRequestHandler = new FileRequestHandler();
        }
        return fileRequestHandler;
    }
}
