import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Manage from '@/components/Manage';
import projectInformation from '@/components/projectInformation';
import ProjectList from '@/components/ProjectList';
import creatproject from '@/components/creatproject';
import allocationitem from '@/components/allocationitem';
import receiveconfirmation from '@/components/receiveconfirmation';
import deep from '@/components/deep';
import deeping from '@/components/deeping';
import deepse from '@/components/deepse';
import deepingse from '@/components/deepingse';
import realdeep from '@/components/realdeep';
import designmanager from '@/components/designmanager';
import designmanagerdistr from '@/components/designmanagerdistr';

import realdesignmanager from '@/components/realdesignmanager';
import wrongfill from '@/components/wrongfill';

import realdesignmanagerse from '@/components/realdesignmanagerse';
import realdesignmanagersese from '@/components/realdesignmanagersese';
import creatprojectlist from '@/components/creatprojectlist';
import creatprojectchange from '@/components/creatprojectchange';
import designperson from '@/components/designperson';
import designpersonse from '@/components/designpersonse';
import realdesignperson from '@/components/realdesignperson';
import bbs from '@/components/bbs';

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',//登录
      name: 'Login',
      component: Login,
      meta: {
        root: "Login"
      }
    },
    {
      path: '/Manage',//管理主页面
      name: 'Manage',
      component: Manage,
      meta: {
        position: [{ path: '/Manage', name: '项目列表' }]
      },
      children: [
        {
          path: '/bbs',
          name: 'bbs',//论坛中心
          component: bbs,
          meta: {
            position: [{ path: '/bbs', name: '论坛中心' }]
          }
        },
        {
          path: '',
          name: 'ProjectList',//项目列表
          component: ProjectList,
          meta: {
            position: [{ path: '/Manage', name: '项目列表' }]
          }
        },
        {
          path: '/projectInformation',//项目信息
          name: 'projectInformation',
          component: projectInformation,
          meta: {
            position: [{ path: '/Manage', name: '项目列表' }, { path: '/projectInformation', name: '项目信息' }]
          }
        },
        {
          path: '/creatproject',//新建项目
          name: 'creatproject',
          component: creatproject,
          meta: {
            position: [{ path: '/creatproject', name: '新建项目' }]
          }
        },
        {
          path: '/creatprojectlist',//新建项目列表
          name: 'creatprojectlist',
          component: creatprojectlist,
          meta: {
            position: [{ path: '/creatprojectlist', name: '新建项目列表' }]
          }
        },
        {
          path: '/creatprojectchange',//新建项目数据修改
          name: 'creatprojectchange',
          component: creatprojectchange,
          meta: {
            position: [{ path: '/creatprojectlist', name: '新建项目列表' }, { path: '/creatprojectchange', name: '数据修改' }]
          }
        },

        {
          path: '/receiveconfirmation',//接收确认
          name: 'receiveconfirmation',
          component: receiveconfirmation,
          meta: {
            position: [{ path: '/receiveconfirmation', name: '已分配项目列表' }]
          }
        },
        {
          path: '/allocationitem',//未分配项目
          name: 'allocationitem',
          component: allocationitem,
          meta: {
            position: [{ path: '/allocationitem', name: '未分配项目' }]
          }
        },
        {
          path: '/deep',//首次深化项目列表
          name: 'deep',
          component: deep,
          meta: {
            position: [{ path: '/deep', name: '首次深化项目列表' }]
          }
        },
        {
          path: '/deeping',//深化
          name: 'deeping',
          component: deeping,
          meta: {
            position: [{ path: '/deep', name: '首次深化项目列表' }, { path: '/deeping', name: '深化' }]
          }
        },

        {
          path: '/deepse',//最终深化项目列表
          name: 'deepse',
          component: deepse,
          meta: {
            position: [{ path: '/deepse', name: '最终深化项目列表' }]
          }
        },
        {
          path: '/deepingse',//深化
          name: 'deepingse',
          component: deepingse,
          meta: {
            position: [{ path: '/deepse', name: '最终深化项目列表' }, { path: '/deeping', name: '深化' }]
          }
        },
        {
          path: '/realdeep',//已深化项目
          name: 'realdeep',
          component: realdeep,
          meta: {
            position: [{ path: '/realdeep', name: '已深化项目' }]
          }
        },
        {
          path: '/designmanager',//未分配项目
          name: 'designmanager',
          component: designmanager,
          meta: {
            position: [{ path: '/designmanager', name: '设计分配' }]
          }
        },
        {
          path: '/designmanagerdistr',//未分配项目
          name: 'designmanagerdistr',
          component: designmanagerdistr,
          meta: {
            position: [{ path: '/designmanager', name: '设计分配' }, { path: '/designmanagerdistr', name: '分配' }]
          }
        },
        {
          path: '/realdesignmanager',//已分配项目
          name: 'realdesignmanager',
          component: realdesignmanager,
          meta: {
            position: [{ path: '/realdesignmanager', name: '已分配项目' }]
          }
        },
        {
          path: '/wrongfill',//已分配项目
          name: 'wrongfill',
          component: wrongfill,
          meta: {
            position: [{ path: '/realdesignmanager', name: '已分配项目' }, { path: '/wrongfill', name: '工艺/错误填写' }]
          }
        },
        {
          path: '/realdesignmanagerse',//设计完成
          name: 'realdesignmanagerse',
          component: realdesignmanagerse,
          meta: {
            position: [{ path: '/realdesignmanagerse', name: '设计完成' }]
          }
        },
        {
          path: '/realdesignmanagersese',//上传下发资料
          name: 'realdesignmanagersese',
          component: realdesignmanagersese,
          meta: {
            position: [{ path: '/realdesignmanagerse', name: '设计完成' }, { path: '/realdesignmanagersese', name: '上传下发资料' }]
          }
        },
        {
          path: '/designperson',//未分配项目
          name: 'designperson',
          component: designperson,
          meta: {
            position: [{ path: '/designperson', name: '数据填写' }]
          }
        },
        {
          path: '/realdesignperson',//未分配项目
          name: 'realdesignperson',
          component: realdesignperson,
          meta: {
            position: [{ path: '/realdesignperson', name: '数据填写' }]
          }
        },
        {
          path: '/designpersonse',//未分配项目
          name: 'designpersonse',
          component: designpersonse,
          meta: {
            position: [{ path: '/designperson', name: '项目列表' }, { path: '/designpersonse', name: '数据填写' }]
          }
        }
      ]
    }
  ]
})


