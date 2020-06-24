package com.svc.exampreparation.date.reposiroties;

import com.svc.exampreparation.date.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   Optional<User> findByUsername(String username);
   Optional<User> findByEmail(String email);
}
