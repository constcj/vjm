<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdeep"
      @selection-change="handleSelectionChange"
      style="width: 100%"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column label="深化" align="center">
        <template slot-scope="scope">
          <el-button size="mini"  @click="handleEdit(scope.row)">深化</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
</style>

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
        this.$store.dispatch("setdeepselect", [row]);
      } else {
        this.$store.dispatch("setdeepselect", this.multipleSelection);
      }
      this.$router.push({ path: "/deeping" });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
  }
};
</script>