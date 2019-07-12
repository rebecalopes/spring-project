package org.generation.brazil.curso.user;

import org.generation.brazil.curso.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User user)
            throws ResourceNotFoundException {
        // "UPDATE produto SET ... WHERE ..."
        return userRepository.findById(id).map(userAtualizado -> {
            userAtualizado.setNome(userAtualizado.getNome());
            userAtualizado.setEmail(userAtualizado.getEmail());
            return userRepository.save(userAtualizado);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe produto cadastrado com o id: " + id));
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}

