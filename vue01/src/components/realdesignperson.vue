<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdesigncomplete"
    >
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="400" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
      <el-table-column prop="tag" label="状态" align="center"></el-table-column>

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
   
  }
};
</script>