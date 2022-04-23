package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BeställningControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BeställningRepository beställningRepository;

    @BeforeEach
    public void init(){

        Beställning beställning = new Beställning();
        when(beställningRepository.findById(1L)).thenReturn(Optional.of(beställning));

    }

    @Test
    void postBeställningTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/beställning/post?kundId=1&produktId=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":null,\"datum\":null,\"totalPris\":500,\"kund\":{\"id\":1,\"namn\":\"Stewart\",\"address\":\"Gatan 1\",\"telNr\":\"123\"},\"produkter\":[{\"id\":1,\"märke\":\"Adidas\",\"färg\":\"Röd\",\"storlek\":\"40\",\"pris\":500,\"antalILager\":14}]}")));
    }
}

