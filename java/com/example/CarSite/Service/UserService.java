package com.example.CarSite.Service;

import com.example.CarSite.Dto.UserDto;
import com.example.CarSite.Entity.User;
import com.example.CarSite.Repository.UserRepository;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void join(UserDto userDto){
        User user = User.creatuser(userDto);
        userRepository.save(user);
    }
    public boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public String findByPassword(String password){
        return userRepository.findByPassword(password);
    }
    public UserDto findByEmail(UserDto userDto){
        Optional<User> users =userRepository.findByEmail(userDto.getEmail());
        if(users.isPresent()){
            User user =users.get();
            if(user.getPassword().equals(userDto.getPassword())){
                UserDto Dto = UserDto.userDto(user);
                return Dto;
            }
            return null;
        }
        return null;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findByAllId(Long id){
        return userRepository.findAllById(id);
    }
}
