package org.jeugenedev.planning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Poll owner;
    private String content;
}
