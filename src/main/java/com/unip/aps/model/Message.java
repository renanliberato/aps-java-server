package com.unip.aps.model;

import com.google.gson.Gson;
import com.unip.aps.core.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on 12/4/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
@Entity
public class Message extends AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String text;

    private String username;

    public Message() {}

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
    }

    public Message(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Cria uma mensagem de uma string json
     *
     * @param json
     *
     * @return
     */
    public static Message fromJson(String json) {
        return new Gson().fromJson(json, Message.class);
    }
}
