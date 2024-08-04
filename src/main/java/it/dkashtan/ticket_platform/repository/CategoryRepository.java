package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{

}
