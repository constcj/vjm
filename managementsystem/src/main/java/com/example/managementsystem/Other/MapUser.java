package com.example.managementsystem.Other;

import com.example.managementsystem.Entity.User;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapUser {
    public static JSONObject GetUserMap(User user){

        JSONObject hashMap=new JSONObject();

        hashMap.put("wrongfill",user.getWrongfill());
        hashMap.put("name",user.getName());
        hashMap.put("id",user.getId());
        hashMap.put("department",user.getDepartment());
        hashMap.put("mposition",user.getMposition());
        hashMap.put("mgroup",user.getMgroup());
        hashMap.put("creatproject",user.getCreatproject());
        hashMap.put("creatprojectlist",user.getCreatprojectlist());
        hashMap.put("receiveconfirmation",user.getReceiveconfirmation());
        hashMap.put("allocationitem",user.getAllocationitem());
        hashMap.put("deep",user.getDeep());
        hashMap.put("realdeep",user.getRealdeep());
        hashMap.put("designmanager",user.getDesignmanager());
        hashMap.put("designmanagerdistr",user.getDesignmanagerdistr());
        hashMap.put("realdesignmanager",user.getRealdesignmanager());
        hashMap.put("designperson",user.getDesignperson());
        hashMap.put("realdesignperson",user.getRealdesignperson());
        hashMap.put("deeping",user.getDeeping());
        hashMap.put("deepse",user.getDeepse());
        hashMap.put("deepingse",user.getDeepingse());
        hashMap.put("realdesignmanagerse",user.getRealdesignmanagerse());
        hashMap.put("realdesignmanagersese",user.getRealdesignmanagersese());
        hashMap.put("designpersonse",user.getDesignpersonse());
        hashMap.put("projectInformation",user.getProjectInformation());
        hashMap.put("creatprojectchange",user.getCreatprojectchange());
        hashMap.put("bbs",user.getBbs());
        return hashMap;

    }

    public static List<String> GetDeepPersonName(List<User>  userList)
    {
        List<String> nameList=new ArrayList<>();

        for (int i = 0; i < userList.size(); i++) {
            nameList.add(userList.get(i).getName());
        }

        return  nameList;
    }
}
