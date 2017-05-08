package com.unip.aps;

import com.unip.aps.core.Persistence;
import com.unip.aps.service.ServerHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 2/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new Exception("Falta informar a porta como argumento");
            }
            Persistence.getEntityManager();
            System.out.println("DB iniciado");
            // Inicializa a aplicação na porta passada.
            int port = Integer.valueOf(args[0]);

            System.out.println("Servidor escutando a porta "+port);
            ServerHandler.init(port);
        } catch (IOException e) {
            System.out.println("Não foi possível inicializar o servidor.");
        } catch (Exception e) {
            System.out.println("Falta informar a porta como argumento");
        }
    }
}
