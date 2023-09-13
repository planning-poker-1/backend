package org.jeugenedev.planning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room owner;
}
