package com.alvesdev.Api_Produtos.repository;

import com.alvesdev.Api_Produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
