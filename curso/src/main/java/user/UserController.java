package user;

import org.generation.brazil.curso.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PutMapping("/usuarios/{id}")
    public User update(@PathVariable Long id, @RequestBody User user)
            throws ResourceNotFoundException {
        // "UPDATE produto SET ... WHERE ..."
        return userRepository.findById(id).map(usuarioAtualizado -> {
            usuarioAtualizado.setNome(userRepository.getNome());
            usuarioAtualizado.setEmail(userRepository.getEmail());
            return userRepository.save(usuarioAtualizado);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe produto cadastrado com o id: " + id));
    }

    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}

