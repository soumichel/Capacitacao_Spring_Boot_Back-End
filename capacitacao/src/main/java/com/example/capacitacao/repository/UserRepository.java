package com.example.capacitacao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.capacitacao.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    // Lista de todos os usuários
    List <User> findAll();

    User findById (int id);
}
