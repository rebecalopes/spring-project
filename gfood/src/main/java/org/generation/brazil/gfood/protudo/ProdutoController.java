package org.generation.brazil.gfood.protudo;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
    public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produtos")
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> findAll(){
       return produtoRepository.findAll();
    }

    /* @GetMapping("/produtos/'{nome}'")
    public List<Produto> findByNome(@PathVariable String nome) {
        return produtoRepository.findByNome(nome);
    } */

    @PostMapping("/produtos/nome")
    public List<Produto> findByNome(@RequestParam String nome) {
        return produtoRepository.findByNome(nome);
    }

    @GetMapping("/produtos/{id}")
    public Optional<Produto> findById(@PathVariable Long id){
        return produtoRepository.findById(id);
    }

    @PutMapping ("/produtos/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto)
        throws ResourceNotFoundException {
            return produtoRepository.findById(id).map(produtoAtualizado -> {
                    produtoAtualizado.setNome(produto.getNome());
                    produtoAtualizado.setDescricao(produto.getDescricao());
                    produtoAtualizado.setPreco(produto.getPreco());
                    return produtoRepository.save(produtoAtualizado);
        }).orElseThrow(() ->
                    new ResourceNotFoundException("Não existe produto cadastrado com o id" + id));
    }

    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

}
