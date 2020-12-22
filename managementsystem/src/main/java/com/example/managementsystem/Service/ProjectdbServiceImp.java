package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.Project;
import com.example.managementsystem.Entity.Projectdb;
import com.example.managementsystem.Mapper.ProjectMapper;
import com.example.managementsystem.Mapper.ProjectMapperdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectdbServiceImp implements ProjectdbService {

    @Autowired
    private ProjectMapperdb projectMapperdb;


    @Override
    public Projectdb getByProjectCode(String projectcode) {
        return projectMapperdb.getByProjectCode(projectcode);
    }

    @Override
    public List<Projectdb> getByProjectList() {
        return projectMapperdb.getByProjectList();
    }

    @Override
    public void insertProjectdb(Projectdb project) {
            projectMapperdb.insertProjectdb(project);
    }

    @Override
    public void updateProjectqiang(Projectdb project) {
            projectMapperdb.updateProjectqiang(project);
    }

    @Override
    public void updateProjectliang(Projectdb project) {
            projectMapperdb.updateProjectliang(project);
    }

    @Override
    public void updateProjectloumian(Projectdb project) {
            projectMapperdb.updateProjectloumian(project);
    }

    @Override
    public void updateProjectjiedian(Projectdb project) {
            projectMapperdb.updateProjectjiedian(project);
    }

    @Override
    public void updateProjectlouti(Projectdb project) {
            projectMapperdb.updateProjectlouti(project);
    }

    @Override
    public void updateProjectdiaomo(Projectdb project) {
            projectMapperdb.updateProjectdiaomo(project);
    }

    @Override
    public void deleteProject(String projectcode) {
            projectMapperdb.deleteProject(projectcode);
    }
}
