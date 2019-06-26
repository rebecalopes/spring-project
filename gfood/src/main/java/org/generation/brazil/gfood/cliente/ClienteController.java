package org.generation.brazil.gfood.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        // "insert into cliente ..."
        return repository.save(cliente);
    }
}
