package com.unip.aps.service;

import com.unip.aps.model.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by gabri on 01/05/2017.
 */
public class TrataCliente implements Runnable{
    private Socket clientSocket;

    /**
     * Inicia uma thread para o socket que se conectou.
     *
     * @param clientSocket Socket que se conectou na aplicação.
     */
    public TrataCliente(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    /**
     * Inicia um loop pelo 'hasNextLine' aguardando por novas mensagens vindas do cliente conectado. Ao chegar
     * executa o método sendMessages.
     */
    @Override
    public void run() {
        try {
            Scanner s = new Scanner(this.clientSocket.getInputStream());

            while(s.hasNextLine()) {
                this.sendMessages(s.nextLine());
            }
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Envia a mensagem para todos os sockets que não sejam o que a enviou.
     *
     * @param message String para ser repassada para os clientes conectados.
     */
    private void sendMessages(String message) {
        ServerHandler.getClientList().forEach((String address, Client client) -> {
            if (!clientSocket.getRemoteSocketAddress().toString().equals(address)) {
                client.getStream().println(message);
            }
        });
    }
}
