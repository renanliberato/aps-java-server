package com.unip.aps.core;

import com.google.gson.Gson;
import com.unip.aps.model.Message;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
abstract public class AbstractEntity {

    /**
     * @return Uma string json com as propriedades do objeto que possuem valor.
     * Ex: {text : "Olá", username : "josecouves"}
     */
    public String toJson() {
        return new Gson().toJson(this);
    }
}
