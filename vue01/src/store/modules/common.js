const state = {   //要设置的全局访问的state对象
    allprojectlist: [],//所有项目信息
    projectdb: [],//项目数据信息 
    projectdbwrong: []//项目错误数据
};
const getters = {   //实时监听state值的变化(最新状态)
    getallprojectlist(state) {//allprojectlist对象
        return state.allprojectlist;
    },
    getprojectdb(state) {//projectdb对象
        return state.projectdb;
    },
    getprojectdbwrong(state) {//projectdb对象
        return state.projectdbwrong;
    }
};
const mutations = {
    _setallprojectlist(state, allprojectlist) {//allprojectlist对象
        state.allprojectlist =allprojectlist;
    },
    _setprojectdb(state, projectdb) {//projectdb对象
        state.projectdb =projectdb;
    },
    _setprojectdbwrong(state, projectdbwrong) {//projectdbwrong对象
        state.projectdbwrong =projectdbwrong;
    }
};
const actions = {
    setallprojectlist(context, allprojectlist) {//allprojectlist对象
        context.commit('_setallprojectlist',allprojectlist);
    },
    setprojectdb(context, projectdb) {//projectdb对象
        context.commit('_setprojectdb', projectdb);
    },
    setprojectdbwrong(context, projectdbwrong) {//projectdbwrong对象
        context.commit('_setprojectdbwrong', projectdbwrong);
    }
}