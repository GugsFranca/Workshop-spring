package com.devsuperior.curso.repositories;

import com.devsuperior.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
