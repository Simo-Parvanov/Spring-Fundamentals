package com.svc.exampreparation.date.reposiroties;

import com.svc.exampreparation.date.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, String> {
   Optional<User> findByUsername(String username);
   boolean findAllByEmail(String email);
}
