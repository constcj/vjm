package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.Projectdb;
import com.example.managementsystem.Entity.Projectwrong;
import com.example.managementsystem.Mapper.ProjectMapperdb;
import com.example.managementsystem.Mapper.ProjectMapperwrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectdbwrongServiceImp implements ProjectdbwrongService {

    @Autowired
    private ProjectMapperwrong projectMapperdbwrong;

    @Override
    public Projectwrong getByProjectCode(String projectcode) {
        return projectMapperdbwrong.getByProjectCode(projectcode);
    }

    @Override
    public List<Projectwrong> getByProjectList() {
        return projectMapperdbwrong.getByProjectList();
    }

    @Override
    public void insertProjectdb(Projectwrong project) {
        projectMapperdbwrong.insertProjectdb(project);
    }

    @Override
    public void updateProjectwrong(Projectwrong project) {
        projectMapperdbwrong.updateProjectwrong(project);
    }

    @Override
    public void deleteProject(String projectcode) {
        projectMapperdbwrong.deleteProject(projectcode);
    }
}
