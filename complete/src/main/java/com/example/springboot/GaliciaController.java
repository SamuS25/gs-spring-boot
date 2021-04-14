package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Arrays;

@RestController
public class GaliciaController {

        private static List<Galicia> cities_list = Arrays.asList(
                new Galicia(0, "Santiago de Compostela", "A Coruña"),
                new Galicia(1, "A Coruña", "A Coruña"),
                new Galicia(2, "Pontevedra", "Pontevedra"),
                new Galicia(3, "Lugo", "Lugo"),
                new Galicia(4, "Ourense", "Ourense"),
                new Galicia(5, "Vigo", "Pontevedra"),
                new Galicia(6, "Ferrol", "A Coruña"),
                new Galicia(7, "Sanxenxo", "Pontevedra")
        );

        @GetMapping("/cities")
        public List<Galicia> list() {
                return cities_list;
         }
}