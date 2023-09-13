package com.kamlesh.pmtool.web;

import com.kamlesh.pmtool.domain.Project;
import com.kamlesh.pmtool.service.ErrorMappingService;
import com.kamlesh.pmtool.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ErrorMappingService errorMappingService;

    //@Valid - helpful to check project p object is valid or not
    //BindingResult - it has function that know that the p object will give error or not after checking from @Valid
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project p, BindingResult result){
        ResponseEntity<?> errorMap = errorMappingService.mapValidationService(result);
        if(errorMap!=null)
            return errorMap;


        projectService.saveOrUpdateProject(p);
        return new ResponseEntity<Project>(p, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }


}
