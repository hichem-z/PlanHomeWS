package com.planthome.planthome.repository;

import com.planthome.planthome.model.Piece;
import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@EnableJpaRepositories
public interface PieceRepository extends JpaRepository<Piece, Long> {
    List<Piece> findByUser(User user);
}
