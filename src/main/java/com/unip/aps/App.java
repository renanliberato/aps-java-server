package com.unip.aps;

import com.unip.aps.alert.ErrorDialog;
import com.unip.aps.service.ServerHandler;

import java.io.IOException;

/**
 * Created on 2/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        try {
            // Inicializa a aplicação na porta passada.
            ServerHandler.init(666);
        } catch (IOException e) {
            e.printStackTrace();
            new ErrorDialog();
        }
    }
}
