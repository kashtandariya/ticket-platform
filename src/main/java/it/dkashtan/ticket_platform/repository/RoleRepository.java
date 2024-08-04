package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Integer> {

}
