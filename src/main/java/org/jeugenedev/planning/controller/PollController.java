package org.jeugenedev.planning.controller;

import org.jeugenedev.planning.entity.Poll;
import org.jeugenedev.planning.entity.Room;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.entity.Vote;
import org.jeugenedev.planning.model.PollModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollModel pollModel;

    public PollController(PollModel pollModel) {
        this.pollModel = pollModel;
    }

    @RequestMapping(path = "/{poll_id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Poll getPoll(@PathVariable(name = "poll_id") Poll poll) {
        return pollModel.getPoll(poll);
    }

    @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Poll> getRoomPolls(@RequestParam(name = "room_id") Room room) {
        return pollModel.getRoomPolls(room);
    }

    @RequestMapping(path = "/{poll_id}/vote", method = {RequestMethod.GET, RequestMethod.POST})
    public Vote vote(@PathVariable(name = "poll_id") Poll poll,
                     @RequestParam(name = "user_id") User user,
                     @RequestParam String content) {
        return pollModel.vote(user, poll, content);
    }

    @RequestMapping(path = "/{poll_id}/votes", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Vote> getPollVotes(@PathVariable(name = "poll_id") Poll poll) {
        return pollModel.getPollVotes(poll);
    }
}
