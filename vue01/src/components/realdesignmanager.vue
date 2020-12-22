<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdesignfinal"
      style="width: 100%;font-size: 13px;"
    >
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

      <el-table-column label="下载上传资料" width="110" align="center">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">
            下载
            <i class="el-icon-download"></i>
          </el-button>
        </template>
      </el-table-column>

      <el-table-column label="工艺问题/错误填写" align="center">
        <template slot-scope="scope">
          <el-button size="mini" @click="Fillwrong(scope.row)">确定</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
    };
  },
  methods: {
    Fillwrong(row) {
      this.$store.dispatch("setselectwrong", [row]);
      this.$router.push({ path: "/wrongfill" });
    },
    handleEdit(row) {
      var urldown = "http://192.168.100.143:8082/downloads/" + row.projectcode;

      var file = row["designfile"];
      var fileName = file.substring(file.indexOf("-") + 1);

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