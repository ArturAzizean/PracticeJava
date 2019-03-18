package com.springGradle.GradleApi.repo;

import com.springGradle.GradleApi.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
