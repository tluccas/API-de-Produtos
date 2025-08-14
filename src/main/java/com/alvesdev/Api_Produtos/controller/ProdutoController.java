package com.alvesdev.Api_Produtos.controller;

import com.alvesdev.Api_Produtos.exceptions.RecursoNaoEncontradoException;
import com.alvesdev.Api_Produtos.model.Produto;
import com.alvesdev.Api_Produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
            Produto produto = produtoService.buscarPorId(id);
            return ResponseEntity.ok(produto);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> excluirProduto(@PathVariable Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
