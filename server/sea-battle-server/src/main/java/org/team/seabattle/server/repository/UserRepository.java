package org.team.seabattle.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team.seabattle.server.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
