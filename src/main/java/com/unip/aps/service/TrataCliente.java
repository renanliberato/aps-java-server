package com.unip.aps.service;

import com.unip.aps.exception.ServerCodeException;
import com.unip.aps.model.Client;

import java.util.Scanner;

/**
 * Created by gabri on 01/05/2017.
 */
public class TrataCliente implements Runnable{
    private Client client;

    /**
     * Inicia uma thread para o socket que se conectou.
     *
     * @param client Socket que se conectou na aplicação.
     */
    public TrataCliente(Client client){
        this.client = client;
    }

    /**
     * Inicia um loop pelo 'hasNextLine' aguardando por novas mensagens vindas do cliente conectado. Ao chegar
     * executa o método sendMessages.
     */
    @Override
    public void run() {
        try {

            RequestFilter filter = new RequestFilter(client);

            Scanner s = new Scanner(this.client.getInputStream());
            while(s.hasNextLine()) {
                String requestBody = s.nextLine();

                filter.filter(requestBody);
            }
            s.close();

        } catch (ServerCodeException e) {
            e.printStackTrace();
        }

    }

//    /**
//     * Envia a mensagem para todos os sockets que não sejam o que a enviou.
//     *
//     * @param message String para ser repassada para os clientes conectados.
//     */
//    private void sendMessage(String message) {
//        ServerHandler.getClientList().forEach(
//            (Client client) -> client.getOutputStream().println(message));
//    }
}
