package com.Kishan.ReceipeManagementSystem.repository;

import com.Kishan.ReceipeManagementSystem.model.PremiumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPremiumRoleRepo extends JpaRepository<PremiumRole,Long> {
}
