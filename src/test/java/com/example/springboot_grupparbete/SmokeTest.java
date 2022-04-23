package com.example.springboot_grupparbete;

import com.example.springboot_grupparbete.Controllers.BeställningController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private BeställningController beställningController;

    @Test
    public void contextLoads() {
        assertThat(beställningController).isNotNull();
    }
}

