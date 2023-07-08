package com.employee.file.model;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private String education;
    private String jobTitle;
    private double yearOfExperience;
    private double salary;
}
