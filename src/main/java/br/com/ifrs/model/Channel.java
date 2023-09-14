package br.com.ifrs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Channel extends PanacheEntity {
    @NotNull
    private long id;
    @NotEmpty
    private String hash;

    @ManyToMany(cascade = PERSIST, mappedBy = "User")
    private ArrayList<User> users;

    @OneToMany(cascade = ALL)
    private ArrayList<Message> messages;


}
