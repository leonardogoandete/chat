package br.com.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Message extends PanacheEntity {

    private String text;

    @ManyToOne
    private Channel channel;

    @ManyToOne
    private User user;

    public Message(){}
    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Message(Channel channel, String text) {
        this.user = user;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
