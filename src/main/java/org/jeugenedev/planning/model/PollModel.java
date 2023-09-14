package org.jeugenedev.planning.model;

import org.jeugenedev.planning.entity.*;
import org.jeugenedev.planning.exceptions.AccessDeniedException;
import org.jeugenedev.planning.exceptions.UserAlreadyAddedException;
import org.jeugenedev.planning.repos.MembersRoomRepos;
import org.jeugenedev.planning.repos.PollRepos;
import org.jeugenedev.planning.repos.VoteRepos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PollModel {
    private final PollRepos pollRepos;
    private final MembersRoomRepos membersRoomRepos;
    private final VoteRepos voteRepos;

    public PollModel(PollRepos pollRepos, MembersRoomRepos membersRoomRepos, VoteRepos voteRepos) {
        this.pollRepos = pollRepos;
        this.membersRoomRepos = membersRoomRepos;
        this.voteRepos = voteRepos;
    }

    public Poll getPoll(Poll poll) {
        return poll;
    }

    public List<Poll> getRoomPolls(Room room) {
        return room.getPolls();
    }

    public Vote vote(User user, Poll poll, String content) {
        Vote vote = voteRepos.findByPollAndVoter(poll, user).orElse(null);
        if(vote != null) {
            throw new UserAlreadyAddedException();
        }
        if(poll.getExpires() < System.currentTimeMillis()) {
            throw new AccessDeniedException();
        }
        for(MembersRoom member : membersRoomRepos.findByRoom(poll.getOwner())) {
            if(member.getUser().getId() == user.getId()) {
                return voteRepos.save(new Vote(poll, user, content));
            }
        }
        throw new AccessDeniedException();
    }

    public List<Vote> getPollVotes(Poll poll) {
        return voteRepos.findByPoll(poll);
    }
}
