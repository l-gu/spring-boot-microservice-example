package org.demo.app.persistence.jpa;

import org.demo.app.dto.EmployeeDTO;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final GroupRepository groupRepository;

    public EmployeeService(final EmployeeRepository employeeRepository,
            final GroupRepository groupRepository) {
        this.employeeRepository = employeeRepository;
        this.groupRepository = groupRepository;
    }

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> mapToDTO(employee, new EmployeeDTO()))
                .collect(Collectors.toList());
    }

    public EmployeeDTO get(final Long id) {
        return employeeRepository.findById(id)
                .map(employee -> mapToDTO(employee, new EmployeeDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final EmployeeDTO employeeDTO) {
        final Employee employee = new Employee();
        mapToEntity(employeeDTO, employee);
        return employeeRepository.save(employee).getId();
    }

    public void update(final Long id, final EmployeeDTO employeeDTO) {
        final Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(employeeDTO, employee);
        employeeRepository.save(employee);
    }

    public void delete(final Long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO mapToDTO(final Employee employee, final EmployeeDTO employeeDTO) {
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setBirthDate(employee.getBirthDate());
        employeeDTO.setEmployeeGroup(employee.getEmployeeGroup() == null ? null : employee.getEmployeeGroup().getId());
        return employeeDTO;
    }

    private Employee mapToEntity(final EmployeeDTO employeeDTO, final Employee employee) {
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setBirthDate(employeeDTO.getBirthDate());
        if (employeeDTO.getEmployeeGroup() != null && 
                (employee.getEmployeeGroup() == null || !employee.getEmployeeGroup().getId().equals(employeeDTO.getEmployeeGroup()))) {
            final Group employeeGroup = groupRepository.findById(employeeDTO.getEmployeeGroup())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employeeGroup not found"));
            employee.setEmployeeGroup(employeeGroup);
        }
        return employee;
    }

}
