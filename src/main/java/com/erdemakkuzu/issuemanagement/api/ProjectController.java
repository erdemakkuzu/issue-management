package com.erdemakkuzu.issuemanagement.api;

import com.erdemakkuzu.issuemanagement.dto.ProjectDto;
import com.erdemakkuzu.issuemanagement.service.impl.ProjectServiceImpl;
import com.erdemakkuzu.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
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
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "ProjectAPIs")
public class ProjectController {

  /// HTTP Metodları
  // GET
  // POST
  // PUT
  // DELETE


  private final ProjectServiceImpl projectServiceImpl;

  public ProjectController(ProjectServiceImpl projectServiceImpl) {

    this.projectServiceImpl = projectServiceImpl;

  }


  @ApiOperation(value = "Get by id operation", response = ProjectDto.class)
  @GetMapping("/{id}")
  public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {

    ProjectDto projectDto = projectServiceImpl.getById(id);

    return ResponseEntity.ok(projectDto);


  }

  @ApiOperation(value = "Create operation", response = ProjectDto.class)
  @PostMapping()
  public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {

    return ResponseEntity.ok(projectServiceImpl.save(projectDto));

  }

  @ApiOperation(value = "Update  operation", response = ProjectDto.class)
  @PutMapping("/{id}")
  public ResponseEntity<ProjectDto> updateProject(
      @PathVariable(value = "id", required = true) Long id,
      @Valid @RequestBody ProjectDto project) {
    //SOLID
    return ResponseEntity.ok(projectServiceImpl.update(id, project));

  }

  @ApiOperation(value = "Delete operation", response = Boolean.class)
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

    return ResponseEntity.ok(projectServiceImpl.delete(id));

  }


}
