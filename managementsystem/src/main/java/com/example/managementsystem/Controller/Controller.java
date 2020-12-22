package com.example.managementsystem.Controller;

import com.example.managementsystem.Annotations.PassToken;
import com.example.managementsystem.Annotations.UserLoginToken;
import com.example.managementsystem.Entity.Project;
import com.example.managementsystem.Entity.Projectdb;
import com.example.managementsystem.Entity.Projectwrong;
import com.example.managementsystem.Entity.User;

import com.example.managementsystem.Other.MapUser;
import com.example.managementsystem.Service.ProjectServiceImp;
import com.example.managementsystem.Service.ProjectdbServiceImp;
import com.example.managementsystem.Service.ProjectdbwrongServiceImp;
import com.example.managementsystem.Service.UserServiceImp;
import com.example.managementsystem.Token.tokenService;
import com.example.managementsystem.Websocket.MyWebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
public class Controller {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ProjectServiceImp projectServiceImp;

    @Autowired
    private ProjectdbServiceImp projectdbServiceImp;

    @Autowired
    private ProjectdbwrongServiceImp projectdbwrongServiceImp;

    //登录
    @PassToken
    @CrossOrigin
    @RequestMapping("/Login")
    public JSONObject getUser(@RequestBody JSONObject userd)
    {
       try {
           String userId=userd.get("userId").toString();
           String passWord=userd.get("passWord").toString();
           User user=userServiceImp.getUser(userId);
           if (user==null){
               return null;
           }else {
               if (user.password.equals(passWord))
               {
                   String token= tokenService.getToken(user);

                   JSONObject map= MapUser.GetUserMap(user);

                   map.put("token",token);

                   return map;

               }else {
                   return null;
               }
           }
       }catch (Exception e){
           return null;
       }
    }

    //退出
    @PassToken
    @CrossOrigin
    @RequestMapping("/Out/{id}")
    public void outU(@PathVariable(name = "id") String id)
    {
        try {
         MyWebSocket.outS(id);
        }catch (Exception e){

        }
    }

    //验证Token
    @UserLoginToken
    @CrossOrigin
    @RequestMapping("/Tok")
    public String verifyToken()
    {
        return "success";
    }

    //验证Token
    @CrossOrigin
    @RequestMapping("/Ex")
    public String Ex(HttpServletRequest request)
    {
        return "success";
    }

    //获取项目列表
    @CrossOrigin
    @RequestMapping("/list")
    public List<Project> listUser(){  //这个地方用model来存储数据，里面存储键值对，值可以为list
        return projectServiceImp.getByProjectList();
    }

    //获取项目列表
    @CrossOrigin
    @RequestMapping("/t")
    public String test(){  //这个地方用model来存储数据，里面存储键值对，值可以为list
        return "HHHH";
    }


    //获取项目列表
   @CrossOrigin
    @RequestMapping("/listdb")
    public List<Projectdb> listdb(){  //这个地方用model来存储数据，里面存储键值对，值可以为list
        return projectdbServiceImp.getByProjectList();
    }

    //获取项目错误列表
    @CrossOrigin
    @RequestMapping("/listdbwrong")
    public List<Projectwrong> listdbwrong(){  //这个地方用model来存储数据，里面存储键值对，值可以为list
        return projectdbwrongServiceImp.getByProjectList();
    }

    //获取深化人员列表
    @CrossOrigin
    @RequestMapping("/DeepPerson/{department}")
    public List<String> DeepPersonUser(@PathVariable(name = "department") String department){
        //这个地方用model来存储数据，里面存储键值对，值可以为list
        return MapUser.GetDeepPersonName(userServiceImp.getByDeepList(department,"深化师"));

    }

    //获取设计人员列表
    @CrossOrigin
    @RequestMapping("/DesignPerson")
    public List<String> DesignPersonUser(@RequestBody JSONObject userd){
        //这个地方用model来存储数据，里面存储键值对，值可以为list
        return MapUser.GetDeepPersonName(userServiceImp.getByDesignList(userd.get("department").toString(),userd.get("mgroup").toString(),"设计师"));
    }

    //修改新建项目数据
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/changProject" , method= RequestMethod.POST)
    public String changCreateProject(@RequestBody  List<Project> projects){

        List<String> code=new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null)
            {return "faile";}
        }

       // String department="";

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateCreateProject(projects.get(i));
        }

       // department=department+"新增项目";

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //新建项目
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/NewProject" , method= RequestMethod.POST)
    public String NewCreateProject(@RequestBody  List<Project> projects){

        List<String> code=new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if ( code.contains(codem)){
                return "faile";
            }else {
                code.add(codem);
            }

            if (project1!=null)
            {return "faile";}
        }

        // String department="";

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.insertProject(projects.get(i));
        }


        // department=department+"新增项目";

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //分配深化是后更新
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/Deepdistr" , method= RequestMethod.POST)
    public String Deepdistr(@RequestBody  List<Project> projects){

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null)

            {return "faile";}

        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateDeepdistr(projects.get(i));
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //第一次深化更新数据库,并且数据不分东西单元的情况
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/FirstDeepo" , method= RequestMethod.POST)
    public String FirstDeepo(@RequestBody  List<Project> projects){

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null)

            {return "faile";}

        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateFirstDeepo(projects.get(i));
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //第一次深化更新数据库,并且数据分东西单元的情况
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/FirstDeepi" , method= RequestMethod.POST)
    public String FirstDeepi(@RequestBody  List<Project> projects){

        List<String> codelist=new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1!=null)

            {return "faile";}else {

                codem=codem.trim();
                codem=codem.substring(0,codem.length()-1);

             if (!codelist.contains(codem))  codelist.add(codem);
            }
        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.insertProject(projects.get(i));
        }

        for (String code :
                codelist) {
            projectServiceImp.deleteProject(code);
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //上传设计文件
    @CrossOrigin
    @PostMapping("/designupload/{code}")
    public String designRefresh(@PathVariable(name = "code") String code,@RequestParam("file") MultipartFile file) {
        //获取文件名
        String filePath = "F:\\HTML\\upload1\\";

        String[] codelist=code.split("-");

        String fileName = file.getOriginalFilename();

        String filepathname=filePath+ codelist[0]+"-"+fileName;

        //获取文件后缀名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        File fi=new File(filepathname);
        try {

            file.transferTo(fi);

            for (int i = 0; i < codelist.length; i++) {
                projectServiceImp.updateDesignfile(filepathname,codelist[i]);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //删除设计文件
    @CrossOrigin
    @PostMapping("/designdelete/{code}")
    public String deletedesign(@PathVariable(name = "code") String code) {

        try {

            String[] codelist=code.split("-");

            for (int i = 0; i < codelist.length; i++) {

                Project project=projectServiceImp.getByProjectCode(codelist[i]);
                File fi=new File(project.getDesignfile());
                if (fi.exists()){
                    fi.delete();
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    //上传深化文件
    @CrossOrigin
    @PostMapping("/deepupload/{code}")
    public String localRefresh(@RequestParam("file") MultipartFile file,@PathVariable(name = "code") String code) {
        //获取文件名
        String filePath = "F:\\HTML\\upload\\";

        String[] codelist=code.split("-");

        String fileName = file.getOriginalFilename();

        String filepathname=filePath+ codelist[0]+"-"+fileName;

        //获取文件后缀名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        File fi=new File(filepathname);
        try {

            file.transferTo(fi);

            for (int i = 0; i < codelist.length; i++) {
                projectServiceImp.updateDeepfile(filepathname,codelist[i]);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //删除深化文件
    @CrossOrigin
    @PostMapping("/deepdelete/{code}")
    public String deleteRefresh(@PathVariable(name = "code") String code) {

        try {

            String[] codelist=code.split("-");

            for (int i = 0; i < codelist.length; i++) {

                Project project=projectServiceImp.getByProjectCode(codelist[i]);
                File fi=new File(project.getDeepfile());
                if (fi.exists()){
                    fi.delete();
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    //最后深化更新数据库
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/LastDeep" , method= RequestMethod.POST)
    public String LastDeep(@RequestBody  List<Project> projects){

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null) return "faile";

        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateLastDeep(projects.get(i));
        }

       // MyWebSocket.sendInfo("新增项目");在上传深化文件后进行刷新

        return "success";
    }

    //最后设计更新数据库
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/LastDesign" , method= RequestMethod.POST)
    public String LastDesign(@RequestBody  List<Project> projects){

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null) return "faile";

        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateLastDesign(projects.get(i));
        }

        //MyWebSocket.sendInfo("新增项目");在上传下发资料后进行刷新

        return "success";
    }

    //下载深化文件
    @CrossOrigin
    @RequestMapping(value="/download/{code}",method= RequestMethod.POST)
    public void downFile(@PathVariable(name = "code") String code,HttpServletResponse resp) {

        Project project=projectServiceImp.getByProjectCode(code);

        String name=project.getDeepfile();

        String path=name;
        File file = new File(path);
        resp.setContentType("application/octet-stream");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);

        try {
            FileInputStream fis = new FileInputStream(path);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();

            ServletOutputStream sos = resp.getOutputStream();
            sos.write(content);
            sos.flush();
            sos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    //下载设计文件
    @CrossOrigin
    @RequestMapping(value="/downloads/{code}",method= RequestMethod.POST)
    public void downFiles(@PathVariable(name = "code") String code,HttpServletResponse resp) {

        Project project=projectServiceImp.getByProjectCode(code);

        String name=project.getDesignfile();

        String path=name;
        File file = new File(path);
        resp.setContentType("application/octet-stream");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);

        try {
            FileInputStream fis = new FileInputStream(path);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();

            ServletOutputStream sos = resp.getOutputStream();
            sos.write(content);
            sos.flush();
            sos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    //分配设计师后更新
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/Updatedesigndistr" , method= RequestMethod.POST)
    public String Updatedesigndistr(@RequestBody  List<Project> projects){

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Project project1=projectServiceImp.getByProjectCode(codem);

            if (project1==null)

            {return "faile";}

        }

        for (int i = 0; i < projects.size(); i++) {
            projectServiceImp.updateDesigndistr(projects.get(i));
        }

        MyWebSocket.sendInfo("新增项目");

        return "success";
    }

    //填写数据
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/updateregiondb/{regions}" , method= RequestMethod.POST)
    public String Updateregiondb(@PathVariable(name = "regions") String regions,@RequestBody  List<Projectdb> projects){

        List<String> code=new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {

            String codem=projects.get(i).getProjectcode();

            Projectdb project1=projectdbServiceImp.getByProjectCode(codem);

            if (project1==null)
            {
                projectdbServiceImp.insertProjectdb(projects.get(i));

            }else {

                if (regions.indexOf("qiang")>-1){
                    projectdbServiceImp.updateProjectqiang(projects.get(i));
                }
                if (regions.indexOf("liang")>-1){
                    projectdbServiceImp.updateProjectliang(projects.get(i));
                }
                if (regions.indexOf("loumian")>-1){
                    projectdbServiceImp.updateProjectloumian(projects.get(i));
                }
                if (regions.indexOf("jiedian")>-1){
                    projectdbServiceImp.updateProjectjiedian(projects.get(i));
                }
                if (regions.indexOf("diaomo")>-1){
                    projectdbServiceImp.updateProjectdiaomo(projects.get(i));
                }
                if (regions.indexOf("louti")>-1){
                    projectdbServiceImp.updateProjectlouti(projects.get(i));
                }
            }

            if (regions.indexOf("qiang")>-1){
                projectServiceImp.updateQinput(true,codem);
            }
            if (regions.indexOf("liang")>-1){
                projectServiceImp.updateLinput(true,codem);
            }
            if (regions.indexOf("loumian")>-1){
                projectServiceImp.updateLMinput(true,codem);
            }
            if (regions.indexOf("jiedian")>-1){
                projectServiceImp.updateJieinput(true,codem);
            }
            if (regions.indexOf("diaomo")>-1){
                projectServiceImp.updateDMinput(true,codem);
            }
            if (regions.indexOf("louti")>-1){
                projectServiceImp.updateLTinput(true,codem);
            }
        }

        // department=department+"新增项目";

        MyWebSocket.sendInfo("更新项目及项目数据");

        return "success";
    }

    //填写错误数据
    @UserLoginToken
    @CrossOrigin
    @RequestMapping(value = "/updateprojectwrong" , method= RequestMethod.POST)
    public String Updateregionwrong(@RequestBody  Projectwrong project){

            String codem=project.getProjectcode();

            Projectwrong project1=projectdbwrongServiceImp.getByProjectCode(codem);

            if (project1==null)
            {
                projectdbwrongServiceImp.insertProjectdb(project);

            }else {

                project1.setDiaomoalincrease(project1.getDiaomoironincrease()+project.getDiaomoalincrease());
                project1.setDiaomoalreplace(project1.getDiaomoalreplace()+project.getDiaomoalreplace());
                project1.setDiaomoironincrease(project1.getDiaomoironincrease()+project.getDiaomoironincrease());
                project1.setDiaomoironreplace(project.getDiaomoironreplace()+project1.getDiaomoironreplace());
                project1.setDiaomomountings(project1.getDiaomomountings()+project.getDiaomomountings());

                project1.setJiedianalincrease(project.getJiedianalincrease()+project1.getJiedianalincrease());
                project1.setJiedianalreplace(project1.getJiedianalreplace()+project.getJiedianalreplace());
                project1.setJiedianmountings(project1.getJiedianmountings()+project.getJiedianmountings());

                project1.setLiangalincrease(project1.getLiangalincrease()+project.getLiangalincrease());
                project1.setLiangalreplace(project1.getLiangalreplace()+project.getLiangalreplace());
                project1.setLiangmountings(project1.getLiangmountings()+project.getLiangmountings());

                project1.setQiangalbincrease(project.getQiangalbincrease()+project1.getQiangalbincrease());
                project1.setQiangalbreplace(project.getQiangalbreplace()+project1.getQiangalbreplace());
                project1.setQiangalincrease(project1.getQiangalincrease()+project.getQiangalincrease());
                project1.setQiangalreplace(project1.getQiangalreplace()+project.getQiangalreplace());
                project1.setQiangironincrease(project.getQiangironincrease()+project1.getQiangironincrease());
                project1.setQiangironreplace(project.getQiangironreplace()+project1.getQiangironreplace());
                project1.setQiangmountings(project.getQiangmountings()+project1.getQiangmountings());

                project1.setLoumianalincrease(project.getLoumianalincrease()+project1.getLoumianalincrease());
                project1.setLoumianalreplace(project.getLoumianalreplace()+project1.getLoumianalreplace());
                project1.setLoumianmountings(project.getLoumianmountings()+project1.getLoumianmountings());

                project1.setLoutialbincrease(project.getLoutialbincrease()+project1.getLoutialbincrease());
                project1.setLoutialbreplace(project.getLoutialbreplace()+project1.getLoutialbreplace());
                project1.setLoutialincrease(project.getLoutialincrease()+project1.getLoutialincrease());
                project1.setLoutialreplace(project.getLoutialreplace()+project1.getLoutialreplace());
                project1.setLoutiironincrease(project.getLoutiironincrease()+project1.getLoutiironincrease());
                project1.setLoutiironreplace(project.getLoutiironreplace()+project1.getLoutiironreplace());
                project1.setLoutimountings(project.getLoutimountings()+project1.getLoutimountings());

                project1.setRemark(project1.getRemark()+";"+project.getRemark());

                projectdbwrongServiceImp.updateProjectwrong(project1);

            }


        // department=department+"新增项目";

        MyWebSocket.sendInfo("错误数据");

        return "success";
    }

}
