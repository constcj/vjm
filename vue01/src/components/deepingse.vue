<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getdeepselectse" style="width: 100%">
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>

      <el-table-column prop="templatesystem" label="模板体系" align="center"></el-table-column>
      <el-table-column prop="whetherprefab" label="是否预制件" align="center"></el-table-column>
      <el-table-column prop="layerheigh" label="层高" align="center"></el-table-column>
      <el-table-column prop="designmanager" label="负责人" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
    <div style="margin: 15px 0;"></div>

    <el-form :model="tables[0]" :rules="rules" ref="tables[0]">
      <el-table :data="tables" ref="multipleTable" border>
        <el-table-column prop="projectdifficulty" label="难度系数" width="300px" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectdifficulty">
              <el-input v-model="scope.row.projectdifficulty"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="signaturetime" label="底图签字时间" width="250px" align="center">
          <template slot-scope="scope">
            <el-col>
              <el-form-item prop="signaturetime">
                <el-date-picker type="date" placeholder="选择日期" v-model="scope.row.signaturetime"></el-date-picker>
              </el-form-item>
            </el-col>
          </template>
        </el-table-column>

        <el-table-column label="上传签字文件" align="center">
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
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" @click="submit" style="margin-left: 45%;">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dataList: [],
      tables: [
        {
          projectdifficulty: "",
          signaturetime: ""
        }
      ],
      tablesr1: [],
      rules: {
        projectdifficulty: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        signaturetime: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      }
    };
  },
  computed: {
    codes() {
      var code = "";

      for (
        let index = 0;
        index < this.$store.getters.getdeepselectse.length;
        index++
      ) {
        const element = this.$store.getters.getdeepselectse[index];
        code += element["projectcode"];
        if (index < this.$store.getters.getdeepselectse.length - 1) {
          code += "-";
        }
      }

      return code;
    },
    deleteurl() {
      var code = "";
      for (
        let index = 0;
        index < this.$store.getters.getdeepselectse.length;
        index++
      ) {
        const element = this.$store.getters.getdeepselectse[index];
        code += element["projectcode"];
        if (index < this.$store.getters.getdeepselectse.length - 1) {
          code += "-";
        }
      }

      return "http://192.168.100.143:8082/deepdelete/" + code;
    }
  },
  mounted: {},
  methods: {
    submit() {
      this.tablesr1 = [];

      this.$refs["tables[0]"].validate(valid => {
        if (valid) {
          if (this.dataList.length > 0) {
            if (this.$store.getters.getdeepselectse.length > 0) {
              for (
                let index = 0;
                index < this.$store.getters.getdeepselectse.length;
                index++
              ) {
                var dem = JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselectse[index])
                );

                if (dem["tag"] === "最终深化中") {
                  dem["tag"] = "深化完成";
                } else if (dem["tag"] === "最终深化中/提前介入") {
                  dem["tag"] = "深化完成/设计阶段";
                }

                for (const key in this.tables[0]) {
                  if (key !== "isupload") dem[key] = this.tables[0][key];
                }

                var et = new Date(dem["signaturetime"].toString());
                var ett =
                  et.getFullYear() +
                  "." +
                  (et.getMonth() + 1).toString().padStart(2, "0") +
                  "." +
                  et
                    .getDate()
                    .toString()
                    .padStart(2, "0");

                dem["signaturetime"] = ett;

                this.tablesr1.push(dem);
              }
              var thismessage = this.$message;
              var se = this.$store;
              var uploademethod = this.$refs.upload;

              this.$axios({
                method: "post",
                url: "http://192.168.100.143:8082/LastDeep",
                data: this.tablesr1,
                // headers:{'content-type':'application/x-www-form-urlencoded'}
                headers: {
                  //'content-type': 'application/x-www-form-urlencoded',//'application/json',
                  token: sessionStorage.getItem("token") //token换成从缓存获取
                }
              })
                .then(function(response) {
                  if (response.data === "success") {
                    thismessage({
                      message: "确认成功！",
                      type: "success"
                    });

                    uploademethod.submit();
                    se.dispatch("setdeepselectse", []);
                    uploademethod.clearFiles();
                  } else {
                    thismessage({
                      message: "创建失败！",
                      type: "warning"
                    });
                  }
                })
                .catch(e => {
                  console.log(e);

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
              message: "上传深化资料",
              type: "warning"
            });
          }
        }
      });
    },

    httpRequest(param) {
      let fileObj = param.file; // 相当于input里取得的files
      let fd = new FormData(); // FormData 对象
      fd.append("file", fileObj); // 文件对象
      //fd.append("platNum", this.importList.platNum);
      //fd.append("taskName", this.importList.taskName);
      //  let url = "http://192.168.100.143:8082/deepupload";

      this.$axios({
        method: "post",
        url: "http://192.168.100.143:8082/deepupload/" + this.codes,
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
    }
  }
};
</script>