package com.erdemakkuzu.issuemanagement.service;

import com.erdemakkuzu.issuemanagement.dto.ProjectDto;
import com.erdemakkuzu.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by temelt on 4.02.2019.
 */
public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id,ProjectDto project);
}
