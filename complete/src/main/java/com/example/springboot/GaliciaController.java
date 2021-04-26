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

        @GetMapping("/cities/{id}")
        public Galicia details(@PathVariable int id) {
                try {
                        return cities_list.get(id);
                } catch (IndexOutOfBoundsException error) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City Not Found");
                }
        }

        @GetMapping("/names")
        public List<String> name() {
                try {
                    List<String> cities = new ArrayList<String>();
                    for (int i = 0; i < cities_list.size(); i++) {
                        if (!cities.contains(cities_list.get(i).getName())) {
                            cities.add(cities_list.get(i).getName());
                        }
                    }
                    return cities;
                } catch (IndexOutOfBoundsException error) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Names Not Found");
                }
        }

        @GetMapping("/names/{name}")
        public Galicia details_name(@PathVariable String name) {
                int i;
                for (i=0; i < cities_list.size(); i++) {
                    if (cities_list.get(i).getName().equals(name)) {
                        return cities_list.get(i);
                    }
                }
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name Not Found");
        }

        @GetMapping("/provinces")
        public List<String> province() {
                try {
                    List<String> cities = new ArrayList<String>();
                    for (int i = 0; i < cities_list.size(); i++) {
                        if (!cities.contains(cities_list.get(i).getProvince())) {
                            cities.add(cities_list.get(i).getProvince());
                        }
                    }
                    return cities;
                } catch (IndexOutOfBoundsException error) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provinces Not Found");
                }
        }

        @GetMapping("/provinces/{province}")
        public List<Galicia> details_province(@PathVariable String province) {
                try {
                    List<Galicia> cities = new ArrayList<Galicia>();
                    for (int i = 0; i < cities_list.size(); i++) {
                        Galicia ciudad = cities_list.get(i);
                        if (cities_list.get(i).getProvince().equals(province)) {
                            cities.add(cities_list.get(i));
                        }
                    }
                    return cities;
                } catch (IndexOutOfBoundsException error) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Province Not Found");
                }
        }

}