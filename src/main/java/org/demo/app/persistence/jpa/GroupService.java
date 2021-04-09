package org.demo.app.persistence.jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.demo.app.dto.GroupDTO;
import org.springframework.stereotype.Service;


@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    private GroupEntity findByPK(Integer id) {
        Optional<GroupEntity> r = groupRepository.findById(id);
        if ( r.isPresent() ) {
        	return r.get();
        }
        else {
        	return null;
        }
    }
    
    public List<GroupDTO> findAll() {
        return groupRepository.findAll()
                .stream()
                .map(group -> mapToDTO(group, new GroupDTO()))
                .collect(Collectors.toList());
    }

    public GroupDTO get(final Integer id) {
//        return groupRepository.findById(id)
//                .map(group -> mapToDTO(group, new GroupDTO()))
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	GroupEntity groupEntity = findByPK(id);
        if ( groupEntity != null ) {
        	GroupDTO dto = new GroupDTO();
        	mapToDTO(groupEntity, dto);
        	return dto;
        }
        else {
        	return null;
        }        
    }

    public Integer create(final GroupDTO groupDTO) {
        final GroupEntity groupEntity = new GroupEntity();
        mapToEntity(groupDTO, groupEntity);
        // Save in database
        //return groupRepository.save(group).getId();
        GroupEntity groupSaved =  groupRepository.save(groupEntity);
        // return PK ( in case of auto-generated key )
        return groupSaved.getId();
    }

    public boolean update(final Integer id, final GroupDTO groupDTO) {
    	// Check existence before update
//        final GroupEntity groupEntity = groupRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	GroupEntity groupEntity = findByPK(id);
        if ( groupEntity != null ) {
            mapToEntity(groupDTO, groupEntity);
            groupEntity.setId(id); // force PK received in URL path
            groupRepository.save(groupEntity);
            return true;
        }
        else {
            return false;
        }
    }

    public void delete(final Integer id) {
        groupRepository.deleteById(id);
    }

    private GroupDTO mapToDTO(final GroupEntity group, final GroupDTO groupDTO) {
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());
        return groupDTO;
    }

    private GroupEntity mapToEntity(final GroupDTO groupDTO, final GroupEntity group) {
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        return group;
    }

}
