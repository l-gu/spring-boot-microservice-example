package org.demo.app.persistence.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * JPA entity with database mapping
 *
 */
@Entity
@Table(name = "WORKGROUP")
public class GroupEntity {

    @Id
    @Column(name="ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name="NAME", nullable = false, length = 80)
    private String name;

//    @OneToMany(mappedBy = "employeeGroup")
//    private Set<Employee> employeeGroupEmployees;

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

//    public Set<Employee> getEmployeeGroupEmployees() {
//        return employeeGroupEmployees;
//    }
//
//    public void setEmployeeGroupEmployees(final Set<Employee> employeeGroupEmployees) {
//        this.employeeGroupEmployees = employeeGroupEmployees;
//    }

}
