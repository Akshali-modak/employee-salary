package com.employee.file;

import com.employee.file.service.EmployeeService;
import details.DataFileApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Autowired
    private EmployeeService es;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        es.insertEmployees();
    }
}
