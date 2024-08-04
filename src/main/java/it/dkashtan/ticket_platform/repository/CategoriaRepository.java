package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
