package org.generation.brazil.curso.user;

import org.apache.commons.lang3.RandomStringUtils;
import org.generation.brazil.curso.CursoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CursoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1" + path;
    }

    /* public String generateRandomName() {
        String nome = RandomStringUtils.randomAlphabetic(50);

        return nome;
    }
    public String generateRandomEmail() {
        String email = RandomStringUtils.randomAlphanumeric(50);

        return email + "@email.com";
    }
    public String generateRandomLogin() {
        String login = RandomStringUtils.randomAlphanumeric(20);

        return login;
    }
    public String generateRandomSenha() {
        String senha = RandomStringUtils.randomAlphabetic(12);

        return senha;
    } */

    @Test
   public void TestaCriacaoDeUmNovoUsuario(){

        //criar um novo usuario
    User user = UserMock.getUserMock();

    ResponseEntity<User> postResponse = testRestTemplate.postForEntity(getRootUrl("/user"), user, User.class);

    assertNotNull(postResponse);
    assertEquals("created", 201, postResponse.getStatusCodeValue());
}
}
