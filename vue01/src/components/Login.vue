<template>
  <div class="login-container">
    <!-- <span class="title"></span> -->
    <el-form
      :model="ruleForm2"
      :rules="rules2"
      status-icon
      ref="ruleForm2"
      label-position="left"
      label-width="0px"
      class="login-page"
    >
      <img style="width: 200px; height: 200px" src="../assets/log-logo.png" fit="fit" class="im" />
      <h3 class="title">长沙分部管理系统</h3>
      <el-form-item prop="username">
        <el-input type="text" v-model="ruleForm2.username" auto-complete="on" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="ruleForm2.password" auto-complete="on" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox v-model="checked" class="rememberme">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      
      logining: false,
      ruleForm2: {
        username: "",
        password: ""
      },
      rules2: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      },
      checked: false
    };
  },
  methods: {
    handleSubmit(event) {
      this.$refs.ruleForm2.validate(valid => {
        if (valid) {
          var thismessage = this.$message;
          var thisrouter = this.$router;
          var thisstore = this.$store;

          this.$axios({
            method: "post",
            url: "http://192.168.100.143:8082/Login",
            data: {
              userId: this.ruleForm2.username,
              passWord: this.ruleForm2.password
            }
          })
            .then(function(response) {
              //console.log(response);
              if (response.data === "") {
                thismessage({
                  message: "输入错误！",
                  type: "warning"
                });
              } else {
                for (const key in response.data) {
                  sessionStorage.setItem(key, response.data[key]);
                }

                thismessage({
                  message: "登录成功！",
                  type: "success"
                });               
                thisrouter.push({ path: "/Manage" });
              }
            })
            .catch(e => {
              thismessage({
                message: "404",
                type: "warning"
              });
              console.log(e);
            });
        } else {
          console.log("error submit!");
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.login-container {
  position: absolute;
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  background-repeat: no-repeat;
  background-image: url("../assets/background.jpg");
  background-size: 100% 100%;
  background-attachment: fixed;
  /* background-position:center; */
}
/* .title{
      width: 100%;
      position: absolute;
      bottom:50%;
      text-align: center;
      padding: 30px;
      font: bold 40px/100% "微软雅黑", "Lucida Grande", "Lucida Sans", Helvetica, Arial, Sans;;
      color: rgb(0, 0, 0);
      text-transform: uppercase;
} */
.title {
  position: relative;
  top: 0px;
  text-align: center;
  padding: 30px;
  font: bold 35px/100% "微软雅黑", "Lucida Grande", "Lucida Sans", Helvetica,
    Arial, Sans;
  color: rgb(255, 254, 254);
  text-transform: uppercase;
}
.login-page {
  position: absolute;
  /* -webkit-border-radius: 5px;
    border-radius: 5px; */
  top: 30%;
  left: 39%;
  width: 350px;
  height: 500px;
  padding: 35px 35px 15px;
  /* background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6; */
}
.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
  color: black;
}
.im {
  position: absolute;
  top: -20%;
  left: 28%;
}
</style>