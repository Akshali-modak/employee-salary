package com.employee.file.service;

import com.employee.file.dao.DatabaseService;
import details.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private FileService fileService;

    @Autowired
    private DatabaseService dbService;

    public void insertEmployees() {
        List<String> lines = fileService.readFile("C:\\Users\\AKSHALI\\Downloads\\data-file\\src\\main\\resources\\data\\emp_salary.csv");
        List<EmployeeDetails> employees = convert(lines);
        dbService.insert(employees);
    }

    private List<EmployeeDetails> convert(List<String> lines) {
        List<EmployeeDetails> employees = new ArrayList<>();
        for (String line : lines) {
            EmployeeDetails employee = new EmployeeDetails();

            String[] data = line.split(",");
            if(data.length == 0){
                continue;
            }
            employee.setAge(Integer.parseInt(data[0]));
            employee.setName(data[1]);
            employee.setEducation(data[2]);
            employee.setJobTitle(data[3]);
            if(data.length >4) {
                employee.setYearOfExperience(Double.valueOf(data[4]));
            }
            if(data.length >5) {
                employee.setSalary(Double.valueOf(data[5]));
            }
            employees.add(employee);
        }
        return employees;
    }
}
