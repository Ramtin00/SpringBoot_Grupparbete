package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProduktControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProduktRepository produktRepository;

    @BeforeEach
    public void init(){

        Produkt produkt1 = new Produkt("Calvin Klein","svart","46", 1000,1);
        Produkt produkt2 = new Produkt("Adidas","blå","40", 500,1);
        Produkt produkt3 = new Produkt("Nike","vit","41", 500,1);

        when(produktRepository.findById(1L)).thenReturn(Optional.of(produkt1));
        when(produktRepository.findById(2L)).thenReturn(Optional.of(produkt2));
        when(produktRepository.findById(3L)).thenReturn(Optional.of(produkt3));

        when(produktRepository.findAll()).thenReturn(Arrays.asList(produkt1, produkt2, produkt3));
    }

    @Test
    public void findAllProduktTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/produkt")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"märke\":\"Calvin Klein\",\"färg\":\"svart\",\"storlek\":\"46\",\"pris\":1000,\"antalILager\":1}," +
                        "{\"märke\":\"Adidas\",\"färg\":\"blå\",\"storlek\":\"40\",\"pris\":500,\"antalILager\":1}," +
                        "{\"märke\":\"Nike\",\"färg\":\"vit\",\"storlek\":\"41\",\"pris\":500,\"antalILager\":1}]"));
    }

    @Test
    void getProduktById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/produkt/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"märke\":\"Calvin Klein\",\"färg\":\"svart\",\"storlek\":\"46\",\"pris\":1000,\"antalILager\":1}"));
    }
}


