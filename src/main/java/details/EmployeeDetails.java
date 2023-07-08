package details;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
    private int id;
    private String name;
    private int age;
    private String education;
    private String jobTitle;
    private double yearOfExperience;
    private double salary;
}
