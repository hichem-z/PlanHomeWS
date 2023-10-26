package com.planthome.planthome.services;

import com.planthome.planthome.model.Piece;
import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.User;
import com.planthome.planthome.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PieceServiceImpl implements PieceService {

    @Autowired
    private PieceRepository pieceRepository;

    @Override
    public List<Piece> findAllPieces() {
        return pieceRepository.findAll();
    }

    @Override
    public List<Piece> findPiecesByUser(User user) {
        return pieceRepository.findByUser(user);
    }

    @Override
    public Set<Plant> findPlantsByPiece(Piece piece) {
        return piece.getPlants();
    }

    public Piece findPieceById(Long id) {
        return pieceRepository.findById(id).orElse(null);
    }
}

