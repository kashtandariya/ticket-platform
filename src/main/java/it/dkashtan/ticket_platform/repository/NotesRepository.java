package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.NotesModel;

public interface NotesRepository extends JpaRepository<NotesModel, Integer>{

}
