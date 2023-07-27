package com.geekster.MusicAPI.repository;

import com.geekster.MusicAPI.models.AuthenticationToken;
import com.geekster.MusicAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);


}
