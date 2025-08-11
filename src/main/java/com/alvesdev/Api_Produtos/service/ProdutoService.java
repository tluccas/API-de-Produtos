package com.alvesdev.Api_Produtos.service;

import com.alvesdev.Api_Produtos.model.Produto;
import com.alvesdev.Api_Produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
       return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
