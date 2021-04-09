package org.demo.app.persistence.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * JPA entity with database mapping
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name="ID", nullable = false, updatable = false)
    private Long id;

    @Column(name="FIRST_NAME", nullable = false, length = 40)
    private String firstName;

    @Column(name="LAST_NAME", length = 40)
    private String lastName;

    @Column(name="BIRTH_DATE")
    private LocalDate birthDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_group_id")
//    private Group employeeGroup;
    @Column(name="GROUP_ID")
    private Integer groupId;

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

//    public Group getEmployeeGroup() {
//        return employeeGroup;
//    }
//
//    public void setEmployeeGroup(final Group employeeGroup) {
//        this.employeeGroup = employeeGroup;
//    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer employeeGroup) {
        this.groupId = employeeGroup;
    }

}
