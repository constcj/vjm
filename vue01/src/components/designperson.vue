<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdesignsepe"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="400" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
      <el-table-column prop="tag" label="状态" align="center"></el-table-column>
      <el-table-column label="确认" width="120" align="center">
        <template slot-scope="scope">
          <el-button type="primary" @click="handleEdit(scope.row)">数据填写</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      multipleSelection: []
    };
  },

  methods: {
    handleEdit(row) {
      var str = [];
      var strm = [];

      if (this.multipleSelection.length === 0) {
        if (row["qiang"] === sessionStorage.getItem("name")) {
          str.push("qiang");
        }
        if (row["liang"] === sessionStorage.getItem("name")) {
          str.push("liang");
        }

        if (row["louti"] === sessionStorage.getItem("name")) {
          str.push("louti");
        }

        if (row["jiedian"] === sessionStorage.getItem("name")) {
          str.push("jiedian");
        }

        if (row["diaomo"] === sessionStorage.getItem("name")) {
          str.push("diaomo");
        }

        if (row["loumian"] === sessionStorage.getItem("name")) {
          str.push("loumian");
        }

        var syst = row["templatesystem"];

        this.$store.dispatch("setsyst", syst); //填写数据是显示类型
        this.$store.dispatch("setdesigns", str); //不同部位显示不同填写栏
        this.$store.dispatch("setdesignpersonselect", [row]); //选择的数据项
      } else {
        if (
          this.multipleSelection[0]["qiang"] === sessionStorage.getItem("name")
        ) {
          str.push("qiang");
        } else {
          strm.push("qiang");
        }
        if (
          this.multipleSelection[0]["liang"] === sessionStorage.getItem("name")
        ) {
          str.push("liang");
        } else {
          strm.push("liang");
        }

        if (
          this.multipleSelection[0]["louti"] === sessionStorage.getItem("name")
        ) {
          str.push("louti");
        } else {
          strm.push("louti");
        }

        if (
          this.multipleSelection[0]["jiedian"] ===
          sessionStorage.getItem("name")
        ) {
          str.push("jiedian");
        } else {
          strm.push("jiedian");
        }

        if (
          this.multipleSelection[0]["diaomo"] === sessionStorage.getItem("name")
        ) {
          str.push("diaomo");
        } else {
          strm.push("diaomo");
        }

        if (
          this.multipleSelection[0]["loumian"] ===
          sessionStorage.getItem("name")
        ) {
          str.push("loumian");
        } else {
          strm.push("loumian");
        }

        var syst = this.multipleSelection[0]["templatesystem"];

        for (let index = 1; index < this.multipleSelection.length; index++) {
          if (syst !== this.multipleSelection[index]["templatesystem"]) {
            this.$message({
              message: "请选择相同体系工程",
              type: "warning"
            });
            return;
          }

          for (let i = 0; i < str.length; i++) {
            if (
              this.multipleSelection[index][str[i]] !==
              sessionStorage.getItem("name")
            ) {
              this.$message({
                message: "请选择设计部位相同的工程",
                type: "warning"
              });
              return;
            }
          }

          for (let i = 0; i < strm.length; i++) {
            if (
              this.multipleSelection[index][strm[i]] ===
              sessionStorage.getItem("name")
            ) {
              this.$message({
                message: "请选择设计部位相同的工程",
                type: "warning"
              });
              return;
            }
          }
        }

        this.$store.dispatch("setdesigns", str);
        this.$store.dispatch("setdesignpersonselect", this.multipleSelection);
        this.$store.dispatch("setsyst", syst);
      }

      this.$router.push({ path: "/designpersonse" });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
  }
};
</script>