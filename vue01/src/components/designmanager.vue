<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdesign"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="400" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号"  align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号"  align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
      <el-table-column prop="determine" label="确认" align="center">
        <template slot-scope="scope">
          <el-button type="primary"  @click="handleEdit(scope.row)">分配</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
  
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
        this.$store.dispatch("setdesignmangerfirstselect", [row]);
      } else {
        this.$store.dispatch("setdesignmangerfirstselect", this.multipleSelection);
      }
      this.$router.push({ path: "/designmanagerdistr" });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
    }
};
</script>