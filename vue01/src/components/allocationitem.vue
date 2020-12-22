<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getdeepdistrlist"
      @selection-change="handleSelectionChange"
      style="width: 100%;"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="department" label="科室" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="分配深化师" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
    <div>
      <!-- <el-checkbox v-model="checked" @change="handleCheckAllChange">项目自动分配</el-checkbox> -->
      <el-select v-model="value" placeholder="请选择">
        <el-option
          v-for="item in this.$store.getters.getdeeppersonlist"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
      <el-button type="primary" @click="distribution" style="position:relative;">分配深化师</el-button>
      <el-button type="primary" @click="reset">重置</el-button>
    </div>
    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" style="margin-left:47%" @click="submit">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: "",

      multipleSelection: []
    };
  },

  computed: {},

  mounted() {
    this.$store.dispatch("setdeeppersonlist");
  },

  methods: {
    distribution() {
      if (this.multipleSelection !== []) {
        this.multipleSelection.forEach(element => {
          var index = this.$store.getters.getdeepdistrlist.indexOf(element);
          if (index > -1) {
            this.$store.getters.getdeepdistrlist[index][
              "deepeningdivision"
            ] = this.value;
          }
        });
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    submit() {
      var count = 0;

      var mdeep = [];

      var deepdistr = [];

      for (
        let index = 0;
        index < this.$store.getters.getdeepdistrlist.length;
        index++
      ) {
        if (
          this.$store.getters.getdeepdistrlist[index]["deepeningdivision"] !==
            "" &&
          this.$store.getters.getdeepdistrlist[index]["deepeningdivision"] !==
            null
        ) {
          mdeep.push(this.$store.getters.getdeepdistrlist[index]);
          count += 1;
        }
      }
      if (count > 0) {
        deepdistr = JSON.parse(JSON.stringify(mdeep));

        for (let index = 0; index < deepdistr.length; index++) {
          deepdistr[index]["tag"] = "初次深化中";
        }
        this.$store.dispatch("distrdeepperson",deepdistr);
      } else {
        this.$message({
          message: "未分配",
          type: "warning"
        });
      }
    },
    reset() {
      this.$store.dispatch("resetdeepdistrlist");
    }
  }
};
</script>