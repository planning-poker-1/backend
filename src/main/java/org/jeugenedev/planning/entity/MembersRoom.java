package org.jeugenedev.planning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class MembersRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @ManyToOne
    private User user;
    @ManyToOne
    private Room room;
    @Column(unique = true)
    private String uniqueField;

    public MembersRoom() {
    }

    public MembersRoom(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    public String getUniqueField() {
        return room.getId() + " " + user.getId();
    }
}
