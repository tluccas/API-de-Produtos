package com.alvesdev.Api_Produtos.service;

import com.alvesdev.Api_Produtos.model.Usuario;
import com.alvesdev.Api_Produtos.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String userName, String password) {
        String passwordCryptographed = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(userName, passwordCryptographed);

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByUserName(nome);
    }
}
