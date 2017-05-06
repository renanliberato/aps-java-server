package com.unip.aps;

import com.unip.aps.core.Persistence;
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
            Persistence.getEntityManager();
            System.out.println("DB iniciado");
            // Inicializa a aplicação na porta passada.
            int port = 666;
            System.out.println("Servidor escutando a porta "+port);
            ServerHandler.init(port);
        } catch (IOException e) {
            System.out.println("Não foi possível inicializar o servidor.");
        }
    }
}
