package com.example.CarSite.Repository;

import com.example.CarSite.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    <S extends User> S save(S entity);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    String findByPassword(String password);
//    Optional<User> findByPhoneNumber(String email);
    boolean existsByPhonenumber(String number);

    boolean existsByName(String name);
    Optional<User> findByName(String phonenumber);

    @Override
    List<User> findAll();


    List<User> findAllById(Long id);
}

