package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepos extends JpaRepository<Room, Long> {
    Optional<Room> findByHash(String hash);
}
