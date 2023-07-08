package com.employee.file.dao;

import details.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<EmployeeDetails> employees) {
        createTable();
        for (EmployeeDetails employee : employees) {
            save(employee);

        }
    }


    public void createTable() {

        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS employee_data (" +
                    "id SERIAL PRIMARY KEY," +
                    "employee_name VARCHAR(255)," +
                    "age bigint ," +
                    "salary float," +
                    "jobtitle VARCHAR(255) ," +
                    "education VARCHAR(255) ," +
                    "yearofexperience float " +
                    ")";

            statement.executeUpdate(query);
            System.out.println("Table created successfully.");
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void save(EmployeeDetails employee) {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            String insertQuery = "INSERT INTO employee_data (employee_name, age, salary, jobtitle, education, yearofexperience) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            int index =  1;
            ps.setString(index++, employee.getName());
            ps.setInt(index++, employee.getAge());
            ps.setDouble(index++, employee.getSalary());
            ps.setString(index++, employee.getJobTitle());
            ps.setString(index++, employee.getEducation());
            ps.setDouble(index, employee.getYearOfExperience());

            ps.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
