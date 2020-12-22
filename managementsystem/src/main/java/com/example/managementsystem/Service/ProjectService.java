package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.Project;
import com.example.managementsystem.Entity.User;

import java.util.List;

public interface ProjectService {
  public Project getByProjectCode(String projectcode);
  public List<Project>  getByProjectList();
  public void insertProject(Project project);
  public void updateProjectCode(Project project);
  public void updateProjectName(Project project);
  public void updateProjectSource(Project project);
  public void deleteProject(String projectcode);
  public void updateDeepdistr(Project project);
  public void updateFirstDeepo(Project project);
  public void updateDeepfile(String deepfile,String projectcode);
  public void updateLastDeep(Project project);
  public void updateDesigndistr(Project project);
  public void updateDesignfile(String designfile,String projectcode);
  public void updateLastDesign(Project project);
  public void updateTag(String tag,String projectcode);
  public void updateCreateProject(Project project);

  public void updateQinput(Boolean qianginput,String projectcode);
  public void updateLinput(Boolean lianginput,String projectcode);
  public void updateLMinput(Boolean loumianinput,String projectcode);
  public void updateJieinput(Boolean jiedianinput,String projectcode);
  public void updateLTinput(Boolean loutiinput,String projectcode);
  public void updateDMinput(Boolean diaomoinput,String projectcode);
}
