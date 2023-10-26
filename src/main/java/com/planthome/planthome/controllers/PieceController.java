package com.planthome.planthome.controllers;

import com.planthome.planthome.model.Piece;
import com.planthome.planthome.model.Plant;
import com.planthome.planthome.model.User;
import com.planthome.planthome.repository.UserRepository;
import com.planthome.planthome.services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pieces")
public class PieceController {
    @Autowired
    private PieceService pieceService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Piece>> getAllPieces() {
        List<Piece> pieces = pieceService.findAllPieces();
        return ResponseEntity.ok(pieces);
    }

    @GetMapping("/user/{firebaseAuth}")
    public ResponseEntity<List<Piece>> getPiecesByUser(@PathVariable String firebaseAuth) {
        User user = userRepository.findByAuthId(firebaseAuth);
        List<Piece> pieces = pieceService.findPiecesByUser(user);
        return ResponseEntity.ok(pieces);
    }

    @GetMapping("/{pieceId}/plants")
    public ResponseEntity<Set<Plant>> getPlantsByPiece(@PathVariable Long pieceId) {
        Piece piece = pieceService.findPieceById(pieceId);
        if (piece != null) {
            Set<Plant> plants = pieceService.findPlantsByPiece(piece);
            return ResponseEntity.ok(plants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

