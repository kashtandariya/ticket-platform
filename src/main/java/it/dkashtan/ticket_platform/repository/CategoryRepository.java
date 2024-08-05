package it.dkashtan.ticket_platform.repository;

import it.dkashtan.ticket_platform.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
}
