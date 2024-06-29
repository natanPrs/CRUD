package com.games.Games.services;

import com.games.Games.models.Account;
import com.games.Games.models.BestOfTheYear;
import com.games.Games.models.User;
import com.games.Games.repositories.AccountRepository;
import com.games.Games.repositories.GameRepository;
import com.games.Games.repositories.UserRepository;
import com.games.Games.repositories.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final GameRepository gameRepository;
    private final WishlistRepository wishlistRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository, GameRepository gameRepository, WishlistRepository wishlistRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.gameRepository = gameRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public List<User> getAllUsers(UUID id){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
