package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario findByEmail(String email);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}
