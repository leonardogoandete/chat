package br.com.ifrs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;


@Entity
public class Channel extends PanacheEntity {
    private String hash;

    @ManyToMany(mappedBy="channels", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    @OneToMany(cascade = ALL)
    @JoinColumn(name="channel_id")
    private List<Message> messages = new ArrayList<>();

    public Channel() {}

    public Channel(Message message, String hash) {
        this.messages.add(message);
        this.hash = hash;
    }

    public Channel(User user, Message message, String hash) {
        this.users.add(user);
        this.messages.add(message);
        this.hash = hash;
    }
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void removeMessage(Message message) {
        this.messages.remove(message);
    }

}
