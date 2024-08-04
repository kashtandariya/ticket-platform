package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
