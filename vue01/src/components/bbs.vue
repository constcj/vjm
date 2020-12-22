<template>
  <div>
    <el-row>
      <el-col :span="15" :offset="3">
        <div class="grid-content bg-purple">
          <el-button>全部</el-button>
          <el-button>精华</el-button>
          <el-button>我的贴</el-button>
          <el-button>发帖</el-button>
        </div>
      </el-col>
      <el-col :span="3">
        <div class="grid-content bg-purple-light">
          <el-input v-model="search" placeholder="输入关键字搜索" />
        </div>
      </el-col>
    </el-row>

    <div style="margin: 15px 0;"></div>

    <el-table ref="multipleTable" :data="data" style="width: 80%;left:10%">
      <el-table-column prop="projectsource" width="30" align="center">
        <img src="../assets/jing.jpg" fit="fit" class="im" />
      </el-table-column>

      <el-table-column label="主题" width="500" align="left">
        <template>
          <el-link href="/Manage" target="_blank">默认链接地对地导弹</el-link>
        </template>
      </el-table-column>
      <el-table-column label="作者" align="left">设计四科张武</el-table-column>
      <el-table-column label="发帖时间" align="left">2010/1/1 14:30</el-table-column>
      <el-table-column label="回帖人数" align="left">2010/1/1 14:30</el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: [
        {
          projectsource: ""
        }
      ],
      search: ""
    };
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