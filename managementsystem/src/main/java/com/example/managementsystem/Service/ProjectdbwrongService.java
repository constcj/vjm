package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.Projectdb;
import com.example.managementsystem.Entity.Projectwrong;

import java.util.List;

public interface ProjectdbwrongService {
  public Projectwrong getByProjectCode(String projectcode);
  public List<Projectwrong> getByProjectList();
  public void insertProjectdb(Projectwrong project);
  public void updateProjectwrong(Projectwrong project);
  public void deleteProject(String projectcode);
}
