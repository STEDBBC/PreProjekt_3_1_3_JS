package ru.stedbbc.spring_boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stedbbc.spring_boot.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String role);
}