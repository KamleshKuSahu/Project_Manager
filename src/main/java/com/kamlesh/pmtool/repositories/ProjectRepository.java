package com.kamlesh.pmtool.repositories;

import com.kamlesh.pmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    // provided by jpa. Written like "findBy" and then attribute name. Ex: findByProjectName,findByStartDate, etc.
    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
}
