package com.kamlesh.pmtool.service;

import com.kamlesh.pmtool.domain.Project;
import com.kamlesh.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project a){

        return projectRepository.save(a);
    }

}
