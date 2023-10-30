package com.Kishan.ReceipeManagementSystem.controller;

import com.Kishan.ReceipeManagementSystem.model.PremiumRole;
import com.Kishan.ReceipeManagementSystem.service.PremiumRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PremiumRoleController {
    @Autowired
    PremiumRoleService roleService;

    @PostMapping("/roles")
    public String createRole(@RequestParam String email , @RequestBody PremiumRole role){
        return roleService.createRole(role,email);
    }
}
