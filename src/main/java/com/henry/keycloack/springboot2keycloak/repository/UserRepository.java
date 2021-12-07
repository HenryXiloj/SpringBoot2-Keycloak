package com.henry.keycloack.springboot2keycloak.repository;

import com.henry.keycloack.springboot2keycloak.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
