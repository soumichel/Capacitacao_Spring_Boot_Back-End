package com.example.capacitacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capacitacao.model.User;
import com.example.capacitacao.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repositorio;

    // Rota de cadastro de usuários
    @PostMapping("/cadastro")
    public User store(@RequestBody User obj) {
        return repositorio.save(obj);
    }

    // Rota de exibição de todos os usuários
    @GetMapping("/exibirtodos")
    public List<User> index() {
        return repositorio.findAll();
    }

    // Rota de exibição de um usuário a partir do seu id
    @GetMapping("/exibir/{id}")
    public User show(@PathVariable int id) {
        return repositorio.findById(id);
    }

    /*
     * @PutMapping("/atualiza")
     * public User update (@RequestBody User obj){
     * return repositorio.save(obj);
     * }
     */

    // Rota de atualização de dados de algum usuário
    @PutMapping("/atualiza")
    public User update(@RequestBody User obj) {
        // Buscar o usuário existente pelo ID
        User existingUser = repositorio.findById(obj.getId());

        if (existingUser != null) {
            // Atualize apenas os atributos email, telefone e senha
            existingUser.setEmail(obj.getEmail());
            existingUser.setTelefone(obj.getTelefone());
            existingUser.setSenha(obj.getSenha());
        }

        // Salve o usuário atualizado no repositório
        return repositorio.save(existingUser);
    }

    // Rota de exclusão de um usuário a partir do seu id
    @DeleteMapping("/deleta/{id}")
    public void delete(@PathVariable int id) {
        User existingUser = selectById(id);
        repositorio.delete(existingUser);
    }

    // Seleciona um usuário pelo id (método auxiliar)
    private User selectById(@PathVariable int id) {
        return repositorio.findById(id);
    }
}
