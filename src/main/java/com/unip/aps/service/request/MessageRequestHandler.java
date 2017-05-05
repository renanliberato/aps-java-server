package com.unip.aps.service.request;

import com.unip.aps.core.Persistence;
import com.unip.aps.model.Client;
import com.unip.aps.model.Message;
import com.unip.aps.model.Request;
import com.unip.aps.model.RequestCode;
import com.unip.aps.service.ServerHandler;

import javax.persistence.EntityManager;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class MessageRequestHandler {

    public void execute(Request request) {
        Message message = Message.fromJson(request.getPayload());

        EntityManager entityManager = Persistence.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();

        request.setPayload(message.toJson());
        request.setCode(RequestCode.MESSAGE);

        String jsonResponse = request.toJson();

        ServerHandler.getClientList().forEach((Client client) -> client.getOutputStream().println(jsonResponse));
    }
}
