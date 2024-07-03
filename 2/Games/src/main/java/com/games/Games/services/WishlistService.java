package com.games.Games.services;

import com.games.Games.dtos.WishlistRecordDto;
import com.games.Games.models.Wishlist;
import com.games.Games.repositories.GameRepository;
import com.games.Games.repositories.UserRepository;
import com.games.Games.repositories.WishlistRepository;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WishlistService {
    private final UserRepository userRepository;
    private final WishlistRepository wishlistRepository;
    private  final GameRepository gameRepository;

    public WishlistService(UserRepository userRepository, WishlistRepository wishlistRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.wishlistRepository = wishlistRepository;
        this.gameRepository = gameRepository;
    }

    public List<Wishlist> getAllGamesWish(){
        return wishlistRepository.findAll();
    }

    @Transactional
    public void deleteWish(UUID id) {
        wishlistRepository.deleteById(id);
    }

    @Transactional
    public Wishlist saveWishlist(WishlistRecordDto wishlistRecordDto){
        Wishlist wishlist = new Wishlist();
        wishlist.setUser(userRepository.findById(wishlistRecordDto.user()).get());
        wishlist.setGames(gameRepository.findAllById(wishlistRecordDto.games()).stream().collect(Collectors.toSet()));

        return wishlistRepository.save(wishlist);
    }
}
