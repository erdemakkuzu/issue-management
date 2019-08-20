package com.erdemakkuzu.issuemanagement.api;

import com.erdemakkuzu.issuemanagement.dto.ProjectDto;
import com.erdemakkuzu.issuemanagement.service.impl.ProjectServiceImpl;
import com.erdemakkuzu.issuemanagement.util.ApiPaths;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    /// HTTP Metodları
    // GET
    // POST
    // PUT
    // DELETE


    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){

        this.projectServiceImpl=projectServiceImpl;

    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id){


        ProjectDto projectDto=projectServiceImpl.getById(id);

        return ResponseEntity.ok(projectDto);



    }

    @PostMapping()
    public ResponseEntity<ProjectDto>createProject(@Valid @RequestBody ProjectDto projectDto){

        return ResponseEntity.ok(projectServiceImpl.save(projectDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto>updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody ProjectDto project){
        //SOLID
        return ResponseEntity.ok(projectServiceImpl.update(id,project));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }


}
