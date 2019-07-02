package org.generation.brazil.gfood.cliente;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.generation.brazil.gfood.protudo.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        // "select * from cliente"
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes/data")
    public List<Cliente> findByDataNascimento(@RequestParam Date data){
        return clienteRepository.findByDataNascimento(data);
    }

    /* @GetMapping("/clientes/'{nome}'")
    public List<Cliente> findByNome(@PathVariable String nome) {
        return clienteRepository.findByNome(nome);
    } */

    @PostMapping("/clientes/nome")
    public List<Cliente> findByNome(@RequestParam String nome) {
        return clienteRepository.findByNome(nome);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/clientes")
    public Cliente save(@RequestBody Cliente cliente){

        System.out.printf(cliente.getNome());
        System.out.printf(cliente.getEndereco());

        // "insert into cliente ..."
        return clienteRepository.save(cliente);
    }
    @PutMapping ("/clientes/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente)
            throws ResourceNotFoundException {
         return clienteRepository.findById(id).map(clienteAtualizado -> {
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
             return clienteRepository.save(clienteAtualizado);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe produto cadastrado com o id" + id));
    }

    @DeleteMapping ("/clientes/{id}")
    public void delete (@PathVariable Long id) {
        // "delete from cliente where id= .."
        clienteRepository.deleteById(id);
    }

}
