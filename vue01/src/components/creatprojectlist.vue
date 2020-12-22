<template>
  <div>
    <el-input v-model="search" style="width: 20%; " placeholder="输入关键字搜索" />

    <el-divider></el-divider>
    <el-table
      ref="filterTable"
      :data="this.$store.getters.getcreatcompletelist.filter(
          data =>       
            data.projectname.includes(search) ||
            data.projectcode.includes(search)
        )"
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
    <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" label="序号" width="50" align="center"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="100" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" width="200" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column
        prop="department"
        label="分配科室"
        column-key="department"
        align="center"
        :filters="this.$store.getters.getdepartment"
        :filter-method="filterdepartment"
      ></el-table-column>
      <el-table-column
        prop="tag"
        label="状态"
        align="center"
        :filters="this.$store.getters.gettag"
        :filter-method="filterTag "
      ></el-table-column>

      <el-table-column label="修改" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            :disabled="plannercanchange[scope.row.projectcode]"
            @click="handleEdit(scope.row)"
          >修改</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: "",

      value1: "",

      multipleSelection: []
    };
  },
  mounted() {},
  computed: {
    plannercanchange() {
      return this.$store.getters.getplannercanchange;
    }
  },
  methods: {
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    filterdepartment(value, row) {
      return row.tag === value;
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
     handleEdit(row) {
      if (this.multipleSelection.length === 0) {
        this.$store.dispatch("setplannerchangselect", [row]);
      } else {
        this.$store.dispatch("setplannerchangselect", this.multipleSelection);
      }
      this.$router.push({ path: "/creatprojectchange" });
    }
  }
};
</script>