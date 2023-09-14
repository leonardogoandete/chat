package br.com.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

import static jakarta.persistence.CascadeType.ALL;

@Entity
public class User extends PanacheEntity {
    @NotNull
    private long id;
    @NotEmpty
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private ArrayList<Channel> channels;
    @OneToMany(cascade = ALL)
    private ArrayList<Message> messages;
}
