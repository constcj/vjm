<template>
  <div>
    <el-upload
      class="upload-demo"
      action="http://192.168.100.143:8082/Ex"
      accept=".xls, .xlsx"
      :before-upload="uploadsuccess"
      :on-remove="Remove"
      :limit="1"
    >
      <el-button size="small" type="primary">选择创建项目Excel文件</el-button>
    </el-upload>

    <div style="margin: 15px 0;"></div>

    <el-table
      ref="multipleTable"
      :data="newProjectData"
      @selection-change="handleSelectionChange"
      style="width: 100%;"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="department" label="分配科室" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
    <div>
      <!-- <el-checkbox v-model="checked" @change="handleCheckAllChange">项目自动分配</el-checkbox> -->
      <el-select v-model="value" placeholder="请选择" :disabled="disabled" style="position:relative;">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
      <el-button type="primary" @click="distribution">分配科室</el-button>
      <el-button type="primary" @click="reset">重置</el-button>
    </div>
    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" style="margin-left:47%" @click="CreateProject">创建项目</el-button>
    </div>
  </div>
</template>

<script>
import XLSX from "xlsx";
var that = this;
export default {
  data() {
    return {
      newProjectData: [],
      checked: false,
      disabled: false,

      options: [
        {
          value: "1科",
          label: "1科"
        },
        {
          value: "2科",
          label: "2科"
        },
        {
          value: "3科",
          label: "3科"
        },
        {
          value: "4科",
          label: "4科"
        },
        {
          value: "5科",
          label: "5科"
        },
        {
          value: "6科",
          label: "6科"
        }
      ],
      value: "",

      multipleSelection: []
    };
  },
  methods: {
    uploadsuccess(file) {
      var that = this;
      var wss = [];
      const fileReader = new FileReader();
      fileReader.readAsBinaryString(file); //读取Excel文件流
      fileReader.onload = function(ev) {
        try {
          const data = ev.target.result;
          const workbook = XLSX.read(data, {
            type: "binary"
          });
          const wsname = workbook.SheetNames[0]; //第一个工作表名称
          wss = XLSX.utils.sheet_to_json(workbook.Sheets[wsname]);

          wss.map((value, index, array) => {
            var reg = new RegExp("[.-/]");
            var rtt = "";
            var ett = "";

            if (
              !reg.test(value["图纸接收时间"]) &&
              !reg.test(value["预计进场时间"])
            ) {
              var rt = new Date((value["图纸接收时间"] - 25569) * 24 * 3600000); //Excel是从1900.1.1开始，Date是从1970.1.1开始，这之间天数25569
              rtt =
                rt.getFullYear() +
                "." +
                (rt.getMonth() + 1).toString().padStart(2, "0") +
                "." +
                rt
                  .getDate()
                  .toString()
                  .padStart(2, "0");

              var et = new Date((value["预计进场时间"] - 25569) * 24 * 3600000);
              ett =
                et.getFullYear() +
                "." +
                (et.getMonth() + 1).toString().padStart(2, "0") +
                "." +
                et
                  .getDate()
                  .toString()
                  .padStart(2, "0");
            } else if (
              !reg.test(value["图纸接收时间"]) &&
              reg.test(value["预计进场时间"])
            ) {
              var rt = new Date((value["图纸接收时间"] - 25569) * 24 * 3600000); //Excel是从1900.1.1开始，Date是从1970.1.1开始，这之间天数25569
              rtt =
                rt.getFullYear() +
                "." +
                (rt.getMonth() + 1).toString().padStart(2, "0") +
                "." +
                rt
                  .getDate()
                  .toString()
                  .padStart(2, "0");

              ett = value["预计进场时间"];
            } else if (
              reg.test(value["图纸接收时间"]) &&
              !reg.test(value["预计进场时间"])
            ) {
              rtt = value["图纸接收时间"];
              var et = new Date((value["预计进场时间"] - 25569) * 24 * 3600000);
              ett =
                et.getFullYear() +
                "." +
                (et.getMonth() + 1).toString().padStart(2, "0") +
                "." +
                et
                  .getDate()
                  .toString()
                  .padStart(2, "0");
            } else {
              rtt = value["图纸接收时间"];
              ett = value["预计进场时间"];
            }
            that.newProjectData.push({
              projectsource: value["订单来源"],
              projectname: value["项目名称"],
              projectnumber: value["栋号"],
              projectcode: value["项目代号"],
              receivetime: rtt,
              estimatetime: ett,
              department: null,
              deepeningdivision: null,
              tag: "深化师未分配",
              clientname: null,
              marketstaffwithcall: null,
              templatesystem: null,
              whetherprefab: null,
              layerheigh: null,
              projectdifficulty: null,
              signaturetime: null,
              designmanager: null,
              qiang: null,
              liang: null,
              louti: null,
              jiedian: null,
              loumian: null,
              diaomo: null,
              startime: null,
              realtime: null
            });
          });
        } catch (e) {
          console.log(e);
          return;
        }
      };
    },
    Remove() {
      this.newProjectData = [];
    },
    handleCheckAllChange(val) {
      if (val) {
        this.disabled = true;
        if (this.newProjectData !== []) {
          this.newProjectData.forEach(element => {
            element["department"] = "1科";
          });
        }
      } else {
        this.disabled = false;
        if (this.newProjectData !== []) {
          this.newProjectData.forEach(element => {
            element["department"] = "";
          });
        }
      }
    },
    distribution() {
      if (this.multipleSelection !== []) {
        this.multipleSelection.forEach(element => {
          var index = this.newProjectData.indexOf(element);
          if (index > -1) {
            this.newProjectData[index]["department"] = this.value;
          }
        });
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    reset() {
      for (let index = 0; index < this.newProjectData.length; index++) {
        this.newProjectData[index]["department"] = "";
      }
    },
    CreateProject() {
      if (this.newProjectData.length > 0) {
        //判断是否上传
        var isnull = false;
        for (let index = 0; index < this.newProjectData.length; index++) {
          if (
            this.newProjectData[index]["department"] === null ||
            this.newProjectData[index]["department"] === ""
          ) {
            isnull = true; //上传的数据是否存在未分配
          }
        }
        if (!isnull) {
          this.$store.dispatch("creatprojectaxios", this.newProjectData);
        } else {
          this.$message({
            message: "存在未分配项目！",
            type: "warning"
          });
        }
      } else {
        this.$message({
          message: "列表为空！",
          type: "warning"
        });
      }
    }
  }
};
</script>