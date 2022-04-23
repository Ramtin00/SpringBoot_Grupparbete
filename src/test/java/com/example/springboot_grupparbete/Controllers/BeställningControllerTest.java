package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class BeställningControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BeställningRepository mockRepository;

    @Autowired
    private BeställningController beställningController;

    //SmokeTest
    @Test
    public void contextLoads() {
        assertThat(beställningController).isNotNull();
    }
}

