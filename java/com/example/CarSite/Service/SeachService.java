package com.example.CarSite.Service;

import com.example.CarSite.Entity.User;
import com.example.CarSite.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeachService {
    @Autowired
    private UserRepository userRepository;

    public boolean findByPhonenumber(String number){
        return userRepository.existsByPhonenumber(number);
    }

    public Optional<User> findByName(String number){
        return userRepository.findByName(number);
    }
    public boolean existsByName(String name){
        return userRepository.existsByName(name);
    }

}
