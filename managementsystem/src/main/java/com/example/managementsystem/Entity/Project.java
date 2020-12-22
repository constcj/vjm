package com.example.managementsystem.Entity;

public class Project {
    //项目代号
    public String projectcode;
    //项目名称
    public String projectname;
    //订单来源
    public String projectsource;
    //接收时间
    public String receivetime;
    //预计进场时间
    public String estimatetime;
    //指定科室
    public String department;
    //楼栋号
    public String projectnumber;
    //深化师
    public String deepeningdivision;
    //客户名称
    public String clientname;
    //市场/电话
    public String marketstaffwithcall;

    //深化相关文件路径
    public String deepfile;

    public String getDeepfile() {
        return deepfile;
    }

    public void setDeepfile(String deepfile) {
        this.deepfile = deepfile;
    }

    public String getDesignfile() {
        return designfile;
    }

    public void setDesignfile(String designfile) {
        this.designfile = designfile;
    }

    public String getQianginput() {
        return qianginput;
    }

    public void setQianginput(String qianginput) {
        this.qianginput = qianginput;
    }

    public String getLianginput() {
        return lianginput;
    }

    public void setLianginput(String lianginput) {
        this.lianginput = lianginput;
    }

    public String getLoumianinput() {
        return loumianinput;
    }

    public void setLoumianinput(String loumianinput) {
        this.loumianinput = loumianinput;
    }

    public String getJiedianinput() {
        return jiedianinput;
    }

    public void setJiedianinput(String jiedianinput) {
        this.jiedianinput = jiedianinput;
    }

    public String getLoutiinput() {
        return loutiinput;
    }

    public void setLoutiinput(String loutiinput) {
        this.loutiinput = loutiinput;
    }

    public String getDiaomoinput() {
        return diaomoinput;
    }

    public void setDiaomoinput(String diaomoinput) {
        this.diaomoinput = diaomoinput;
    }

    //墙是否输入数据
    public String qianginput;
    //梁是否输入数据
    public String lianginput;
    //楼面是否输入数据
    public String loumianinput;
    //节点是否输入数据
    public String jiedianinput;
    //楼梯是否输入数据
    public String loutiinput;
    //吊模是否输入数据
    public String diaomoinput;

    //设计相关文件路径
    public String designfile;

    public String getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(String receivetime) {
        this.receivetime = receivetime;
    }

    public String getEstimatetime() {
        return estimatetime;
    }

    public void setEstimatetime(String estimatetime) {
        this.estimatetime = estimatetime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProjectnumber() {
        return projectnumber;
    }

    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }

    public String getDeepeningdivision() {
        return deepeningdivision;
    }

    public void setDeepeningdivision(String deepeningdivision) {
        this.deepeningdivision = deepeningdivision;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getMarketstaffwithcall() {
        return marketstaffwithcall;
    }

    public void setMarketstaffwithcall(String marketstaffwithcall) {
        this.marketstaffwithcall = marketstaffwithcall;
    }

    public String getTemplatesystem() {
        return templatesystem;
    }

    public void setTemplatesystem(String templatesystem) {
        this.templatesystem = templatesystem;
    }

    public String getWhetherprefab() {
        return whetherprefab;
    }

    public void setWhetherprefab(String whetherprefab) {
        this.whetherprefab = whetherprefab;
    }

    public String getLayerheigh() {
        return layerheigh;
    }

    public void setLayerheigh(String layerheigh) {
        this.layerheigh = layerheigh;
    }

    public Double getProjectdifficulty() {
        return projectdifficulty;
    }

    public void setProjectdifficulty(Double projectdifficulty) {
        this.projectdifficulty = projectdifficulty;
    }

    public String getSignaturetime() {
        return signaturetime;
    }

    public void setSignaturetime(String signaturetime) {
        this.signaturetime = signaturetime;
    }

    public String getDesignmanager() {
        return designmanager;
    }

    public void setDesignmanager(String designmanager) {
        this.designmanager = designmanager;
    }

    public String getQiang() {
        return qiang;
    }

    public void setQiang(String qiang) {
        this.qiang = qiang;
    }

    public String getLiang() {
        return liang;
    }

    public void setLiang(String liang) {
        this.liang = liang;
    }

    public String getLouti() {
        return louti;
    }

    public void setLouti(String louti) {
        this.louti = louti;
    }

    public String getJiedian() {
        return jiedian;
    }

    public void setJiedian(String jiedian) {
        this.jiedian = jiedian;
    }

    public String getLoumian() {
        return loumian;
    }

    public void setLoumian(String loumian) {
        this.loumian = loumian;
    }

    public String getDiaomo() {
        return diaomo;
    }

    public void setDiaomo(String diaomo) {
        this.diaomo = diaomo;
    }

    //模板体系
    public String templatesystem;
    //是否预制
    public String whetherprefab;
    //层高
    public String layerheigh;
    //难度系数
    public Double projectdifficulty;
    //底图签字时间
    public String signaturetime;
    //负责人
    public String designmanager;
    //墙设计
    public String qiang;
    //梁设计
    public String liang;
    //楼梯设计
    public String louti;
    //节点设计
    public String jiedian;
    //楼面设计
    public String loumian;
    //吊模设计
    public String diaomo;

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getRealtime() {
        return realtime;
    }

    public void setRealtime(String realtime) {
        this.realtime = realtime;
    }

    //设计启动时间
    public String startime;
    //设计实际完成时间
    public String realtime;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    //状态
    public String tag;


    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectsource() {
        return projectsource;
    }

    public void setProjectsource(String projectsource) {
        this.projectsource = projectsource;
    }

}
