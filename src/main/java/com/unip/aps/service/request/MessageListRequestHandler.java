package com.unip.aps.service.request;

import com.google.gson.Gson;
import com.unip.aps.core.Persistence;
import com.unip.aps.model.Client;
import com.unip.aps.model.Message;
import com.unip.aps.model.Request;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class MessageListRequestHandler {

    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    public void execute(Request request) {
        String jsonMessages = new Gson().toJson(getMessages());

        request.setPayload(jsonMessages);

        client.getOutputStream().println(request.toJson());
    }

    public List<Message> getMessages() {
        EntityManager entityManager = Persistence.getEntityManager();
        CriteriaQuery<Message> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Message.class);
        criteriaQuery.from(Message.class);
        entityManager.createQuery(criteriaQuery);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
