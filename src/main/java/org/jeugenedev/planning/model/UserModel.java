package org.jeugenedev.planning.model;

import org.jeugenedev.planning.entity.MembersRoom;
import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.repos.MembersRoomRepos;
import org.jeugenedev.planning.repos.UserRepos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserModel {
    private final UserRepos userRepos;
    private final MembersRoomRepos membersRoomRepos;

    public UserModel(UserRepos userRepos, MembersRoomRepos membersRoomRepos) {
        this.userRepos = userRepos;
        this.membersRoomRepos = membersRoomRepos;
    }

    public List<Room> getUserRooms(User user) {
        return membersRoomRepos.findByUser(user).stream().map(MembersRoom::getRoom).toList();
    }
}
