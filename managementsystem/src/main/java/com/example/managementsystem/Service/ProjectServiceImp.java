package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.Project;
import com.example.managementsystem.Entity.User;
import com.example.managementsystem.Mapper.ProjectMapper;
import com.example.managementsystem.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;


    @Override
    public Project getByProjectCode(String projectcode) {
        return projectMapper.getByProjectCode(projectcode);
    }

    @Override
    public List<Project> getByProjectList() {
        return projectMapper.getByProjectList();
    }

    @Override
    public void insertProject(Project project) {
        projectMapper.insertProject(project);
    }

    @Override
    public void updateProjectCode(Project project) {
        projectMapper.updateProjectCode(project);
    }

    @Override
    public void updateProjectName(Project project) {
        projectMapper.updateProjectName(project);
    }

    @Override
    public void updateProjectSource(Project project) {
        projectMapper.updateProjectSource(project);
    }

    @Override
    public void deleteProject(String projectcode) {
        projectMapper.deleteProject(projectcode);
    }

    @Override
    public void updateDeepdistr(Project project) {
        projectMapper.updateDeepdistr(project);
    }

    @Override
    public void updateFirstDeepo(Project project) {
        projectMapper.updateFirstDeepo(project);
    }

    @Override
    public void updateLastDeep(Project project) {
        projectMapper.updateLastDeep(project);
    }

    @Override
    public void updateDesigndistr(Project project) {
       projectMapper.updateDesigndistr(project);
    }

    @Override
    public void updateDesignfile(String designfile, String projectcode) {
        projectMapper.updateDesignfile(designfile,projectcode);
    }

    @Override
    public void updateLastDesign(Project project) {
        projectMapper.updateLastDesign(project);
    }

    @Override
    public void updateTag(String tag,String projectcode) {
        projectMapper.updateTag(tag,projectcode);
    }

    @Override
    public void updateCreateProject(Project project) {
        projectMapper.updateCreateProject(project);
    }

    @Override
    public void updateQinput(Boolean qianginput, String projectcode) {
        projectMapper.updateQinput(qianginput, projectcode);
    }

    @Override
    public void updateLinput(Boolean lianginput, String projectcode) {
projectMapper.updateLinput(lianginput, projectcode);
    }

    @Override
    public void updateLMinput(Boolean loumianinput, String projectcode) {
projectMapper.updateLMinput(loumianinput, projectcode);
    }

    @Override
    public void updateJieinput(Boolean jiedianinput, String projectcode) {
projectMapper.updateJieinput(jiedianinput, projectcode);
    }

    @Override
    public void updateLTinput(Boolean loutiinput, String projectcode) {
projectMapper.updateLTinput(loutiinput,projectcode);
    }

    @Override
    public void updateDMinput(Boolean diaomoinput, String projectcode) {
projectMapper.updateDMinput(diaomoinput,projectcode);
    }


    @Override
    public void updateDeepfile(String deepfile,String projectcode) {
        projectMapper.updateDeepfile(deepfile,projectcode);
    }
}
