package com.planthome.planthome.services;

import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.ProprietePurificationAir;
import com.planthome.planthome.model.User;
import com.planthome.planthome.repository.PlantRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlantServiceImp implements PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public List<Plant> getPlantsOfUser(User user) {
        return plantRepository.findByUsers(user);
    }

    public Set<ProprietePurificationAir> getPlantProperties(Long plantId) {
        Optional<Plant> plant = plantRepository.findById(plantId);
        if (plant.isPresent()) {
            return plant.get().getProprietes();
        } else {
            try {
                throw new Exception("Plant not found with ID: " + plantId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
