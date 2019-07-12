package org.generation.brazil.curso.user;

import com.github.javafaker.Faker;

public class UserMock{

    public static User getUserMock(){
        User user = new User();

        Faker faker = new Faker();

        user.setNome(faker.name().firstName());
        user.setEmail(faker.internet().emailAddress());
        user.setLogin(faker.name().username());
        user.setSenha(faker.internet().password());

        return user;
    }
}
