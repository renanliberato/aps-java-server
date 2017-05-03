package com.unip.aps.model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created on 3/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Client {

    /**
     * Socket do cliente conectado
     */
    private Socket socket;

    /**
     * PrintStream criado para
     */
    private PrintStream stream;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.stream = new PrintStream(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintStream getStream() {
        return stream;
    }
}
