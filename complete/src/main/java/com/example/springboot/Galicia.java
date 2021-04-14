package com.example.springboot;

public class Galicia {

        private final int id;
        private final String name;
        private final String province;

        public Galicia(int id, String name, String province) {
                this.id = id;
                this.name = name;
                this.province = province;
        }

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getProvince() {
                return province;
        }
}