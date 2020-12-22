import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import { Message } from 'element-ui';

Vue.use(Vuex);

const state = {   //要设置的全局访问的state对象
    showFooter: true,


    allprojectlist: [],//所有项目信息
    projectdb: [],//项目数据信息 
    projectdbwrong: [],//项目错误数据
    

    //计划员----
    creatcompletelist: [],//创建完成项目信息
    plannercanchange: {},//计划员输入的数据是否可以修改，通过判断项目状态确定,不同项目代号对应不同的条件
    plannerchangselect: [],
    //----

    //其他---------
    projectInfo: [],//查看项目信息时，信息保存位置
    projectInfodb: [],//查看项目信息时，设计数据信息保存位置
    newprojectlist: [],
    projectInfodbwronglook:[],
    //---------

    //深化负责人---
    deepdistrlist: [],//深化负责人未分配深化师项目列表
    deepdistr: 0,//未分配深化师时数量大于0
    deeppersonlist: [],//未分配深化师项目列表里面深化师名字列表
    deepdistrcomplete: [],//已经完成分配项目列表
    //----

    name: [],

    //深化师------
    deep: [],
    deepcount: 0,
    deepselect: [],//首次深化选择
    deepse: [],
    deepselectse: [],
    deepcountse: 0,
    realdeepse: [],
    //---------

    //设计师负责人------
    design: [],//设计分配数据列表
    designcount: 0,
    designmangerfirstselect: [],//设计选择
    designcountse: 0,
    designmangerselecttwo: [],
    designpersonlist: [],//设计师名字列表
    designtwo: [],//设计分配后项目列表
    designfinal: [],//都完成后列表
    selectwrong: [],//工艺/设计问题项目
    selectwrongdb: [],//工艺/设计问题选择项目的数据
    projectInfodbwrong: [],//根据选择项目获取对应错误数据
    //------

    //设计师---------
    designsepe: [],
    designpersonselect: [],
    syst: "",//记录体系
    designcountsepe: 0,
    //-------

    designcomplete: [],//设计师已完成项目

    designs: [],

    department: [{ text: '1科', value: '1科' }, { text: '2科', value: '2科' }, { text: '3科', value: '3科' },
    { text: '4科', value: '4科' }, { text: '5科', value: '5科' }, { text: '6科', value: '6科' }],

    tag: [{ text: '深化师未分配', value: '深化师未分配' }, { text: '初次深化中', value: '初次深化中' },
    { text: '最终深化中', value: '最终深化中' }, { text: '最终深化中/提前介入', value: '最终深化中/提前介入' },
    { text: '深化完成', value: '深化完成' }, { text: '深化完成/设计阶段', value: '深化完成/设计阶段' },
    { text: '深化完成/设计完成', value: '深化完成/设计完成' }, { text: '全部完成', value: '全部完成' }],

    showup: '显示',
    count: 0,//未处理项目数量
    routers: "",

    BreadcrumbData: [],

    creatproject: [],//新建项目，分配给深化

    displaybool: {},//权限显示

    outtype: false//退出类型
};
const getters = {   //实时监听state值的变化(最新状态)
    getouttype(state) {//websocket对象
        return state.outtype;
    },
    getsock(state) {//websocket对象
        return state.sock;
    },
    getlockReconnect(state) {//判断websocket是否连接
        return state.lockReconnect;
    },

    getdisplaybool(state) {//权限显示
        return state.displaybool;
    },
    //计划员---
    getcreatcompletelist(state) {//创建完成项目信息
        return state.creatcompletelist;
    },
    getplannercanchange(state) {//输入的数据是否可以修改，通过判断项目状态确定，所有修改的条件一致
        return state.plannercanchange;
    },
    getplannerchangselect(state) {//选择需要修改的项目
        return state.plannerchangselect;
    },
    //---


    //深化负责人--
    getdeepdistrlist(state) {//分配深化师
        return state.deepdistrlist;
    },
    getdeepdistr(state) {
        return state.deepdistr;
    },
    getdeeppersonlist(state) {
        return state.deeppersonlist;
    },
    getdeepselect(state) {
        return state.deepselect;
    },
    getdeepdistrcomplete(state) {
        return state.deepdistrcomplete;
    },
    //--

    getallprojectlist(state) {
        return state.allprojectlist;
    },
    getprojectdb(state) {
        return state.projectdb;
    },
    getprojectdb(state) {
        return state.projectdbwrong;
    },
    //深化师------
    getdeep(state) {
        return state.deep;//初次深化项目列表
    },
    getdeepcount(state) {
        return state.deepcount;//初次深化数量
    },
    getdeepse(state) {//最后深化
        return state.deepse;
    },
    getdeepselectse(state) {
        return state.deepselectse;//最后深化进行深化时选择项目
    },
    getdeepcountse(state) {
        return state.deepcountse;//最后深化项目数量
    },
    getrealdeepse(state) {
        return state.realdeepse;//深化完成列表
    },
    //-------

    //设计负责人
    getdesignpersonlist(state) {
        return state.designpersonlist;//设计师列表
    },
    getdesign(state) {//设计分配数据列表
        return state.design;
    },
    getdesigncount(state) {
        return state.designcount;
    },
    getdesignmangerfirstselect(state) {
        return state.designmangerfirstselect;
    },
    getdesigntwo(state) {//分配设计后项目
        return state.designtwo;
    },
    getdesigncountse(state) {
        return state.designcountse;
    },
    getdesignmangerselecttwo(state) {
        return state.designmangerselecttwo;
    },
    getdesignfinal(state) {
        return state.designfinal;
    },
    getselectwrong(state) {//问题项目数据记录
        return state.selectwrong;
    },
    getselectwrongdb(state) {//问题项目数据记录
        return state.selectwrongdb;
    },
    //

    getprojectInfodbwrong(state) {//根据项目获取对应数据
        return state.projectInfodbwrong;
    },

    //设计师---------
    getdesignsepe(state) {
        return state.designsepe;
    },
    getdesignpersonselect(state) {
        return state.designpersonselect;
    },
    getsyst(state) {
        return state.syst;
    },
    getdesigns(state) {  //承载变化的showFooter的值
        return state.designs
    },
    getdesigncomplete(state) {
        return state.designcomplete;
    },
    getdesigncountsepe(state) {
        return state.designcountsepe;
    },
    //----------

    getNewprojectlist(state) {
        return state.newprojectlist;
    },
    gettableData(state) {  //承载变化的tableData的值
        return state.tableData;
    },
    getProjectInfo(state) {
        return state.projectInfo;
    },
    getProjectInfodb(state) {
        return state.projectInfodb;
    },
    getprojectInfodbwronglook(state) {
        return state.projectInfodbwronglook;
    },
    getdepartment(state) {
        return state.department;
    },

    gettag(state) {
        return state.tag;
    },

    getS(state) {
        return state.showup;
    },
    getCount(state) {
        return state.count;
    },
    getRoutes(state) {
        return state.routers;
    },
    getBreadcrumbData(state) {
        return state.BreadcrumbData;
    },
    getCreatPoject(state) {
        return state.creatproject;
    }
};
const mutations = {

    _setouttype(state, outtype) {//选择需要修改的项目
        state.outtype = outtype;
    },

    _setdisplaybool(state, displaybool) {//选择需要修改的项目
        state.displaybool = displaybool;
    },
    //计划员---
    _setplannerchangselect(state, changselect) {//选择需要修改的项目
        state.plannerchangselect = changselect;
    },
    _setplannercanchange(state, plannercanchange) {//计划员获得项目是否可以修改的布尔值

        for (let index = 0; index < plannercanchange.length; index++) {
            if (plannercanchange[index]["tag"] === "设计完成" ||
                plannercanchange[index]["tag"] === "深化完成/设计阶段" ||
                plannercanchange[index]["tag"] === "深化完成") {
                state.plannercanchange[plannercanchange[index]["projectcode"]] = true;//不可以修改
            } else {
                state.plannercanchange[plannercanchange[index]["projectcode"]] = false;//可以修改
            }
        }

    },
    _setcreatcompletelist(state, creatcompletelist) {//计划员获得创建完成的项目信息
        state.creatcompletelist = creatcompletelist
    },
    //--

    //查看的项目信息----------
    _setprojectInfodb(state, infodb) {//根据项目代号获得对应设计详细数据


        state.projectInfodb = state.projectdb.filter(
            data => data["projectcode"] === infodb[0]["projectcode"]
        );

    },

    _setprojectInfo(state, info) {//根据选择的项目查看对应信息
        state.projectInfo = info;
    },

    _setprojectInfodbwrong(state, infodb) {//根据项目代号获得对应设计详细数据

        state.projectInfodbwronglook = state.projectdbwrong.filter(
            data => data["projectcode"] === infodb[0]["projectcode"]
        );

    },
    //----------

    //更新查看的项目信息----------
    _updateprojectInfodb(state, infodb) {//更新根据项目代号获得的对应设计详细数据
        if (sessionStorage.getItem("projectcode") != null) {
            state.projectInfodb = infodb.filter(
                data => data["projectcode"] === sessionStorage.getItem("projectcode")
            );
        }
    },
    _updateprojectInfo(state, info) {//更新根据选择的项目查看对应信息
        if (sessionStorage.getItem("projectcode") != null) {
            state.projectInfo = info.filter(
                data => data["projectcode"] === sessionStorage.getItem("projectcode")
            );
        }
    },
    //----------

    _setprojectdb(state, projectdb) {//登录时获取设计详细数据
        state.projectdb = projectdb;
    },
    _setprojectdbwrong(state, projectdb) {//登录时获取错误数据
        state.projectdbwrong = projectdb;
    },

    //设计师-----------
    _setdesigncomplete(state, designcomplete) {

        state.designcomplete = designcomplete.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "设计师" &&
                data["tag"] === "深化完成/设计完成" &&
                ((data["qiang"] === sessionStorage.getItem("name") && data["qianginput"] === "1") ||
                    (data["liang"] === sessionStorage.getItem("name") && data["lianginput"] === "1") ||
                    (data["louti"] === sessionStorage.getItem("name") && data["loutiinput"] === "1") ||
                    (data["jiedian"] === sessionStorage.getItem("name") && data["jiedianinput"] === "1") ||
                    (data["loumian"] === sessionStorage.getItem("name") && data["loumianinput"] === "1") ||
                    (data["diaomo"] === sessionStorage.getItem("name") && data["diaomoinput"] === "1"))
        );
    },

    _setsyst(state, syst) {
        state.syst = syst;
    },
    _setdesigns(state, designs) {
        state.designs = designs;
    },
    _setdesignsepe(state, designsepe) {//设计师需要填写数据的项目

        state.designsepe = designsepe.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "设计师" &&
                data["tag"] === "深化完成/设计完成" &&
                ((data["qiang"] === sessionStorage.getItem("name") && data["qianginput"] === "0") ||
                    (data["liang"] === sessionStorage.getItem("name") && data["lianginput"] === "0") ||
                    (data["louti"] === sessionStorage.getItem("name") && data["loutiinput"] === "0") ||
                    (data["jiedian"] === sessionStorage.getItem("name") && data["jiedianinput"] === "0") ||
                    (data["loumian"] === sessionStorage.getItem("name") && data["loumianinput"] === "0") ||
                    (data["diaomo"] === sessionStorage.getItem("name") && data["diaomoinput"] === "0"))
        );

        state.designcountsepe = state.designsepe.length;

    },
    _setdesignpersonselect(state, _select) {

        state.designpersonselect = _select;
    },
    //-------------

    //设计负责人
    _setdesign(state, design) {//设计分配数据列表

        state.design = design.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "负责人" &&
                (data["tag"] === "最终深化中" || data["tag"] === "深化完成") &&
                data["designmanager"] === sessionStorage.getItem("name")
        );

        state.designcount = state.design.length;

    },

    _setselectwrong(state, _select) {

        state.selectwrongdb = state.projectdb.filter(
            data => data["projectcode"] === _select[0]["projectcode"]
        );

        state.selectwrong = state.allprojectlist.filter(
            data => data["projectcode"] === _select[0]["projectcode"]
        );

        state.projectInfodbwrong = state.projectdbwrong.filter(
            data => data["projectcode"] === _select[0]["projectcode"]
        );

    },

    _setselectwrongend(state) {//输入错误信息确认后

        if (state.selectwrongdb.length>0) {
            state.projectInfodbwrong = state.projectdbwrong.filter(
                data => data["projectcode"] ===state.selectwrongdb[0]["projectcode"]
            );
        }   

    },
    _setdesignmangerfirstselect(state, _select) {

        state.designmangerfirstselect = _select;
    },
    _setdesignpersonlist(state, designpersonlist) {//设计师列表
        state.designpersonlist = designpersonlist;
    },
    _setdesigntwo(state, designtwo) {

        state.designtwo = designtwo.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "负责人" &&
                data["tag"] === "深化完成/设计阶段" &&
                data["designmanager"] === sessionStorage.getItem("name")
        );

        state.designcountse = state.designtwo.length;
    },
    _setdesignmangerselecttwo(state, _select) {

        state.designmangerselecttwo = _select;
    },
    _setdesignfinal(state, designfinal) {

        state.designfinal = designfinal.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "负责人" &&
                (data["tag"] === "深化完成/设计完成" || data["tag"] === "全部完成") &&
                data["designmanager"] === sessionStorage.getItem("name")
        );
    },
    //

    //深化师--------
    _setdeep(state, deeplist) {

        state.deep = deeplist.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "深化师" &&
                data["tag"] === "初次深化中" &&
                data["deepeningdivision"] === sessionStorage.getItem("name")
        );

        state.deepcount = state.deep.length;

    },
    _setdeepselect(state, _select) {

        state.deepselect = _select;
    },
    _setdeepselectse(state, _select) {

        state.deepselectse = _select;
    },
    _setdeepse(state, deeplistse) {

        state.deepse = deeplistse.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "深化师" &&
                (data["tag"] === "最终深化中" || data["tag"] === "最终深化中/提前介入") &&
                data["deepeningdivision"] === sessionStorage.getItem("name")
        );
        state.deepcountse = state.deepse.length;
    },
    _setrealdeepse(state, realdeeplistse) {

        state.realdeepse = realdeeplistse.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "深化师" &&
                (data["tag"] === "深化完成" || data["tag"] === "深化完成/设计阶段" || data["tag"] === "深化完成/设计完成" ||
                    data["tag"] === "全部完成") &&
                data["deepeningdivision"] === sessionStorage.getItem("name")
        );
        // console.log(state.realdeepse);
    },
    //------


    //深化负责人--
    _setdeepdistrlist(state, deepdistrlist) {//筛选出未分配深化师的项目
        state.deepdistrlist = deepdistrlist.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "深化负责人" &&
                data["tag"] === "深化师未分配"
        );
        state.deepdistr = state.deepdistrlist.length;//未分配深化师的项目数量
    },
    _resetdeepdistrlist(state) {//重置已经分配的深化师
        for (let index = 0; index < state.deepdistrlist.length; index++) {
            state.deepdistrlist[index]["deepeningdivision"] = "";
        }
    },
    _setdeeppersonlist(state, deeppersonlist) {
        state.deeppersonlist = deeppersonlist;//深化师的列表
    },
    _setdeepdistrcomplete(state, deeplist) {

        state.deepdistrcomplete = deeplist.filter(
            data =>
                data["department"] === sessionStorage.getItem("department") &&
                sessionStorage.getItem("mposition") === "深化负责人" &&
                (data["tag"] === "初次深化中" ||
                    data["tag"] === "最终深化中" ||
                    data["tag"] === "最终深化中/提前介入" ||
                    data["tag"] === "深化完成" ||
                    data["tag"] === "深化完成/设计阶段" ||
                    data["tag"] === "深化完成/设计完成" ||
                    data["tag"] === "全部完成"
                )
        );
        console.log(state.deepdistrcomplete);

    },
    //---

    _setNewprojectlist(state, _newprojectlist) {
        state.newprojectlist = _newprojectlist;
    },


    test(state, creatDa) { //同上，这里面的参数除了state之外还传了需要增加的值sum
        state.tableData[0].projectname = creatDa;
    },

    show(state) {   //自定义改变state初始值的方法，这里面的参数除了state之外还可以再传额外的参数(变量或对象);
        state.showFooter = true;
    },
    hide(state) {  //同上
        state.showFooter = false;
    },
    addtableData(state, creatDa) { //同上，这里面的参数除了state之外还传了需要增加的值sum
        state.tableData.push(creatDa);
    },
    _setallprojectlist(state, responsedata) {

        state.allprojectlist = responsedata;

    },
    _settag(state, responsedata) {

        state.tag = responsedata;

    },

    _setdepartment(state, responsedata) {

        state.department = responsedata;

    },
    setS(state, pr) {
        state.showup = pr;
    },
    seCount(state, co) {
        state.count = state.count + co;
    },
    setBreadcrumbDataA(state, BreadcrumbData) {
        state.BreadcrumbData = BreadcrumbData;
    },
    setCreatProjectA(state, creatproject) {

        state.creatproject = creatproject;

        for (let index = 0; index < creatproject.length; index++) {
            state.allprojectlist.push(creatproject[index]);
        }

    }

};
const actions = {
    setouttype(context, outtype) {//选择需要修改的项目
        context.commit('_setouttype', outtype);
    },
    setdisplaybool(context) {//权限设置

        var displaypush = {};
        for (const key in sessionStorage) {
            //this.disPlay.set(key, sessionStorage.getItem(key));
            displaypush[key] = sessionStorage.getItem(key)
        }

        // console.log(displaypush);

        context.commit('_setdisplaybool', displaypush);
    },

    //计划员--
    setplannerchangselect(context, changselect) {//计划员选择需要修改数据
        context.commit('_setplannerchangselect', changselect);
    },
    updateCreatProject(context, updatedb) {
        console.log(updatedb);

        axios({
            method: "post",
            url: "http://192.168.100.143:8082/changProject",
            data: updatedb,
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {
                console.log(response);

                if (response.data === "success") {
                    Message({
                        message: "修改成功！",
                        type: "success"
                    });
                }
            })
            .catch(e => {
                console.log(e);
            });
    },
    //--

    setprojectInfo(context, Info) {//查看工程信息时，将对应工程的信息和设计详细数据分别放入两个位置
        context.commit('_setprojectInfodb', Info);//设计详细数据
        context.commit('_setprojectInfo', Info);//项目信息 
        context.commit('_setprojectInfodbwrong', Info);//错误项目信息 
    },


    setdeep(context, deeplist) {
        context.commit('_setdeep', deeplist);
    },

    //深化负责人---
    resetdeepdistrlist(context) {//重置分配的深化师
        context.commit('_resetdeepdistrlist');
    },
    setdeeppersonlist(context) {
        axios({
            method: "get",
            url:
                "http://192.168.100.143:8082/DeepPerson/" +
                sessionStorage.getItem("department")
        })
            .then(function (response) {
                var options = [];
                for (let index = 0; index < response.data.length; index++) {
                    options.push({
                        value: response.data[index],
                        label: response.data[index]
                    });
                }
                context.commit('_setdeeppersonlist', options);
            })
            .catch(e => {
                console.log(e);
            });
    },
    distrdeepperson(context, deepdistr) {
        axios({
            method: "post",
            url: "http://192.168.100.143:8082/Deepdistr",
            data: deepdistr,
            // headers:{'content-type':'application/x-www-form-urlencoded'}
            headers: {
                //'content-type': 'application/x-www-form-urlencoded',//'application/json',
                token: sessionStorage.getItem("token") //token换成从缓存获取
            }
        })
            .then(function (response) {
                if (response.data === "success") {
                    Message({
                        message: "分配成功！",
                        type: "success"
                    });
                } else {
                    Message({
                        message: "分配失败",
                        type: "warning"
                    });
                }
            })
            .catch(e => {
                Message({
                    message: "分配失败",
                    type: "warning"
                });
            });
    },
    //---


    creatprojectaxios(context, newProjectData) {//新建项目数据传入后端

        axios({
            method: "post",
            url: "http://192.168.100.143:8082/NewProject",
            data: newProjectData,
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {
                if (response.data === "success") {

                    Message({
                        message: "创建成功！",
                        type: "success"
                    });
                } else {
                    Message({
                        message: "创建失败,项目代号重复！",
                        type: "error"
                    });
                }
            })
            .catch(e => {
                Message({
                    message: "创建失败",
                    type: "error"
                });
            });
    },

    //设计负责人--------------
    setdesignpersonlist(context) {
        axios({
            method: "post",
            url: "http://192.168.100.143:8082/DesignPerson",
            data: {
                department: sessionStorage.getItem("department"),
                mgroup: sessionStorage.getItem("mgroup")
            }
        })
            .then(function (response) {

                var options = [];

                for (let index = 0; index < response.data.length; index++) {
                    //获取设计人员名字列表
                    options.push({
                        value: response.data[index],
                        label: response.data[index]
                    });
                }
                context.commit('_setdesignpersonlist', options);
            })
            .catch(e => {
                console.log(e);
            });
    },
    updatedesigndistr(context, mdata) {//设计负责人分配后更新数据库
        axios({
            method: "post",
            url: "http://192.168.100.143:8082/Updatedesigndistr",
            data: mdata,
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {

                console.log(response);

            })
            .catch(e => {
                console.log(e);
            });
    },
    setdesignmangerfirstselect(context, _select) {

        context.commit('_setdesignmangerfirstselect', _select);
    },
    setdesignmangerselecttwo(context, _select) {
        context.commit('_setdesignmangerselecttwo', _select);
    },
    setselectwrong(context, _select) {
        context.commit('_setselectwrong', _select);
    },

    //----------

    //设计师--------------
    setdesignpersonselect(context, _select) {

        context.commit('_setdesignpersonselect', _select);
    },
    setsyst(context, syst) {
        context.commit('_setsyst', syst);
    },
    setdesigns(context, designs) {
        context.commit('_setdesigns', designs);
    },
    setregiondb(context, regiondb) {
        axios({
            method: "post",
            url: "http://192.168.100.143:8082/updateregiondb/" + regiondb[1],
            data: regiondb[0],
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {

                console.log(response.data);

            })
            .catch(e => {
                console.log(e);
            });
    },
    //----------

    setprojectwrongdb(context, regiondb) {//错误信息传入数据库
        axios({
            method: "post",
            url: "http://192.168.100.143:8082/updateprojectwrong",
            data: regiondb,
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {

                if (response.data === "success") {
                    Message({
                        message: "上传成功！",
                        type: "success"
                    });
                       
                }
            })
            .catch(e => {
                console.log(e);
            });
    },

    setdeepdistr(context, deepdistr) {

        context.commit('_setdeepdistr', deepdistr);

    },

    creatNewProject(context) {

        axios({
            method: "get",
            url: "http://192.168.100.143:8082/list"
        })
            .then(function (response) {

                var creatdata1 = JSON.parse(JSON.stringify(response.data));

                for (let index = 0; index < creatdata1.length; index++) {

                    for (const key in creatdata1[index]) {
                        if (creatdata1[index][key] === null) {
                            creatdata1[index][key] = "";
                        }
                    }

                }

                console.log("更新");

                context.commit('_setallprojectlist', creatdata1);

                if (sessionStorage.getItem("creatprojectlist") === "1") {

                    context.commit('_setcreatcompletelist', creatdata1);
                    context.commit('_setplannercanchange', creatdata1);

                }//更新计划员项目信息；

                if (sessionStorage.getItem("allocationitem") === "1") {
                    context.commit('_setdeepdistrlist', creatdata1);
                    context.commit('_setdeepdistrcomplete', creatdata1);
                }//更新深化负责人项目列表

                if (sessionStorage.getItem("deep") === "1") {
                    context.commit('_setdeep', creatdata1);//更新初次深化列表
                    context.commit('_setdeepse', creatdata1);//更新最后深化列表
                    context.commit('_setrealdeepse', creatdata1);//已经深化列表
                }

                if (sessionStorage.getItem("designmanager") === "1") {
                    context.commit('_setdesign', creatdata1);//分配列表数据
                    context.commit('_setdesigntwo', creatdata1);//分配后列表数据
                    context.commit('_setdesignfinal', creatdata1);//完成项目后列表数据
                }

                if (sessionStorage.getItem("designperson") === "1") {
                    context.commit('_setdesignsepe', creatdata1);
                    context.commit('_setdesigncomplete', creatdata1);
                }

                context.commit('_updateprojectInfo', creatdata1);

            })
            .catch(e => {
                console.log(e);
            });

    },

    setProjectdb(context) {//获取详细数据

        axios({
            method: "get",
            url: "http://192.168.100.143:8082/listdb"
        })
            .then(function (response) {

                var creatdata1 = JSON.parse(JSON.stringify(response.data));

                for (let index = 0; index < creatdata1.length; index++) {

                    for (const key in creatdata1[index]) {
                        if (creatdata1[index][key] === "0" || creatdata1[index][key] === "0.00") {
                            creatdata1[index][key] = "";
                        }
                    }

                    //creatdata.push(response.data[index]);
                }

                context.commit('_setprojectdb', creatdata1);
                context.commit('_updateprojectInfodb', creatdata1);

            })
            .catch(e => {
                console.log(e);
            });

    },
    setProjectdbwrong(context) {//获取详细数据

        axios({
            method: "get",
            url: "http://192.168.100.143:8082/listdbwrong"
        })
            .then(function (response) {

                console.log(response);
                
                var creatdata1 = JSON.parse(JSON.stringify(response.data));

                context.commit('_setprojectdbwrong', creatdata1);
                context.commit('_setselectwrongend');
                // context.commit('_updateprojectInfodbwrong', creatdata1);

            })
            .catch(e => {
                console.log(e);
            });

    },
    outsubmit(context) {

        axios({
            method: "post",
            url: "http://192.168.100.143:8082/Out/" + sessionStorage.getItem("id"),
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(function (response) {

            })
            .catch(e => {
                console.log(e);
            });

    },

    //深化师-------
    setdeepselectse(context, _select) {//最后深化

        context.commit('_setdeepselectse', _select);
    },
    setdeepselect(context, _select) {//初次深化
        context.commit('_setdeepselect', _select);
    },
    updatefirstdeeping(context, tablesr1) {//项目不分东西单元

        axios({
            method: "post",
            url: "http://192.168.100.143:8082/FirstDeepo",
            data: tablesr1,
            // headers:{'content-type':'application/x-www-form-urlencoded'}
            headers: {
                //'content-type': 'application/x-www-form-urlencoded',//'application/json',
                token: sessionStorage.getItem("token") //token换成从缓存获取
            }
        })
            .then(function (response) {

                if (response.data === "success") {
                    Message({
                        message: "确认成功！",
                        type: "success"
                    });
                } else {
                    Message({
                        message: "创建失败！",
                        type: "error"
                    });
                }
            })
            .catch(e => {
                console.log(e);
                Message({
                    message: "创建失败",
                    type: "error"
                });
            });
    },
    updateandinsertfirstdeeping(context, tablesr1) {//项目分东西单元

        axios({
            method: "post",
            url: "http://192.168.100.143:8082/FirstDeepi",
            data: tablesr1,
            // headers:{'content-type':'application/x-www-form-urlencoded'}
            headers: {
                //'content-type': 'application/x-www-form-urlencoded',//'application/json',
                token: sessionStorage.getItem("token") //token换成从缓存获取
            }
        })
            .then(function (response) {

                if (response.data === "success") {
                    Message({
                        message: "确认成功！",
                        type: "success"
                    });
                } else {
                    Message({
                        message: "创建失败！",
                        type: "error"
                    });
                }
            })
            .catch(e => {
                console.log(e);

                Message({
                    message: "创建失败",
                    type: "error"
                });
            });
    },
    //----------

    setNewprojectlist(context, _newprojectlist) {
        context.commit('_setNewprojectlist', _newprojectlist);
    },
    hideFooter(context) {  //自定义触发mutations里函数的方法，context与store 实例具有相同方法和属性
        context.commit('hide');
    },
    showFooter(context) {  //同上注释
        context.commit('show');
    },
    settableData(context, Data) {   //同上注释，num为要变化的形参
        context.commit('addtableData', Data);
    },
    setallprojectlist(context, responsedata) {   //同上注释，num为要变化的形参

        context.commit('_setallprojectlist', responsedata);

    },
    settag(context, responsedata) {   //同上注释，num为要变化的形参

        context.commit('_settag', responsedata);

    },

    setdepartment(context, responsedata) {   //同上注释，num为要变化的形参

        context.commit('_setdepartment', responsedata);

    },

    changetableSqldata(context) {   //同上注释，num为要变化的形参
        context.commit('changeProjectState');
    },
    setProjectDataA(context, pr) {
        context.commit('setProjectData', pr);
    },
    setSA(context, pr) {
        context.commit('setS', pr);
    },
    setCount(context, coun) {
        context.commit('seCount', coun);
    },
    setRoute(context) {
        context.commit('setRouters');
    },
    setBreadcrumbData(context, BreadcrumbData) {
        context.commit('setBreadcrumbDataA', BreadcrumbData);
    },
    setCreatProject(context, Data) {
        context.commit('setCreatProjectA', Data);
    },
    testt(context, Data) {
        context.commit('test', Data);
    },

};
const store = new Vuex.Store({
    state,
    getters,
    mutations,
    actions
});
export default store;