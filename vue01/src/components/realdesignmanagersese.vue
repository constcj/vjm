<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getdesignmangerselecttwo">
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="250" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
      <el-table-column prop="tag" label="状态" align="center"></el-table-column>
      <el-table-column prop="qiang" label="墙设计" align="center"></el-table-column>
      <el-table-column prop="loumian" label="楼面设计" align="center"></el-table-column>
      <el-table-column prop="liang" label="梁设计" align="center"></el-table-column>
      <el-table-column prop="jiedian" label="节点设计" align="center"></el-table-column>
      <el-table-column prop="diaomo" label="吊模设计" align="center"></el-table-column>
      <el-table-column prop="louti" label="楼梯设计" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>

    <el-table :data="tables" ref="multipleTable">
      <el-table-column label="上传下发文件" align="center">
        <template>
          <el-upload
            class="upload-demo"
            ref="upload"
            action="xx"
            drag
            multiple
            :limit="1"
            :http-request="httpRequest"
            :auto-upload="false"
            :on-change="fileChange"
            :file-list="dataList"
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或
              <em>点击上传</em>
            </div>
          </el-upload>
        </template>
      </el-table-column>

      <el-table-column label="确定" align="center">
        <template>
          <el-button size="mini" @click="submit">确定</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tables: [{}],
      tablesr1: [],
      dataList: []
    };
  },
  computed: {
    codes() {
      var code = "";
      for (
        let index = 0;
        index < this.$store.getters.getdesignmangerselecttwo.length;
        index++
      ) {
        const element = this.$store.getters.getdesignmangerselecttwo[index];
        code += element["projectcode"];
        if (index < this.$store.getters.getdesignmangerselecttwo.length - 1) {
          code += "-";
        }
      }

      return code;
    },
    deleteurl() {
      var code = "";
      for (
        let index = 0;
        index < this.$store.getters.getdesignmangerselecttwo.length;
        index++
      ) {
        const element = this.$store.getters.getdesignmangerselecttwo[index];
        code += element["projectcode"];
        if (index < this.$store.getters.getdesignmangerselecttwo.length - 1) {
          code += "-";
        }
      }

      return code;
    }
  },
  methods: {
    submit() {
      this.tablesr1 = [];
      if (this.dataList.length > 0) {
        if (this.$store.getters.getdesignmangerselecttwo.length > 0) {
          for (
            let index = 0;
            index < this.$store.getters.getdesignmangerselecttwo.length;
            index++
          ) {
            var dem = JSON.parse(
              JSON.stringify(
                this.$store.getters.getdesignmangerselecttwo[index]
              )
            );

            dem["tag"] = "深化完成/设计完成";

            var et = new Date();

            var ett =
              et.getFullYear() +
              "." +
              (et.getMonth() + 1).toString().padStart(2, "0") +
              "." +
              et
                .getDate()
                .toString()
                .padStart(2, "0");

            dem["realtime"] = ett;

            this.tablesr1.push(dem);
          }

          var thismessage = this.$message;
          var se = this.$store;
          var uploademethod = this.$refs.upload;

          this.$axios({
            method: "post",
            url: "http://192.168.100.143:8082/LastDesign",
            data: this.tablesr1,
            headers: {
              token: sessionStorage.getItem("token")
            }
          })
            .then(function(response) {
              if (response.data === "success") {
                thismessage({
                  message: "确认成功！",
                  type: "success"
                });
                uploademethod.submit();
                se.dispatch("setdesignmangerselecttwo", []);
                uploademethod.clearFiles();
              } else {
                thismessage({
                  message: "创建失败！",
                  type: "error"
                });
              }
            })
            .catch(e => {
              thismessage({
                message: "创建失败",
                type: "error"
              });
            });
        } else {
          this.$message({
            message: "选择项目",
            type: "warning"
          });
        }
      } else {
        this.$message({
          message: "上传下发文件",
          type: "warning"
        });
      }
    },

    httpRequest(param) {
      let fileObj = param.file; // 相当于input里取得的files
      let fd = new FormData(); // FormData 对象
      fd.append("file", fileObj); // 文件对象
      //fd.append("platNum", this.importList.platNum);
      //fd.append("taskName", this.importList.taskName);
      //  let url = "http://192.168.100.143:8082/deepupload";

      console.log(this.codes);

      this.$axios({
        method: "post",
        url: "http://192.168.100.143:8082/designupload/" + this.codes,
        data: fd,
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(res => {
        console.log(res);
      });
    },
    fileChange(file, fileList) {
      this.dataList = fileList;
    },

    removeUpload(file, fileList) {
      this.$axios({
        method: "post",
        url: this.deleteurl
      }).then(function(response) {
        console.log(response);
      });
    },

    GetNumberOfDays(date1) {
      //获得天数
      //date1：开始日期，以当前为节点做为结束日期
      var a1 = Date.parse(new Date(date1));
      var a2 = Date.parse(new Date());
      var day = parseInt((a2 - a1) / (1000 * 60 * 60 * 24)); //核心：时间戳相减，然后除以天数
      return day;
    }
  }
};
</script>