package com.example.springboot_grupparbete;

import com.example.springboot_grupparbete.Controllers.BeställningController;
import com.example.springboot_grupparbete.Controllers.KundController;
import com.example.springboot_grupparbete.Controllers.ProduktController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootGrupparbeteApplicationTests {

    @Autowired
    private BeställningController beställningController;

    @Autowired
    private KundController kundController;

    @Autowired
    private ProduktController produktController;

    //SmokeTest
    @Test
    public void contextLoads() {
        assertThat(beställningController).isNotNull();
        assertThat(kundController).isNotNull();
        assertThat(produktController).isNotNull();

    }
}
