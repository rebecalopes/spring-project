package org.generation.brazil.curso.user;

import org.generation.brazil.curso.CursoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import user.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CursoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    public void save(){
    User user = new User();
    user.setNome("Rebeca");
    user.setEmail("rebeca@gmail.com");
    user.setLogin("bebeca");
    user.setSenha("@760senha#");
    }
}
