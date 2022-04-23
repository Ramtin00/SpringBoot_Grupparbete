package com.example.springboot_grupparbete;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void lagerExceptionShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/beställning/lagerException",
                String.class)).contains("Denna produkt är slut i lager.");
    }
    @Test
    public void getBeställningById() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/beställning/3",
                String.class)).contains("{\"id\":3,\"datum\":\"2022-04-22T11:14:17\",\"totalPris\":400,\"" +
                "kund\":{\"id\":1,\"namn\":\"Stewart\",\"address\":\"Gatan 1\",\"telNr\":\"123\"},\"produkter\":[{\"" +
                "id\":2,\"märke\":\"Nike\",\"färg\":\"Blå\",\"storlek\":\"38\",\"pris\":400,\"antalILager\":-3}]}");
    }
}

