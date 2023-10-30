package com.Kishan.ReceipeManagementSystem.service;

import com.Kishan.ReceipeManagementSystem.repository.IRecipeRepo;
import com.Kishan.ReceipeManagementSystem.repository.ITokenRepo;
import com.Kishan.ReceipeManagementSystem.model.AuthenticationToken;
import com.Kishan.ReceipeManagementSystem.model.ProcessStatus;
import com.Kishan.ReceipeManagementSystem.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    IRecipeRepo recipeRepo;

    @Autowired
    ITokenRepo tokenRepo;
    public void createRecipe(Recipe recipe, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            recipe.setProcess(ProcessStatus.valueOf("FINAL_RECIPE"));
            recipe.setUser(generatedToken.getUser());
            recipeRepo.save(recipe);
        }
    }


    public List<Recipe> getRecipe(String email, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        return recipeRepo.findAll();
    }

    public void updateRecipe(ProcessStatus processStatus, String token, Long id) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        Optional<Recipe> recipe = recipeRepo.findById(id);
        if(recipe!=null){
            recipe.get().setProcess(processStatus);
            recipeRepo.save(recipe.get());
        }
    }
}
