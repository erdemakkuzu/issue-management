package com.erdemakkuzu.issuemanagement.api;


import com.erdemakkuzu.issuemanagement.dto.IssueDto;
import com.erdemakkuzu.issuemanagement.dto.ProjectDto;
import com.erdemakkuzu.issuemanagement.service.impl.IssueServiceImpl;
import com.erdemakkuzu.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value =ApiPaths.IssueCtrl.CTRL, description = "IssueAPIs")
public class IssueController {

    /// HTTP Metodları
    // GET
    // POST
    // PUT
    // DELETE


    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl){

        this.issueServiceImpl=issueServiceImpl;

    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get by id operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id){


        IssueDto issueDto=issueServiceImpl.getById(id);

        return ResponseEntity.ok(issueDto);



    }

    @PostMapping()
    @ApiOperation(value = "Create project operation",response = IssueDto.class)
    public ResponseEntity<IssueDto>createProject(@Valid @RequestBody IssueDto issueDto){

        return ResponseEntity.ok(issueServiceImpl.save(issueDto));

    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update project operation",response = IssueDto.class)
    public ResponseEntity<IssueDto>updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody IssueDto issue){
        //SOLID
        return ResponseEntity.ok(issueServiceImpl.update(id,issue));

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete issue operation",response = Boolean.class)
    public ResponseEntity<Boolean>delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(issueServiceImpl.delete(id));

    }


}
