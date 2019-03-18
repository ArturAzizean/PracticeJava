package com.springGradle.GradleApi.repo;

import com.springGradle.GradleApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
