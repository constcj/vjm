<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdesigntwo"
      @selection-change="handleSelectionChange"
      style="width: 100%; font-size:9px;"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="70" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="200" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="70" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" width="70" align="center"></el-table-column>
      <el-table-column prop="tag" label="状态" width="70" align="center"></el-table-column>
      <el-table-column prop="qiang" label="墙设计" width="70" align="center"></el-table-column>
      <el-table-column prop="loumian" label="楼面设计" width="70" align="center"></el-table-column>
      <el-table-column prop="liang" label="梁设计" width="70" align="center"></el-table-column>
      <el-table-column prop="jiedian" label="节点设计" width="70" align="center"></el-table-column>
      <el-table-column prop="diaomo" label="吊模设计" width="70" align="center"></el-table-column>
      <el-table-column prop="louti" label="楼梯设计" width="70" align="center"></el-table-column>
      <el-table-column label="下载深化资料" align="center">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="dowmDeep(scope.row)">
            下载
            <i class="el-icon-download"></i>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="完成设计" width="100" align="center">
        <template slot-scope="scope">
          <el-button
            type="primary"
            size="mini"
            @click="handleEdit(scope.row)"
            style="font-size:9px;"
          >完成设计</el-button>
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
      if (this.multipleSelection.length === 0) {
        this.$store.dispatch("setdesignmangerselecttwo", [row]);
      } else {
        this.$store.dispatch(
          "setdesignmangerselecttwo",
          this.multipleSelection
        );
      }

      this.$router.push({ path: "/realdesignmanagersese" });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    dowmDeep(row) {
      var urldown = "http://192.168.100.143:8082/download/" + row.projectcode;

      var file = row["deepfile"];
      var fileName = file.substring(file.indexOf("-") + 1);

      console.log(row);

      this.$axios({
        method: "post",
        url: urldown,
        responseType: "blob"
      }).then(function(response) {
        const blob = new Blob([response.data]);
        if ("download" in document.createElement("a")) {
          const link = document.createElement("a");
          link.download = fileName;
          link.style.display = "none";
          link.href = URL.createObjectURL(blob);
          document.body.appendChild(link);
          link.click(); // 执行下载
          URL.revokeObjectURL(link.href); // 释放url
          document.body.removeChild(link); // 释放标签
        } else {
          navigator.msSaveBlob(blob, name);
        }
      });
    }
  }
};
</script>