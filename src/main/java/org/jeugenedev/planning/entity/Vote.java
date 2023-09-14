package org.jeugenedev.planning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private long id;
    @JsonIgnore
    @ManyToOne
    private Poll poll;
    @ManyToOne
    private User voter;
    private String content;

    public Vote() {
    }

    public Vote(Poll poll, User voter, String content) {
        this.poll = poll;
        this.voter = voter;
        this.content = content;
    }
}
