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
    private long expires;
    @Column(columnDefinition = "VARCHAR(1024)")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room owner;
    private boolean close;
}
