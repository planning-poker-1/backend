package org.jeugenedev.planning.repos;

import org.jeugenedev.planning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
}
