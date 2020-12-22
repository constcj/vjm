package com.example.managementsystem.Mapper;

import com.example.managementsystem.Entity.Projectdb;
import com.example.managementsystem.Entity.Projectwrong;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectMapperwrong {
    public Projectwrong getByProjectCode(String projectcode);
    public List<Projectwrong> getByProjectList();
    public void insertProjectdb(Projectwrong project);
    public void updateProjectwrong(Projectwrong project);
    public void deleteProject(String projectcode);
}
