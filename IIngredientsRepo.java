package com.Kishan.ReceipeManagementSystem.repository;

import com.Kishan.ReceipeManagementSystem.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientsRepo extends JpaRepository<Ingredients,Long> {
}
