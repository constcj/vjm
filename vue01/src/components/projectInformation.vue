<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getProjectInfo"
      border
      style="width: 80%;left:10%"
    >
      <el-table-column prop="projectname" label="项目名称" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="项目栋号" width="400" align="center"></el-table-column>
    </el-table>
    <br />

    <el-table ref="multipleTable" :data="data1" border :show-header="false" style="width: 80%;left:10%">
      <el-table-column prop="title1" label="主题1" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="信息1" width="400" align="center"></el-table-column>
      <el-table-column prop="title2" label="主题2" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname2" label="信息2" align="center"></el-table-column>
    </el-table>
    <br />
    <br />
    <el-table
      ref="multipleTable"
      :data="this.$store.getters.getCreatPoject"
      border
      style="width: 80%;left:10%"
    >
      <el-table-column prop="projectsource" label="姓名" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="部位" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="绩效占比%" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="部位件数" align="center"></el-table-column>
    </el-table>
    <br />
    <br />
    <el-table ref="multipleTable" :data="data3" show-summary style="width: 80%;left:10%">
      <el-table-column label="项目差错数据及清单数据" align="center">
        <el-table-column prop="datil" label="详细信息" width="300" align="center"></el-table-column>
        <el-table-column prop="qiang" label="墙" align="center"></el-table-column>
        <el-table-column prop="liang" label="梁" align="center"></el-table-column>
        <el-table-column prop="loumian" label="楼面" align="center"></el-table-column>
        <el-table-column prop="diaomo" label="吊模" align="center"></el-table-column>
        <el-table-column prop="jiedian" label="节点" align="center"></el-table-column>
        <el-table-column prop="louti" label="楼梯" align="center"></el-table-column>
        <el-table-column prop="total" label="合计" align="center"></el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>

  <style scoped>
span {
  width: 40%;
  display: inline-block;
}
</style>

<script>
export default {
  data() {
    return {};
  },
  mounted() {console.log(this.$store.getters.getProjectInfodb);
  },
  computed: {
    data3() {
      if (
        this.$store.getters.getProjectInfodb.length > 0 &&
        this.$store.getters.getProjectInfo.length > 0
      ) {
        return [
          {
            datil: "设计师",
            qiang: this.$store.getters.getProjectInfo[0]["qiang"],
            liang: this.$store.getters.getProjectInfo[0]["qiang"],
            loumian: this.$store.getters.getProjectInfo[0]["qiang"],
            diaomo: this.$store.getters.getProjectInfo[0]["qiang"],
            jiedian: this.$store.getters.getProjectInfo[0]["qiang"],
            louti: this.$store.getters.getProjectInfo[0]["qiang"],
            total: ""
          },
          {
            datil: "审查人员",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "图纸工艺问题",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "补板件数",
            qiang:
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangalbincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangironincrease"
              ],
            liang: this.$store.getters.getprojectInfodbwronglook[0][
              "liangalincrease"
            ],
            loumian: this.$store.getters.getprojectInfodbwronglook[0][
              "loumianalincrease"
            ],
            diaomo:
              this.$store.getters.getprojectInfodbwronglook[0][
                "diaomoalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "diaomoironincrease"
              ],
            jiedian: this.$store.getters.getprojectInfodbwronglook[0][
              "jiedianalincrease"
            ],
            louti:
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutialincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutiironincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutialbincrease"
              ],
            total:
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangalbincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "qiangironincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "liangalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loumianalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "diaomoalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "diaomoironincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "jiedianalincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutialincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutiironincrease"
              ] +
              this.$store.getters.getprojectInfodbwronglook[0][
                "loutialbincrease"
              ]
          },
          {
            datil: "首层标准件",
            qiang: this.$store.getters.getProjectInfodb[0]["qiangstandardn"],
            liang: this.$store.getters.getProjectInfodb[0]["liangstandardn"],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumianstandardn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0]["diaomostandardn"],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiedianstandardn"
            ],
            louti: this.$store.getters.getProjectInfodb[0]["loutistandardn"],
            total:
              this.$store.getters.getProjectInfodb[0]["qiangstandardn"] +
              this.$store.getters.getProjectInfodb[0]["liangstandardn"] +
              this.$store.getters.getProjectInfodb[0]["loumianstandardn"] +
              this.$store.getters.getProjectInfodb[0]["diaomostandardn"] +
              this.$store.getters.getProjectInfodb[0]["jiedianstandardn"] +
              this.$store.getters.getProjectInfodb[0]["loutistandardn"]
          },
          {
            datil: "首层标准件带配件",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangstandardwithaccn"
            ],
            liang: this.$store.getters.getProjectInfodb[0][
              "liangstandardwithaccn"
            ],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumianstandardwithaccn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomostandardwithaccn"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiedianstandardwithaccn"
            ],
            louti: this.$store.getters.getProjectInfodb[0][
              "loutistandardwithaccn"
            ],
            total:
              this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccn"] +
              this.$store.getters.getProjectInfodb[0]["liangstandardwithaccn"] +
              this.$store.getters.getProjectInfodb[0][
                "loumianstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "diaomostandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "jiedianstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0]["loutistandardwithaccn"]
          },
          {
            datil: "首层标准件带配件及穿墙孔",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangstandardwithaccholen"
            ],
            liang: this.$store.getters.getProjectInfodb[0][
              "liangstandardwithaccholen"
            ],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumianstandardwithaccholen"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomostandardwithaccholen"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiedianstandardwithaccholen"
            ],
            louti: this.$store.getters.getProjectInfodb[0][
              "loutistandardwithaccholen"
            ],
            total:
              this.$store.getters.getProjectInfodb[0][
                "qiangstandardwithaccholen"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "liangstandardwithaccholen"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loumianstandardwithaccholen"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "diaomostandardwithaccholen"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "jiedianstandardwithaccholen"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loutistandardwithaccholen"
              ]
          },
          {
            datil: "首层非标件",
            qiang: this.$store.getters.getProjectInfodb[0]["qiangnonstandardn"],
            liang: this.$store.getters.getProjectInfodb[0]["liangnonstandardn"],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumiannonstandardn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomononstandardn"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiediannonstandardn"
            ],
            louti: this.$store.getters.getProjectInfodb[0]["loutinonstandardn"],
            total:
              this.$store.getters.getProjectInfodb[0]["qiangnonstandardn"] +
              this.$store.getters.getProjectInfodb[0]["liangnonstandardn"] +
              this.$store.getters.getProjectInfodb[0]["loumiannonstandardn"] +
              this.$store.getters.getProjectInfodb[0]["diaomononstandardn"] +
              this.$store.getters.getProjectInfodb[0]["jiediannonstandardn"] +
              this.$store.getters.getProjectInfodb[0]["loutinonstandardn"]
          },
          {
            datil: "首层非标件带配件",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangnonstandardwithaccn"
            ],
            liang: this.$store.getters.getProjectInfodb[0][
              "liangnonstandardwithaccn"
            ],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumiannonstandardwithaccn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomononstandardwithaccn"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiediannonstandardwithaccn"
            ],
            louti: this.$store.getters.getProjectInfodb[0][
              "loutinonstandardwithaccn"
            ],
            total:
              this.$store.getters.getProjectInfodb[0][
                "qiangnonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "liangnonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loumiannonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "diaomononstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "jiediannonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loutinonstandardwithaccn"
              ]
          },
          {
            datil: "变层非标件",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangvarlayernonstandardn"
            ],
            liang: this.$store.getters.getProjectInfodb[0][
              "liangvarlayernonstandardn"
            ],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumianvarlayernonstandardn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomovarlayernonstandardn"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiedianvarlayernonstandardn"
            ],
            louti: this.$store.getters.getProjectInfodb[0][
              "loutivarlayernonstandardn"
            ],
            total:
              this.$store.getters.getProjectInfodb[0][
                "qiangvarlayernonstandardn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "liangvarlayernonstandardn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loumianvarlayernonstandardn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "diaomovarlayernonstandardn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "jiedianvarlayernonstandardn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loutivarlayernonstandardn"
              ]
          },
          {
            datil: "变层非标件带配件",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangvarlayernonstandardwithaccn"
            ],
            liang: this.$store.getters.getProjectInfodb[0][
              "liangvarlayernonstandardwithaccn"
            ],
            loumian: this.$store.getters.getProjectInfodb[0][
              "loumianvarlayernonstandardwithaccn"
            ],
            diaomo: this.$store.getters.getProjectInfodb[0][
              "diaomovarlayernonstandardwithaccn"
            ],
            jiedian: this.$store.getters.getProjectInfodb[0][
              "jiedianvarlayernonstandardwithaccn"
            ],
            louti: this.$store.getters.getProjectInfodb[0][
              "loutivarlayernonstandardwithaccn"
            ],
            total:
              this.$store.getters.getProjectInfodb[0][
                "qiangvarlayernonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "liangvarlayernonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loumianvarlayernonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "diaomovarlayernonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "jiedianvarlayernonstandardwithaccn"
              ] +
              this.$store.getters.getProjectInfodb[0][
                "loutivarlayernonstandardwithaccn"
              ]
          },
          {
            datil: "首层铝背楞",
            qiang:
              this.$store.getters.getProjectInfodb[0]["qiangalbackstandardn"] +
              this.$store.getters.getProjectInfodb[0][
                "qiangalbacknonstandardn"
              ],
            liang: "0",
            loumian: "0",
            diaomo: "0",
            jiedian: "0",
            louti:
              this.$store.getters.getProjectInfodb[0]["loutialbackstandardn"] +
              this.$store.getters.getProjectInfodb[0][
                "loutialbacknonstandardn"
              ],
            total: this.$store.getters.getProjectInfodb[0]["qiangalbackstandardn"] +
              this.$store.getters.getProjectInfodb[0][
                "qiangalbacknonstandardn"
              ]+this.$store.getters.getProjectInfodb[0]["loutialbackstandardn"] +
              this.$store.getters.getProjectInfodb[0][
                "loutialbacknonstandardn"
              ]
          },
          {
            datil: "首层铁背楞",
            qiang: this.$store.getters.getProjectInfodb[0][
              "qiangironbacknonstandardn"
            ],
            liang: "0",
            loumian: "0",
            diaomo: "0",
            jiedian: "0",
            louti: this.$store.getters.getProjectInfodb[0][
              "loutiironbacknonstandardn"
            ],
            total:  this.$store.getters.getProjectInfodb[0][
              "qiangironbacknonstandardn"
            ]+ this.$store.getters.getProjectInfodb[0][
              "loutiironbacknonstandardn"
            ]
          }
        ];
      } else if (
        this.$store.getters.getProjectInfodb.length === 0 &&
        this.$store.getters.getProjectInfo.length > 0
      ) {
        return [
          {
            datil: "设计师",
            qiang: this.$store.getters.getProjectInfo[0]["qiang"],
            liang: this.$store.getters.getProjectInfo[0]["qiang"],
            loumian: this.$store.getters.getProjectInfo[0]["qiang"],
            diaomo: this.$store.getters.getProjectInfo[0]["qiang"],
            jiedian: this.$store.getters.getProjectInfo[0]["qiang"],
            louti: this.$store.getters.getProjectInfo[0]["qiang"],
            total: ""
          },
          {
            datil: "审查人员",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "图纸工艺问题",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "补板件数",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件带配件及穿墙孔",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层非标件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层非标件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "变层非标件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "变层非标件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层铝背楞",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层铁背楞",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          }
        ];
      } else if (
        this.$store.getters.getProjectInfodb.length === 0 &&
        this.$store.getters.getProjectInfo.length === 0
      ) {
        return [
          {
            datil: "设计师",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "审查人员",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "图纸工艺问题",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "补板件数",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层标准件带配件及穿墙孔",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层非标件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层非标件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "变层非标件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "变层非标件带配件",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层铝背楞",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          },
          {
            datil: "首层铁背楞",
            qiang: "",
            liang: "",
            loumian: "",
            diaomo: "",
            jiedian: "",
            louti: "",
            total: ""
          }
        ];
      } else {
        return [];
      }
    },

    data1() {
      if (this.$store.getters.getProjectInfo.length > 0) {
        return [
          {
            title1: "签字时间",
            projectname: this.$store.getters.getProjectInfo[0]["signaturetime"],
            title2: "延期天数",
            projectname2: ""
          },
          {
            title1: "下发时间",
            projectname: this.$store.getters.getProjectInfo[0]["realtime"],
            title2: "难度系数",
            projectname2: this.$store.getters.getProjectInfo[0][
              "projectdifficulty"
            ]
          },
          {
            title1: "深化周期",
            projectname: "",
            title2: "面积标准率",
            projectname2: this.alarearatio
          },
          {
            title1: "项目代号",
            projectname: this.$store.getters.getProjectInfo[0]["projectcode"],
            title2: "铝件数标准率",
            projectname2: this.alnumratio
          },
          {
            title1: "下发次数",
            projectname: "",
            title2: "铝背楞件数标准率",
            projectname2: this.albnumratio
          },
          {
            title1: "设计部门",
            projectname: this.$store.getters.getProjectInfo[0]["department"],
            title2: "铝背楞长度标准率",
            projectname2: this.alblratio
          },
          {
            title1: "设计科长",
            projectname: "",
            title2: "总面积",
            projectname2: this.ala
          },
          {
            title1: "设计负责人",
            projectname: this.$store.getters.getProjectInfo[0]["designmanager"],
            title2: "总件数",
            projectname2: this.alnum + this.albnum + this.ironnum
          },
          {
            title1: "深化负责人",
            projectname: "",
            title2: "铝件",
            projectname2: this.alnum
          },
          {
            title1: "深化审查人",
            projectname: "",
            title2: "铁件",
            projectname2: this.ironnum
          },
          {
            title1: "深化互审错误数",
            projectname: "",
            title2: "设计审深化错误数",
            projectname2: ""
          }
        ];
      } else {
        return [
          {
            title1: "签字时间",
            projectname: "",
            title2: "延期天数",
            projectname2: ""
          },
          {
            title1: "下发时间",
            projectname: "",
            title2: "难度系数",
            projectname2: ""
          },
          {
            title1: "深化周期",
            projectname: "",
            title2: "面积标准率",
            projectname2: ""
          },
          {
            title1: "项目代号",
            projectname: "",
            title2: "铝件数标准率",
            projectname2: ""
          },
          {
            title1: "下发次数",
            projectname: "",
            title2: "铝背楞件数标准率",
            projectname2: ""
          },
          {
            title1: "设计部门",
            projectname: "",
            title2: "铝背楞长度标准率",
            projectname2: ""
          },
          {
            title1: "设计科长",
            projectname: "",
            title2: "总面积",
            projectname2: ""
          },
          {
            title1: "设计负责人",
            projectname: "",
            title2: "总件数",
            projectname2: ""
          },
          {
            title1: "深化负责人",
            projectname: "",
            title2: "铝件",
            projectname2: ""
          },
          {
            title1: "深化审查人",
            projectname: "",
            title2: "铁件",
            projectname2: ""
          },
          {
            title1: "深化互审错误数",
            projectname: "",
            title2: "设计审深化错误数",
            projectname2: ""
          }
        ];
      }
    },

    alnum() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangstandardn"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardn"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardn"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardn"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccholen"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccholen"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianstandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomostandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianstandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccholen"] +
          this.$store.getters.getProjectInfodb[0]["qiangnonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["liangnonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loumiannonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["diaomononstandardn"] +
          this.$store.getters.getProjectInfodb[0]["jiediannonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutinonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["qiangnonstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["liangnonstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0][
            "loumiannonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0]["diaomononstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0][
            "jiediannonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutinonstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["qiangvarlayernonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["liangvarlayernonstandardn"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianvarlayernonstandardn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomovarlayernonstandardn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianvarlayernonstandardn"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutivarlayernonstandardn"] +
          this.$store.getters.getProjectInfodb[0][
            "qiangvarlayernonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "liangvarlayernonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "loumianvarlayernonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomovarlayernonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianvarlayernonstandardwithaccn"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "loutivarlayernonstandardwithaccn"
          ]
        );
      } else {
        return 0;
      }
    },
    alstardnum() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangstandardn"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardn"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardn"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardn"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccn"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccholen"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccholen"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianstandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomostandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianstandardwithaccholen"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccholen"]
        );
      } else {
        return 0;
      }
    },
    ala() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangstandarda"] +
          this.$store.getters.getProjectInfodb[0]["liangstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandarda"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandarda"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loutistandarda"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccholea"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccholea"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianstandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomostandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianstandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccholea"] +
          this.$store.getters.getProjectInfodb[0]["qiangnonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["liangnonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loumiannonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["diaomononstandarda"] +
          this.$store.getters.getProjectInfodb[0]["jiediannonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loutinonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["qiangnonstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["liangnonstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0][
            "loumiannonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0]["diaomononstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0][
            "jiediannonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutinonstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["qiangvarlayernonstandarda"] +
          this.$store.getters.getProjectInfodb[0]["liangvarlayernonstandarda"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianvarlayernonstandarda"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomovarlayernonstandarda"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianvarlayernonstandarda"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutivarlayernonstandarda"] +
          this.$store.getters.getProjectInfodb[0][
            "qiangvarlayernonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "liangvarlayernonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "loumianvarlayernonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomovarlayernonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianvarlayernonstandardwithacca"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "loutivarlayernonstandardwithacca"
          ]
        );
      } else {
        return 0;
      }
    },
    alstarda() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangstandarda"] +
          this.$store.getters.getProjectInfodb[0]["liangstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandarda"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandarda"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandarda"] +
          this.$store.getters.getProjectInfodb[0]["loutistandarda"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["loumianstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["diaomostandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["jiedianstandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithacca"] +
          this.$store.getters.getProjectInfodb[0]["qiangstandardwithaccholea"] +
          this.$store.getters.getProjectInfodb[0]["liangstandardwithaccholea"] +
          this.$store.getters.getProjectInfodb[0][
            "loumianstandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "diaomostandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0][
            "jiedianstandardwithaccholea"
          ] +
          this.$store.getters.getProjectInfodb[0]["loutistandardwithaccholea"]
        );
      } else {
        return 0;
      }
    },
    albnum() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangalbackstandardn"] +
          this.$store.getters.getProjectInfodb[0]["qiangalbacknonstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutialbackstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutialbacknonstandardn"]
        );
      } else {
        return 0;
      }
    },
    albstandnum() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangalbackstandardn"] +
          this.$store.getters.getProjectInfodb[0]["loutialbackstandardn"]
        );
      } else {
        return 0;
      }
    },
    albl() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangalbackstandardl"] +
          this.$store.getters.getProjectInfodb[0]["qiangalbacknonstandardl"] +
          this.$store.getters.getProjectInfodb[0]["loutialbackstandardl"] +
          this.$store.getters.getProjectInfodb[0]["loutialbacknonstandardl"]
        );
      } else {
        return 0;
      }
    },
    albstandl() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangalbackstandardl"] +
          this.$store.getters.getProjectInfodb[0]["loutialbackstandardl"]
        );
      } else {
        return 0;
      }
    },
    ironnum() {
      if (this.$store.getters.getProjectInfodb.length > 0) {
        return (
          this.$store.getters.getProjectInfodb[0]["qiangalbackstandardl"] +
          this.$store.getters.getProjectInfodb[0]["loutialbackstandardl"]
        );
      } else {
        return 0;
      }
    },
    alarearatio() {
      if (this.ala > 0) {
        var ratio = (parseFloat(this.alstarda) / parseFloat(this.ala)) * 100;
        return ratio.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    alnumratio() {
      if (this.alnum > 0) {
        var ratio =
          (parseFloat(this.alstardnum) / parseFloat(this.alnum)) * 100;
        return ratio.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    albnumratio() {
      if (this.albnum > 0) {
        var ratio =
          (parseFloat(this.albstandnum) / parseFloat(this.albnum)) * 100;
        return ratio.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    alblratio() {
      if (this.albl > 0) {
        var ratio = (parseFloat(this.albstandl) / parseFloat(this.albl)) * 100;
        return ratio.toFixed(2) + "%";
      } else {
        return 0;
      }
    }
  }
};
</script>
