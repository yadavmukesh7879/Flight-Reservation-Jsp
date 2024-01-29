package com.mukesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukesh.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
