package com.planthome.planthome.services;

import com.planthome.planthome.model.*;

import java.util.List;
import java.util.Set;


public interface PlantService {
    List<Plant> getAllPlants();

    public List<Plant> getPlantsOfUser(User user);

    public Set<ProprietePurificationAir> getPlantProperties(Long plantId);
}
