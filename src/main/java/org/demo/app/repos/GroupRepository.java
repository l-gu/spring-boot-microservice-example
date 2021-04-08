package org.demo.app.repos;

import org.demo.app.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Integer> {
}
