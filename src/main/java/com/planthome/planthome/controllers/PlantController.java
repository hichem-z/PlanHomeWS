package com.planthome.planthome.controllers;

import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.ProprietePurificationAir;
import com.planthome.planthome.model.User;
import com.planthome.planthome.repository.UserRepository;
import com.planthome.planthome.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @Autowired
    private PlantService plantService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/user/{firebaseAuth}")
    public List<Plant> getPlantsOfUser(@PathVariable String firebaseAuth) {
        User user = userRepository.findByAuthId(firebaseAuth);
        return plantService.getPlantsOfUser(user);
    }

    @GetMapping("/{plantId}/properties")
    public Set<ProprietePurificationAir> getPlantProperties(@PathVariable Long plantId) {
        return plantService.getPlantProperties(plantId);
    }

    // You can add more controller methods for other operations as needed.
}

