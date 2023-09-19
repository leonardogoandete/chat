package br.com.ifrs.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
public class User extends PanacheEntity {

    private String name;

    @ManyToMany(cascade = ALL, fetch = FetchType.EAGER)
    @JoinTable(name="CHANNEL_USER",
                joinColumns = {@JoinColumn(name = "channel_id")},
                inverseJoinColumns = {@JoinColumn(name = "users_id")})
    @JsonManagedReference
    private List<Channel> channels = new ArrayList<>();
    @OneToMany(cascade = ALL)
    @JoinColumn(name="user_id")
    private List<Message> messages = new ArrayList<>();

    public User() {}

    public User(String name) {
        this.name = name;
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

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public void removeChannel(Channel channel) {
        this.channels.remove(channel);
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void removeMessage(Message message) {
        this.messages.remove(message);
    }

}
