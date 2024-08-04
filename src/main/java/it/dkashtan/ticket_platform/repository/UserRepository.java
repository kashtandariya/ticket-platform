package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
