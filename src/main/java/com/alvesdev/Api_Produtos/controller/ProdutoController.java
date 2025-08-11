package com.alvesdev.Api_Produtos.controller;

import com.alvesdev.Api_Produtos.model.Produto;
import com.alvesdev.Api_Produtos.service.ProdutoService;
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
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
