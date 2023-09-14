package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepos extends JpaRepository<Vote, Long> {
}
