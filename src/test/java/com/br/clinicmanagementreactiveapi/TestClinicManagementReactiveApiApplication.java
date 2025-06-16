package com.br.clinicmanagementreactiveapi;

import org.springframework.boot.SpringApplication;

public class TestClinicManagementReactiveApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(ClinicManagementReactiveApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
