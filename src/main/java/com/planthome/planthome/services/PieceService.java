package com.planthome.planthome.services;

import com.planthome.planthome.model.Piece;
import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.User;

import java.util.List;
import java.util.Set;

public interface PieceService {
    public List<Piece> findAllPieces();

    public List<Piece> findPiecesByUser(User user);

    public Set<Plant> findPlantsByPiece(Piece piece);


    Piece findPieceById(Long pieceId);
}
