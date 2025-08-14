package com.alvesdev.Api_Produtos.controller;

import com.alvesdev.Api_Produtos.model.Usuario;
import com.alvesdev.Api_Produtos.security.JwtUtil;
import com.alvesdev.Api_Produtos.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){ //String userName: fulano String password: 123
        Usuario usuario = usuarioService.registrarUsuario(request.get("userName"), "password");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarPorNome(request.get("userName"));

        if(usuario.isPresent() && usuario.get().getSenha().equals(request.get("password"))) {
            String token = JwtUtil.generateToken(usuario.get().getUserName());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Credênciais inválidas");
    }
}
