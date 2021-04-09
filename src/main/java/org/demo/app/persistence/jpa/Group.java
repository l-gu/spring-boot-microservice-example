package org.demo.app.persistence.jpa;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "WORKGROUP")
public class Group {

    @Id
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String name;

    @OneToMany(mappedBy = "employeeGroup")
    private Set<Employee> employeeGroupEmployees;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeGroupEmployees() {
        return employeeGroupEmployees;
    }

    public void setEmployeeGroupEmployees(final Set<Employee> employeeGroupEmployees) {
        this.employeeGroupEmployees = employeeGroupEmployees;
    }

}
