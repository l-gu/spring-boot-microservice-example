package org.demo.app.service;

import org.demo.app.domain.Group;
import org.demo.app.model.GroupDTO;
import org.demo.app.repos.GroupRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupDTO> findAll() {
        return groupRepository.findAll()
                .stream()
                .map(group -> mapToDTO(group, new GroupDTO()))
                .collect(Collectors.toList());
    }

    public GroupDTO get(final Integer id) {
        return groupRepository.findById(id)
                .map(group -> mapToDTO(group, new GroupDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Integer create(final GroupDTO groupDTO) {
        final Group group = new Group();
        mapToEntity(groupDTO, group);
        return groupRepository.save(group).getId();
    }

    public void update(final Integer id, final GroupDTO groupDTO) {
        final Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(groupDTO, group);
        groupRepository.save(group);
    }

    public void delete(final Integer id) {
        groupRepository.deleteById(id);
    }

    private GroupDTO mapToDTO(final Group group, final GroupDTO groupDTO) {
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());
        return groupDTO;
    }

    private Group mapToEntity(final GroupDTO groupDTO, final Group group) {
        group.setName(groupDTO.getName());
        return group;
    }

}
