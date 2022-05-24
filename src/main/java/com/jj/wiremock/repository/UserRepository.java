package com.jj.wiremock.repository;

import com.jj.wiremock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
