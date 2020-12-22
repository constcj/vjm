// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios'
import qs from 'qs'

import {post,get,Login} from './httpapi/http'

import store from './store'//引入store

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import wsConnection from './wsConnection'

Vue.use(ElementUI)
Vue.config.productionTip = false

Vue.prototype.$setWs = wsConnection;
Vue.prototype.$axios = axios    //全局注册，使用方法为:this.$axios
Vue.prototype.post = post           
Vue.prototype.get = get
Vue.prototype.Login = Login

router.beforeEach((to, from, next) => {

  if (to.meta.root === "Login") {
    sessionStorage.clear();
    next();
  } else if (sessionStorage.getItem("token") !== null) {
    next();
    if (to.path === "/Manage") {
      next();
    } else if (sessionStorage.getItem(to.name) === "1") {
      next();
    } else {
      next({ path: from.path })
    }
  }
  else {

    next({ path: from.path })

  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})



