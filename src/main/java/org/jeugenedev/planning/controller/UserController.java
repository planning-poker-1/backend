package org.jeugenedev.planning.controller;

import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.model.UserModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserModel userModel;

    public UserController(UserModel userModel) {
        this.userModel = userModel;
    }

    @RequestMapping(path = "/rooms/{user_id}", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Room> getUserRooms(@PathVariable(name = "user_id")User user) {
        return userModel.getUserRooms(user);
    }

    @RequestMapping(path = "/{user_id}", method = {RequestMethod.GET, RequestMethod.POST})
    public User getUser(@PathVariable(name = "user_id") User user) {
        return user;
    }
}
