package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.MembersRoom;
import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MembersRoomRepos extends JpaRepository<MembersRoom, UUID> {
    List<MembersRoom> findByUser(User user);
    List<MembersRoom> findByRoom(Room room);
}
