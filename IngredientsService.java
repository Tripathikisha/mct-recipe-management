package com.Kishan.ReceipeManagementSystem.service;

import com.Kishan.ReceipeManagementSystem.repository.IIngredientsRepo;
import com.Kishan.ReceipeManagementSystem.repository.ITokenRepo;
import com.Kishan.ReceipeManagementSystem.model.AuthenticationToken;
import com.Kishan.ReceipeManagementSystem.model.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    @Autowired
    IIngredientsRepo iRepo;


    @Autowired
    ITokenRepo tokenRepo;
    public void createIngredients(List<Ingredients> ingredients, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.saveAll(ingredients);
        }
    }

    public List<Ingredients> getIngredients(String email, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        return iRepo.findAll();
    }

    public void deleteIngredients(Long id, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.deleteById(id);
        }
    }
}
