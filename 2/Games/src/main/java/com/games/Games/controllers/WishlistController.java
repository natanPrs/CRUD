package com.games.Games.controllers;


import com.games.Games.dtos.WishlistRecordDto;
import com.games.Games.models.Wishlist;
import com.games.Games.services.WishlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public ResponseEntity<Wishlist> saveWishList(@RequestBody WishlistRecordDto wishlistRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(wishlistService.saveWishlist(wishlistRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllGamesWish(){
        return ResponseEntity.status(HttpStatus.OK).body(wishlistService.getAllGamesWish());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGameWish(@PathVariable UUID id){
        wishlistService.deleteWish(id);
        return ResponseEntity.status(HttpStatus.OK).body("Game has been deleted!");
    }
}
