package org.jeugenedev.planning.model;

import org.jeugenedev.planning.entity.MembersRoom;
import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.exceptions.AccessDeniedException;
import org.jeugenedev.planning.exceptions.RoomNotFoundException;
import org.jeugenedev.planning.exceptions.UserAlreadyAddedException;
import org.jeugenedev.planning.repos.MembersRoomRepos;
import org.jeugenedev.planning.repos.RoomRepos;
import org.jeugenedev.planning.utils.crypto.CryptoUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class RoomModel {
    private final RoomRepos roomRepos;
    private final MembersRoomRepos membersRoomRepos;
    private final CryptoUtils cryptoUtils;

    public RoomModel(RoomRepos roomRepos, MembersRoomRepos membersRoomRepos, CryptoUtils cryptoUtils) {
        this.roomRepos = roomRepos;
        this.membersRoomRepos = membersRoomRepos;
        this.cryptoUtils = cryptoUtils;
    }

    public Room createRoom(User owner, String title) {
        Room room = roomRepos.save(new Room(cryptoUtils.md5(UUID.randomUUID().toString()), title, owner));
        membersRoomRepos.save(new MembersRoom(owner, room));
        return room;
    }

    public List<User> getRoomUsers(Room room) {
        return membersRoomRepos.findByRoom(room).stream().map(MembersRoom::getUser).toList();
    }

    public Room addUser(User user, Room room) {
        return membersRoomRepos.save(new MembersRoom(user, room)).getRoom();
    }

    public Room join(User user, String hash) {
        Room room = roomRepos.findByHash(hash).orElseThrow(RoomNotFoundException::new);
        for(MembersRoom membersRoom : membersRoomRepos.findByRoom(room)) {
            if(membersRoom.getUser().getId() == user.getId()) {
                throw new UserAlreadyAddedException();
            }
        }
        membersRoomRepos.save(new MembersRoom(user, room));
        return room;
    }

    public Map<String, String> getRoomLink(User user, Room room) {
        if(room.getOwner().getId() != user.getId()) {
            throw new AccessDeniedException();
        }
        return Collections.singletonMap("link", room.getHash());
    }
}
