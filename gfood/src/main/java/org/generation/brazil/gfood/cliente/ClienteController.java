package org.generation.brazil.gfood.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        // "select * from cliente"
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/clientes")
    public Cliente save(@RequestBody Cliente cliente){

        System.out.printf(cliente.getNome());
        System.out.printf(cliente.getEndereco());

        // "insert into cliente ..."
        return repository.save(cliente);
    }

    /* @PutMapping("/clientes/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.)
    } */

    @DeleteMapping ("/clientes/{id}")
    public void delete (@PathVariable Long id) {
        // "delete from cliente where id= .."
        repository.deleteById(id);
    }

}
