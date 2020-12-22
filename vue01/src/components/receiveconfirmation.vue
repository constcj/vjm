<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="newProjectData"
      @selection-change="handleSelectionChange"
      style="width: 100%;"
    >
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="department" label="科室" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
       <el-table-column
        prop="tag"
        label="状态"
        width="80"
        align="center"
        :filters="this.$store.getters.gettag"
        :filter-method="filterTag "
      ></el-table-column>

    </el-table>
  </div>
</template>

<script>
var that = this;

export default {
  data() {
    return {
      multipleSelection: []
    };
  },

  mounted() {},
  computed: {
    newProjectData() {
      return this.$store.getters.getdeepdistrcomplete;
    }
  },

  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
     filterTag(value, row) {
      return row.tag === value;
    },
  }
};
</script>