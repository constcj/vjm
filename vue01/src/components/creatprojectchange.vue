<template>
  <div>
    <el-table ref="multipleTable" :data="plannerchangselect">
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.projectsource"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.projectname"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="150" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.projectnumber"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="receivetime" label="图纸接收时间" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.receivetime"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.estimatetime"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="department" label="分配科室" align="center">
        <template slot-scope="scope">
          <el-input v-model="scope.row.department"></el-input>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" @click="handleEdit" style="position: relative;margin-left: 45%;">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      creatneed: [
        "projectsource",
        "projectname",
        "projectnumber",
        "receivetime",
        "estimatetime",
        "department"
      ]
    };
  },

  computed: {
    plannerchangselect() {
      return this.$store.getters.getplannerchangselect;
    }
  },

  methods: {
    handleEdit() {
      if (this.$store.getters.getplannerchangselect.length > 0) {
        var isnull = false;
        let plannerchangselect = this.plannerchangselect;
        let creatneed = this.creatneed;

        for (let index = 0; index < plannerchangselect.length; index++) {
          for (let i = 0; i < creatneed.length; i++) {
            if (plannerchangselect[index][creatneed[i]] === "") {
              isnull = true;
            }
          }
        }

        if (isnull) {
          this.$message({
            message: "不能为空！",
            type: "warning"
          });
        } else {
          this.$store.dispatch("updateCreatProject", this.plannerchangselect);
        }
      }
    }
  }
};
</script>