package org.jeugenedev.planning.controller;

import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.model.RoomModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomModel roomModel;

    public RoomController(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    @RequestMapping(path = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    public Room createRoom(@RequestParam(name = "owner_id") User owner,
                             @RequestParam String title) {
        return roomModel.createRoom(owner, title);
    }

    @RequestMapping(path = "/users/{room_id}", method = {RequestMethod.GET, RequestMethod.POST})
    public List<User> getRoomUsers(@PathVariable(name = "room_id") Room room) {
        return roomModel.getRoomUsers(room);
    }

    @RequestMapping(path = "/{room_id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Room getRoom(@PathVariable(name = "room_id") Room room) {
        return room;
    }

    @RequestMapping(path = "/addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public Room addUser(@RequestParam(name = "user_id") User user, @RequestParam(name = "room_id") Room room) {
        return roomModel.addUser(user, room);
    }

    @RequestMapping(path = "/join/{hash}", method = {RequestMethod.GET, RequestMethod.POST})
    public Room join(@PathVariable String hash, @RequestParam(name = "user_id") User user) {
        return roomModel.join(user, hash);
    }

    @RequestMapping(path = "/getLink", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> getRoomLink(@RequestParam(name = "user_id") User user, @RequestParam(name = "room_id") Room room) {
        return roomModel.getRoomLink(user, room);
    }
}
