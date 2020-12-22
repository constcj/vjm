<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getrealdeepse" style="width: 100%">
      <el-table-column prop="projectsource" label="订单来源" width="100" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>

      <el-table-column prop="templatesystem" label="模板体系" align="center"></el-table-column>
      <el-table-column prop="whetherprefab" label="是否预制件" align="center"></el-table-column>
      <el-table-column prop="layerheigh" label="层高" align="center"></el-table-column>
      <el-table-column prop="designmanager" label="负责人" align="center"></el-table-column>

      <el-table-column prop="projectdifficulty" label="难度系数" align="center"></el-table-column>
      <el-table-column prop="signaturetime" label="底图签字时间" align="center"></el-table-column>

      <el-table-column label="下载深化资料" align="center">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">
            下载
            <i class="el-icon-download"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  computed: {
    deleteurl() {
      var code = "";
      for (
        let index = 0;
        index < this.$store.getters.getdeepselect.length;
        index++
      ) {
        const element = this.$store.getters.getdeepselect[index];
        code += element["projectcode"];
        if (index < this.$store.getters.getdeepselect.length - 1) {
          code += "-";
        }
      }

      return "http://192.168.100.143:8082/deepdelete/" + code;
    }
  },
  methods: {
    handleEdit(row) {
      var urldown = "http://192.168.100.143:8082/download/" + row.projectcode;

      var file = row["deepfile"];
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
    },

    removeUpload(file, fileList) {
      if (!this.$store.getters.getlockReconnect) {
        this.$store.dispatch("initwebsock");
      }

      this.$axios({
        method: "post",
        url: this.deleteurl
      }).then(function(response) {
        console.log(response);
      });
    }
  }
};
</script>