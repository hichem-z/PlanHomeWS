package com.planthome.planthome.repository;

import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByUsers(User user);
}
