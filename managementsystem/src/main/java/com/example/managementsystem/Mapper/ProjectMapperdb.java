package com.example.managementsystem.Mapper;

import com.example.managementsystem.Entity.Project;
import com.example.managementsystem.Entity.Projectdb;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectMapperdb {
    public Projectdb getByProjectCode(String projectcode);
    public List<Projectdb> getByProjectList();
    public void insertProjectdb(Projectdb project);
    public void updateProjectqiang(Projectdb project);
    public void updateProjectliang(Projectdb project);
    public void updateProjectloumian(Projectdb project);
    public void updateProjectjiedian(Projectdb project);
    public void updateProjectlouti(Projectdb project);
    public void updateProjectdiaomo(Projectdb project);
    public void deleteProject(String projectcode);
}
