package br.com.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;

import static jakarta.persistence.CascadeType.ALL;

@Entity
public class User extends PanacheEntity {
    @NotEmpty
    private String name;
    @ManyToMany(cascade = ALL)
//    @JoinTable(name="CHANNEL_USER",
//                joinColumns = {@JoinColumn(name = "CHANNEL_ID")},
//                inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private ArrayList<Channel> channels;
    @OneToMany(cascade = ALL)
    @JoinColumn(name="id")
    private ArrayList<Message> messages;

    public User(){}
    public User(ArrayList<Channel> channels, ArrayList<Message> messages) {
        this.channels = channels;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
