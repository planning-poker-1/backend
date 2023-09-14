package org.jeugenedev.planning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private long id;
    private long expires;
    @Column(columnDefinition = "VARCHAR(1024)")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room owner;
    private boolean close = false;

    public Poll() {
    }

    public Poll(long expires, String description, Room owner) {
        this.expires = expires;
        this.description = description;
        this.owner = owner;
    }
}
