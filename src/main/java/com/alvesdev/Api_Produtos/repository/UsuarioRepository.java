package com.alvesdev.Api_Produtos.repository;

import com.alvesdev.Api_Produtos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     Optional<Usuario> findByUserName(String userName);
}
