package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.Poll;
import org.jeugenedev.planning.entity.User;
import org.jeugenedev.planning.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteRepos extends JpaRepository<Vote, Long> {
    List<Vote> findByPoll(Poll poll);
    Optional<Vote> findByPollAndVoter(Poll poll, User voter);
}
