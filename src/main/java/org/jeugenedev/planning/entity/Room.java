package org.jeugenedev.planning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {
    @Column(name = "room_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonIgnore
    private String hash;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;
    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Poll> polls;

    public Room() {}

    public Room(String hashLink, String title, User owner) {
        this.hash = hashLink;
        this.title = title;
        this.owner = owner;
    }
}
