/*
package details;



import details.EmployeeDetails;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class DbService {


//   public  void createTable() throws SQLException {
//
//       Statement statement = connection.createStatement();
//       String query = "CREATE TABLE datafile.employee_data (" +
//               "id SERIAL PRIMARY KEY," +
//               "employee_name VARCHAR(255)," +
//               "age bigint ," +
//               "salary bigint," +
//               "jobTitle VARCHAR(255) ," +
//               "education VARCHAR(255) ," +
//               "yearOfExperience bigint " +
//               ")";
//
//       statement.executeQuery(query);
//       System.out.println("Table created successfully.");
//   }


   public ArrayList<EmployeeDetails> insertDataFromCSV() {
       ArrayList<EmployeeDetails> employees  = new ArrayList<>();
       try {
           Connection connection = getDatabaseConnection();
           String insertQuery = "INSERT INTO employee_salary (employee_name, jobTitle ,age,education, salary, yearOfExperience) VALUES (?,?,?,?,? ?)";
           PreparedStatement ps = connection.prepareStatement(insertQuery);

           ps.executeUpdate(insertQuery);

           BufferedReader reader = new BufferedReader(new FileReader(new ClassPathResource("\"D:\\MYProjects\\Salary_Data (1).csv\"").getFile()));
           String line;
           while ((line = reader.readLine()) != null) {
               String[] data = line.split(",");
               int age = Integer.parseInt(data[0]);
               String name = data[1];
               String education = data[2];
               String jobTitle = data[3];
               int yearOfExperience = Integer.parseInt(data[4]);
               boolean salary = Boolean.parseBoolean(data[5]);

               ps.setString(1, name);
               ps.setInt(0, age);
               ps.setBoolean(5, salary);
               ps.setString(3, jobTitle);
               ps.setString(2, education);
               ps.setInt(4, yearOfExperience);
           }
           reader.close();
           System.out.println("Data inserted successfully.");
       } catch (IOException | SQLException e) {
           e.printStackTrace();
       }
       return employees;
   }

}

*/
