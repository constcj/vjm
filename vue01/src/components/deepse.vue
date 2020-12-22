<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdeepse"
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
      <el-table-column
        prop="tag"
        label="状态"
        width="80"
        align="center"
        :filters="this.$store.getters.gettag"
        :filter-method="filterTag "
      ></el-table-column>
      <el-table-column label="深化" align="center">
        <template slot-scope="scope">
          <el-button size="mini"  @click="handleEdit(scope.row)">最终深化</el-button>
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
  mounted(){

  },
  methods: {
    handleEdit(row) {

      if (this.multipleSelection.length === 0) {
        this.$store.dispatch("setdeepselectse", [row]);
      } else {
        this.$store.dispatch("setdeepselectse", this.multipleSelection);
      }
      this.$router.push({ path: "/deepingse" });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
      filterTag(value, row) {
      return row.tag === value;
    },
  }
};
</script>