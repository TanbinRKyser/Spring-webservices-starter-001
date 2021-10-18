package com.tusker.restfulwebservicesstarter.repository;

import com.tusker.restfulwebservicesstarter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
