package com.erdemakkuzu.issuemanagement.api;


import com.erdemakkuzu.issuemanagement.dto.IssueDto;
import com.erdemakkuzu.issuemanagement.service.impl.IssueServiceImpl;
import com.erdemakkuzu.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
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
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id){


        IssueDto issueDto=issueServiceImpl.getById(id);

        return ResponseEntity.ok(issueDto);



    }

    @PostMapping()
    public ResponseEntity<IssueDto>createProject(@Valid @RequestBody IssueDto issueDto){

        return ResponseEntity.ok(issueServiceImpl.save(issueDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto>updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody IssueDto issue){
        //SOLID
        return ResponseEntity.ok(issueServiceImpl.update(id,issue));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(issueServiceImpl.delete(id));

    }


}
