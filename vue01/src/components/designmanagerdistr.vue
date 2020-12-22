<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getdesignmangerfirstselect">
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="400" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="150" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" width="200" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>

    <el-form :model="tables[0]" :rules="rules" ref="tables[0]">
      <el-table ref="multipleTable" :data="tables">
        <el-table-column prop="qiang" label="墙" align="center">
          <template slot-scope="scope">
            <el-form-item prop="qiang">
              <el-select v-model="scope.row.qiang" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="loumian" label="楼面" align="center">
          <template slot-scope="scope">
            <el-form-item prop="loumian">
              <el-select v-model="scope.row.loumian" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="liang" label="梁" align="center">
          <template slot-scope="scope">
            <el-form-item prop="liang">
              <el-select v-model="scope.row.liang" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="jiedian" label="节点" align="center">
          <template slot-scope="scope">
            <el-form-item prop="jiedian">
              <el-select v-model="scope.row.jiedian" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="diaomo" label="吊模" align="center">
          <template slot-scope="scope">
            <el-form-item prop="diaomo">
              <el-select v-model="scope.row.diaomo" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="louti" label="楼梯" align="center">
          <template slot-scope="scope">
            <el-form-item prop="louti">
              <el-select v-model="scope.row.louti" placeholder="请选择">
                <el-option
                  v-for="item in designpersonlist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="确认" align="center">
          <template slot-scope="scope">
            <el-button type="primary" @click="handleEdit(scope.row)">确定</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tables: [
        {
          qiang: "",
          loumian: "",
          liang: "",
          jiedian: "",
          diaomo: "",
          louti: ""
        }
      ],

      rules: {
        qiang: [{ required: true, message: "输入数据", trigger: "blur" }],
        loumian: [{ required: true, message: "输入数据", trigger: "blur" }],
        liang: [{ required: true, message: "输入数据", trigger: "blur" }],
        jiedian: [{ required: true, message: "输入数据", trigger: "blur" }],
        diaomo: [{ required: true, message: "输入数据", trigger: "blur" }],
        louti: [{ required: true, message: "输入数据", trigger: "blur" }]
      },

      tablesr1: [],

      multipleSelection: []
    };
  },

  mounted() {
    this.$store.dispatch("setdesignpersonlist");
  },

  computed: {
    designpersonlist() {
      return this.$store.getters.getdesignpersonlist;
    }
  },

  methods: {
    handleEdit(row) {
      this.$refs["tables[0]"].validate(valid => {
        if (valid) {
          if (this.$store.getters.getdesignmangerfirstselect.length > 0) {
            for (
              let index = 0;
              index < this.$store.getters.getdesignmangerfirstselect.length;
              index++
            ) {
              var dem = JSON.parse(
                JSON.stringify(this.$store.getters.getdesignmangerfirstselect[index])
              );

              if (dem["tag"] === "最终深化中") {
                dem["tag"] = "最终深化中/提前介入";
              } else if (dem["tag"] === "深化完成") {
                dem["tag"] = "深化完成/设计阶段";
              }

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

              dem["startime"] = ett;

              for (const key in row) {
                dem[key] = row[key];
              }

              this.tablesr1.push(dem);
            }

            this.$store.dispatch("setdesignmangerfirstselect", []);
            this.$store.dispatch("updatedesigndistr", this.tablesr1);
          } else {
            this.$message({
              message: "重新选择项目",
              type: "warning"
            });
          }
        }
      });
    }
  }
};
</script>