package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
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
    @MockBean
    private KundRepository kundRepository;
    @MockBean
    private ProduktRepository produktRepository;


    @BeforeEach
    public void init(){

        Beställning beställning1 = new Beställning();
        Kund kund1 = new Kund("Simon","Nackademin","0703215621");
        Produkt produkt1 = new Produkt("Calvin Klein","svart","46", 1000,1);

        when(beställningRepository.findById(1L)).thenReturn(Optional.of(beställning1));
        when(beställningRepository.findAll()).thenReturn(Arrays.asList(beställning1));

        when(kundRepository.findById(1L)).thenReturn(Optional.of(kund1));
        when(kundRepository.findAll()).thenReturn(Arrays.asList(kund1));

        when(produktRepository.findById(1L)).thenReturn(Optional.of(produkt1));
        when(produktRepository.findAll()).thenReturn(Arrays.asList(produkt1));
    }

    //Beställning/post
    @Test
    void postBeställningTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/beställning/post?kundId=1&produktId=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":null,\"datum\":null,\"totalPris\":1000,\"kund\":{\"id\":null,\"namn\":\"Simon\",\"address\":\"Nackademin\",\"telNr\":\"0703215621\"},\"produkter\":[{\"id\":null,\"mÃ¤rke\":\"Calvin Klein\",\"fÃ¤rg\":\"svart\",\"storlek\":\"46\",\"pris\":1000,\"antalILager\":0}]}")));
    }


    //Beställning (findAll)
    @Test
    public void findAllBeställningTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/beställning")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":null,\"datum\":null,\"totalPris\":0,\"kund\":null,\"produkter\":[]}]"));
    }

    //Beställning/{id} (findById)
    /*@Test
    void getBeställningById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/beställning/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"datum\":null,\"totalPris\":0,\"kund\":null,\"produkter\":[]}"));
    }*/
}

