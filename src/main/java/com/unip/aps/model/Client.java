package com.unip.aps.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created on 3/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Client {

    private InputStream inputStream;
    /**
     * Socket do cliente conectado
     */
    private Socket socket;

    /**
     * PrintStream criado para
     */
    private PrintStream outputStream;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.outputStream = new PrintStream(socket.getOutputStream());
        this.inputStream = socket.getInputStream();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public PrintStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
