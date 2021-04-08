package org.demo.app.rest;

import org.demo.app.model.GroupDTO;
import org.demo.app.service.GroupService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private final GroupService groupService;

    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable final Integer id) {
        return ResponseEntity.ok(groupService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createGroup(@RequestBody @Valid final GroupDTO groupDTO) {
        return new ResponseEntity<>(groupService.create(groupDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGroup(@PathVariable final Integer id,
            @RequestBody @Valid final GroupDTO groupDTO) {
        groupService.update(id, groupDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable final Integer id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
