package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
