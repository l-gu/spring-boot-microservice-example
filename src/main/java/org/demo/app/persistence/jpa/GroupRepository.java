package org.demo.app.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Integer> {
}
