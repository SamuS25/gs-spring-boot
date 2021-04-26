package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class GaliciaControllerTest {

        @Autowired
        private MockMvc mvc;

        @Test
        public void getCityList() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/cities").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[1].name", is("A Coruña")))
                                .andExpect(jsonPath("$[1].id", is(1)))
                                .andExpect(jsonPath("$[1].province", is("A Coruña")));
        }

        @Test
        public void getCity() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/cities/0").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.name", is("Santiago de Compostela")))
                                .andExpect(jsonPath("$.id", is(0)))
                                .andExpect(jsonPath("$.province", is("A Coruña")));
        }

        @Test
        public void getNameList() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/names").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[5]", is("Vigo")));
        }

        @Test
        public void getName() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/names/Santiago de Compostela").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.name", is("Santiago de Compostela")))
                                .andExpect(jsonPath("$.id", is(0)))
                                .andExpect(jsonPath("$.province", is("A Coruña")));
        }

        @Test
        public void getProvinceList() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/provinces").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[1]", is("Pontevedra")));
        }

        @Test
        public void getProvince() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/provinces/A Coruña").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[2].name", is("Ferrol")))
                                .andExpect(jsonPath("$[2].id", is(6)))
                                .andExpect(jsonPath("$[2].province", is("A Coruña")));
        }

}