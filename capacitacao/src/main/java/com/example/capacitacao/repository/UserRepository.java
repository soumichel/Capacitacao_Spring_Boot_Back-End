package com.example.capacitacao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.capacitacao.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    // Lista de todos os usuários
    List <User> findAll();

    // Método que busca um id de usuário
    User findById (int id);
}
