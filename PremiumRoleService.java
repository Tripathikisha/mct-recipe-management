package com.Kishan.ReceipeManagementSystem.service;

import com.Kishan.ReceipeManagementSystem.repository.IPremiumRoleRepo;
import com.Kishan.ReceipeManagementSystem.model.PremiumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRoleService {

    @Autowired
    IPremiumRoleRepo roleRepo;

    @Autowired
    HeadAdminService adminService;

    public String createRole(PremiumRole role , String email){
        if(adminService.isValidEmail(email)){
            roleRepo.save(role);
            return "Premium role created successfully....";
        }else
            return "You don't have the access to create premium roles..";
    }


}
