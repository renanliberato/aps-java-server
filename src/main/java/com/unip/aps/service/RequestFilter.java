package com.unip.aps.service;

import com.unip.aps.exception.ServerCodeException;
import com.unip.aps.model.Client;
import com.unip.aps.model.Request;
import com.unip.aps.model.RequestCode;
import com.unip.aps.service.request.MessageListRequestHandler;
import com.unip.aps.service.request.MessageRequestHandler;

import static com.unip.aps.model.RequestCode.MESSAGE;
import static com.unip.aps.model.RequestCode.MESSAGE_LIST;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class RequestFilter {

    private Client client;

    public void filter(String requestBody) throws ServerCodeException {
        Request request = Request.fromJson(requestBody);

        RequestCode requestCode = RequestCode.fromInteger(request.getCode());
        switch (requestCode) {
            case MESSAGE:
                MessageRequestHandler messageRequestHandler = new MessageRequestHandler();
                messageRequestHandler.execute(request);
                break;
            case MESSAGE_LIST:
                MessageListRequestHandler messageListRequestHandler = new MessageListRequestHandler(client);
                messageListRequestHandler.execute(request);
                break;
            default:
                throw new ServerCodeException("The incoming request isn't from a recognized type.");
        }
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
