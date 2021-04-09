package org.demo.app.rest;

import java.util.List;

import javax.validation.Valid;

import org.demo.app.dto.GroupDTO;
import org.demo.app.persistence.jpa.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/api/groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private final GroupService groupService;

    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAll() {
        return ResponseEntity.ok(groupService.findAll()); // always return 200 (if no exception)
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable final Integer id) {
    	GroupDTO o = groupService.get(id);
    	if (o != null) {
            return ResponseEntity.ok(groupService.get(id));
    	}
    	else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
    }

    @PostMapping
    public ResponseEntity<Integer> createGroup(@RequestBody @Valid final GroupDTO groupDTO) {
    	// Return HttpStatus.CREATED only if really created
        return new ResponseEntity<>(groupService.create(groupDTO), HttpStatus.CREATED);
    }

    /**
     * Full update (if resource exists)
     * @param id
     * @param groupDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGroup(@PathVariable final Integer id,
            @RequestBody @Valid final GroupDTO groupDTO) {
        if ( groupService.update(id, groupDTO) ) {
            return ResponseEntity.ok().build(); // return "200 OK"
        }
    	else {
            return ResponseEntity.notFound().build(); 
    	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable final Integer id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build(); // return "204 No Content"
    }

    /**
     * Partial update (if resource exists)
     * @param id
     * @param groupDTO
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchGroup(@PathVariable final Integer id,
            @RequestBody @Valid final GroupDTO groupDTO) {
        // groupService.patch(id, groupDTO); // not yet implemented
        // return ResponseEntity.ok().build();
        
    	// return ResponseEntity.badRequest().build(); // Not supported : 400 Bad Request.
    	 
    	// Test exception management : OK (return HTTP 500 with exception name "IllegalStateException")
    	throw new IllegalStateException("My exception test for PATCH verb");
        
    }
    
    // HEAD : not supported
    // OPTIONS : not supported
    
}
