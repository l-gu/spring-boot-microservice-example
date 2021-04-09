package org.demo.app.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EmployeeDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String lastName;

    private LocalDate birthDate;

    private Integer groupId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer employeeGroup) {
        this.groupId = employeeGroup;
    }

}
