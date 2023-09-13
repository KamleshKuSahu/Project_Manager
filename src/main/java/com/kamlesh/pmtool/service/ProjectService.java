package com.kamlesh.pmtool.service;

import com.kamlesh.pmtool.domain.Project;
import com.kamlesh.pmtool.exception.ProjectIdException;
import com.kamlesh.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project a){
        try {
            a.setProjectIdentifier(a.getProjectIdentifier().toUpperCase());
            return projectRepository.save(a);
        }
        catch (Exception e){
            throw new ProjectIdException("Project Id '"+a.getProjectIdentifier().toUpperCase()+"' already exist.");
        }
    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null)
            throw new ProjectIdException("Project Id '"+projectId+"' does not exist.");
        return project;
    }

}
