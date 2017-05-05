package com.unip.aps.service;

import com.unip.aps.model.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 01/05/2017.
 */
public class ServerHandler {

    /**
     * @TODO Validar se quando um cliente se desconecta ele continua na lista.
     *
     * Lista de clientes conectados na aplicação. A chave é o IP do cliente conectado, e o valor é uma instância
     * da classe Socket.
     */
    private static List<Client> clientList = new ArrayList<>();

    /**
     * Inicializa o servidor e inicia um loop. Para cada cliente que se conecte no servidor é inicializada uma nova Thread
     * na aplicação para tratar as mensagens enviadas por ele.
     *
     * @param port
     * @throws IOException
     */
    public static void init(int port) throws IOException {
        // abertura de porta
        ServerSocket servidor = new ServerSocket(port);

        while (true) {
            // aceita cliente e imprime cliente conectado
            Socket clientSocket = servidor.accept();

            Client client = new Client(clientSocket);
            clientList.add(client);

            // cria tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(client);
            new Thread(tc).start();
        }
    }

    public static List<Client> getClientList() {
        return clientList;
    }
}
