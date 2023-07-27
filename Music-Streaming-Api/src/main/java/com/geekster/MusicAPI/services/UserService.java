package com.geekster.MusicAPI.services;

import com.geekster.MusicAPI.dto.SignInInput;
import com.geekster.MusicAPI.dto.SignInOutput;
import com.geekster.MusicAPI.dto.SignUpOutput;
import com.geekster.MusicAPI.models.Admin;
import com.geekster.MusicAPI.models.AuthenticationToken;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    TokenService tokenService;
    public SignUpOutput signUp(User signUpDto) {

        User user = userRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException("user already exists!!!!...sign in instead");
        }
        userRepo.save(signUpDto);

        return new SignUpOutput("Successfully registered in music playlist app","account created successfully");
    }



    public SignInOutput signIn(SignInInput signInDto) {

        User user = userRepo.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);
        tokenService.saveToken(token);

        return new SignInOutput("Authentication Successful !!!", token.getToken());
    }
}
