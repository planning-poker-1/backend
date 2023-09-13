package org.jeugenedev.planning.entity;

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
    private String uuid;
    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> administrators;
    @OneToMany(mappedBy = "owner")
    private List<Poll> polls;
}
