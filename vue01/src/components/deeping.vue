<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getdeepselect" style="width: 100%">
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>

    <el-radio-group v-model="radio">
      <el-radio :label="1">一个单元</el-radio>
      <el-radio :label="2">二个单元</el-radio>
      <el-radio :label="3">三个单元</el-radio>
    </el-radio-group>

    <div style="margin: 15px 0;"></div>
    <el-form :model="prixf1[0]" :rules="rulesprixf1" v-if="radio>1" ref="prixf1[0]">
      <el-table :data="prixf1" style="width: 30%">
        <el-table-column prop="projectcodefix1" label="项目代号后缀" width="150" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectcodefix1">
              <el-input v-model="scope.row.projectcodefix1" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="projectnumber1" label="单元" width="100" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectnumber1">
              <el-input v-model="scope.row.projectnumber1" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
      </el-table>
    </el-form>

    <el-form :model="prixf2[0]" :rules="rulesprixf2" ref="prixf2[0]" v-if="radio>1 && radio<4">
      <el-table :data="prixf2" style="width: 30%;position: relative;">
        <el-table-column prop="projectcodefix2" label="项目代号后缀" width="150" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectcodefix2">
              <el-input v-model="scope.row.projectcodefix2" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="projectnumber2" label="单元" width="100" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectnumber2">
              <el-input v-model="scope.row.projectnumber2" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
      </el-table>
    </el-form>

    <el-form :model="prixf3[0]" :rules="rulesprixf3" ref="prixf3[0]" v-if="radio>2 && radio<4">
      <el-table :data="prixf3" style="width: 30%;position: relative;">
        <el-table-column prop="projectcodefix3" label="项目代号后缀" width="150" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectcodefix3">
              <el-input v-model="scope.row.projectcodefix3" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column prop="projectnumber3" label="单元" width="100" align="center">
          <template slot-scope="scope">
            <el-form-item prop="projectnumber3">
              <el-input v-model="scope.row.projectnumber3" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="tables[0]" :rules="rules" ref="tables[0]">
      <el-table :data="tables" ref="multipleTable">
        <el-table-column prop="clientname" label="客户名称" align="center">
          <template slot-scope="scope">
            <el-form-item prop="clientname">
              <el-input v-model="scope.row.clientname" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="marketstaffwithcall" label="市场/电话" align="center">
          <template slot-scope="scope">
            <el-form-item prop="marketstaffwithcall">
              <el-input v-model="scope.row.marketstaffwithcall" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="templatesystem" label="模板体系" align="center">
          <template slot-scope="scope">
            <el-form-item prop="templatesystem">
              <el-input v-model="scope.row.templatesystem" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="whetherprefab" label="是否预制件" align="center">
          <template slot-scope="scope">
            <el-form-item prop="whetherprefab">
              <el-input v-model="scope.row.whetherprefab" type="text-align:center"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="layerheigh" label="层高" align="center">
          <template slot-scope="scope">
            <el-form-item prop="layerheigh">
              <el-input v-model="scope.row.layerheigh"></el-input>
            </el-form-item>
          </template>
        </el-table-column>

        <el-table-column prop="designmanager" label="指定负责人" align="center">
          <template slot-scope="scope">
            <el-form-item prop="designmanager">
              <el-input v-model="scope.row.designmanager"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
      </el-table>
    </el-form>
    <div style="margin: 15px 0;"></div>

    <div>
      <el-button type="primary" @click="see" style="margin-left: 45%;">查看</el-button>
      <el-button type="primary" @click="resetForm">重置</el-button>
    </div>

    <div style="margin: 15px 0;"></div>

    <el-table :data="tablesr1" style="width: 100%">
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>

      <el-table-column prop="marketstaffwithcall" label="市场/电话" align="center"></el-table-column>
      <el-table-column prop="whetherprefab" label="是否预制件" align="center"></el-table-column>
      <el-table-column prop="layerheigh" label="预计进场时间" align="center"></el-table-column>

      <el-table-column prop="designmanager" label="设计负责人" align="center"></el-table-column>
    </el-table>
    <div style="margin: 15px 0;"></div>

    <div>
      <el-button type="primary" @click="submit" style="margin-left: 45%;">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tables: [
        {
          clientname: "",
          marketstaffwithcall: "",
          templatesystem: "",
          whetherprefab: "",
          layerheigh: "",
          designmanager: ""
        }
      ],

      prixf1: [
        {
          projectcodefix1: "",
          projectnumber1: ""
        }
      ],
      prixf2: [
        {
          projectcodefix2: "",
          projectnumber2: ""
        }
      ],
      prixf3: [
        {
          projectcodefix3: "",
          projectnumber3: ""
        }
      ],
      rulesprixf1: {
        projectcodefix1: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        projectnumber1: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },
      rulesprixf2: {
        projectcodefix2: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        projectnumber2: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },
      rulesprixf3: {
        projectcodefix3: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        projectnumber3: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },
      rules: {
        clientname: [{ required: true, message: "输入数据", trigger: "blur" }],
        marketstaffwithcall: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        templatesystem: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        whetherprefab: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        layerheigh: [{ required: true, message: "输入数据", trigger: "blur" }],
        designmanager: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },

      radio: 1,
      tablesr1: []
    };
  },
  methods: {
    see() {
      var valids = true;
      this.$refs["tables[0]"].validate(valid => {
        if (!valid) {
          valids = false;
        }
      });

      if (this.radio === 2) {
        this.$refs["prixf2[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf1[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
      }
      if (this.radio === 3) {
        this.$refs["prixf3[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf2[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf1[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
      }
      if (valids && this.$store.getters.getdeepselect.length > 0) {
        this.tablesr1 = [];

        switch (this.radio) {
          case 1:
            for (
              let index = 0;
              index < this.$store.getters.getdeepselect.length;
              index++
            ) {
              var dem = JSON.parse(
                JSON.stringify(this.$store.getters.getdeepselect[index])
              );

              dem["tag"] = "最终深化中";

              for (const key in this.tables[0]) {
                dem[key] = this.tables[0][key];
              }

              this.tablesr1.push(dem);
            }

            break;

          case 2:
            for (
              let index = 0;
              index < this.$store.getters.getdeepselect.length;
              index++
            ) {
              var dem = [
                JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselect[index])
                ),
                JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselect[index])
                )
              ];

              dem[0]["projectcode"] += this.prixf1[0]["projectcodefix1"];
              dem[1]["projectcode"] += this.prixf2[0]["projectcodefix2"];

              dem[0]["projectnumber"] += this.prixf1[0]["projectnumber1"];
              dem[1]["projectnumber"] += this.prixf2[0]["projectnumber2"];

              dem[0]["tag"] = "最终深化中";
              dem[1]["tag"] = "最终深化中";

              for (let i = 0; i < dem.length; i++) {
                for (const key in this.tables[0]) {
                  dem[i][key] = this.tables[0][key];
                }

                this.tablesr1.push(dem[i]);
              }
            }

            break;
          case 3:
            for (
              let index = 0;
              index < this.$store.getters.getdeepselect.length;
              index++
            ) {
              var dem = [
                JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselect[index])
                ),
                JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselect[index])
                ),
                JSON.parse(
                  JSON.stringify(this.$store.getters.getdeepselect[index])
                )
              ];

              dem[0]["projectcode"] += this.prixf1[0]["projectcodefix1"];
              dem[1]["projectcode"] += this.prixf2[0]["projectcodefix2"];
              dem[2]["projectcode"] += this.prixf3[0]["projectcodefix3"];

              dem[0]["projectnumber"] += this.prixf1[0]["projectnumber1"];
              dem[1]["projectnumber"] += this.prixf2[0]["projectnumber2"];
              dem[2]["projectnumber"] += this.prixf3[0]["projectnumber3"];

              dem[0]["tag"] = "最终深化中";
              dem[1]["tag"] = "最终深化中";
              dem[2]["tag"] = "最终深化中";

              for (let i = 0; i < dem.length; i++) {
                for (const key in this.tables[0]) {
                  dem[i][key] = this.tables[0][key];
                }

                this.tablesr1.push(dem[i]);
              }
            }

            break;

          default:
            break;
        }
      }
    },

    submit() {
      var thismessage = this.$message;
      var se = this.$store;

      var valids = true;
      this.$refs["tables[0]"].validate(valid => {
        if (!valid) {
          valids = false;
        }
      });

      if (this.radio === 2) {
        this.$refs["prixf2[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf1[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
      }
      if (this.radio === 3) {
        this.$refs["prixf3[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf2[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
        this.$refs["prixf1[0]"].validate(valid => {
          if (!valid) {
            valids = false;
          }
        });
      }

      if (valids && this.tablesr1.length > 0) {
        if (this.radio === 1) {
          this.$store.dispatch("updatefirstdeeping", this.tablesr1);
          this.$store.dispatch("setdeepselect", []);
        } else if (this.radio > 1) {
          this.$store.dispatch("updateandinsertfirstdeeping", this.tablesr1);
          this.$store.dispatch("setdeepselect", []);
        }
      }
    },
    resetForm() {
      this.$refs["tables[0]"].resetFields();
      if (this.radio === 2) {
        this.$refs["prixf2[0]"].resetFields();
        this.$refs["prixf1[0]"].resetFields();
      }
      if (this.radio === 3) {
        this.$refs["prixf3[0]"].resetFields();
        this.$refs["prixf2[0]"].resetFields();
        this.$refs["prixf1[0]"].resetFields();
      }
    }
  }
};
</script>