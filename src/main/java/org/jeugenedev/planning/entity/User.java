package org.jeugenedev.planning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String username;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Room> rooms;
}
