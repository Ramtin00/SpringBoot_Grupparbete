package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.KundRepository;
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
public class KundControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private KundRepository kundRepository;

    @BeforeEach
    public void init(){

        Kund kund1 = new Kund("Ramtin","Nackademin","070432456");
        Kund kund2 = new Kund("Sharlin","Nackademin","070321523");
        Kund kund3 = new Kund("Simon","Nackademin","0703215621");
        Kund kund4 = new Kund("Filip","Nackademin","0735342561");

        when(kundRepository.findById(1L)).thenReturn(Optional.of(kund1));
        when(kundRepository.findById(2L)).thenReturn(Optional.of(kund2));
        when(kundRepository.findById(3L)).thenReturn(Optional.of(kund3));
        when(kundRepository.findById(3L)).thenReturn(Optional.of(kund4));

        when(kundRepository.findAll()).thenReturn(Arrays.asList(kund1, kund2, kund3, kund4));
    }

    @Test
    public void findAllKundTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/kund")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"namn\":\"Ramtin\",\"address\":\"Nackademin\",\"telNr\":\"070432456\"}," +
                        "{\"namn\":\"Sharlin\",\"address\":\"Nackademin\",\"telNr\":\"070321523\"}," +
                        "{\"namn\":\"Simon\",\"address\":\"Nackademin\",\"telNr\":\"0703215621\"}," +
                        "{\"namn\":\"Filip\",\"address\":\"Nackademin\",\"telNr\":\"0735342561\"}]"));
    }

    @Test
    void getKundById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/kund/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"namn\":\"Sharlin\",\"address\":\"Nackademin\",\"telNr\":\"070321523\"}"));
    }
}

