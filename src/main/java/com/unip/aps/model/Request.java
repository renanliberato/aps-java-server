package com.unip.aps.model;

import com.google.gson.Gson;
import com.unip.aps.core.AbstractEntity;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Request extends AbstractEntity {

    private Integer code;

    private String payload;

    public Request() {
    }

    public Request(Integer code, String payload) {
        this.code = code;
        this.payload = payload;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setCode(RequestCode code) {
        this.code = code.ordinal();
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * Cria uma mensagem de uma string json
     *
     * @param json
     *
     * @return
     */
    public static Request fromJson(String json) {
        return new Gson().fromJson(json, Request.class);
    }
}
