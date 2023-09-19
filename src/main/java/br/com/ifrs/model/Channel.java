package br.com.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import static jakarta.persistence.CascadeType.ALL;


@Entity
public class Channel extends PanacheEntity {
    @NotEmpty
    private String hash;

    @ManyToMany(cascade = ALL)
    private ArrayList<User> users;

    @OneToMany(cascade = ALL)
    @JoinColumn(name="id")
    private ArrayList<Message> messages;

    public Channel(){}
    public Channel(ArrayList<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
