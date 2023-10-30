package com.Kishan.ReceipeManagementSystem.repository;

import com.Kishan.ReceipeManagementSystem.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepo extends JpaRepository<Recipe, Long> {
}
