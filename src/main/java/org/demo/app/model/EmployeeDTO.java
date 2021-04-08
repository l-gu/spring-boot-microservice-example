package org.demo.app.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EmployeeDTO {

    private Long id;

    @NotNull
    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String lastName;

    private LocalDate birthDate;

    private Integer employeeGroup;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(final Integer employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

}
