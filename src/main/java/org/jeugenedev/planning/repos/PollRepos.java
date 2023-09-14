package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepos extends JpaRepository<Poll, Long> {
}
