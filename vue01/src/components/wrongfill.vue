<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getselectwrong" style="width: 100%">
      <el-table-column prop="projectsource" label="订单来源" width="180" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="300" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" align="center"></el-table-column>
      <el-table-column prop="qiang" label="墙设计" align="center"></el-table-column>
      <el-table-column prop="liang" label="梁设计" align="center"></el-table-column>
      <el-table-column prop="louti" label="楼梯设计" align="center"></el-table-column>
      <el-table-column prop="jiedian" label="节点设计" align="center"></el-table-column>
      <el-table-column prop="loumian" label="楼面设计" align="center"></el-table-column>
      <el-table-column prop="diaomo" label="吊模设计" align="center"></el-table-column>

      <el-table-column label="铝件总数量" align="center">{{altotl}}</el-table-column>
      <el-table-column label="铝背楞总数量" align="center">{{albtotl}}</el-table-column>
      <el-table-column label="铁件总数量" align="center">{{irontotl}}</el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>

    <el-table
      :data="this.$store.getters.getprojectInfodbwrong"
      border
      style="width: 100%;font-size: 10px;"
    >
      <el-table-column prop="qiangalincrease" label="墙铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangalreplace" label="墙铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangironincrease" label="墙铁件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangironreplace" label="墙铁件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangalbincrease" label="墙铝背楞新增" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangalbreplace" label="墙铝背楞替换" width="46" align="center"></el-table-column>
      <el-table-column prop="qiangmountings" label="墙配件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="liangalincrease" label="梁铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="liangalreplace" label="梁铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="liangmountings" label="梁配件新增" width="46" align="center"></el-table-column>

      <el-table-column prop="loumianalincrease" label="楼面铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="loumianalreplace" label="楼面铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="loumianmountings" label="楼面配件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="diaomoalincrease" label="吊模铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="diaomoalreplace" label="吊模铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="diaomoironincrease" label="吊模铁件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="diaomoironreplace" label="吊模铁件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="diaomomountings" label="吊模配件新增" width="46" align="center"></el-table-column>

      <el-table-column prop="jiedianalincrease" label="节点铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="jiedianalreplace" label="节点铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="jiedianmountings" label="节点配件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="loutialincrease" label="楼梯铝件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="loutialreplace" label="楼梯铝件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="loutiironincrease" label="楼梯铁件新增" width="46" align="center"></el-table-column>
      <el-table-column prop="loutiironreplace" label="楼梯铁件替换" width="46" align="center"></el-table-column>
      <el-table-column prop="loutialbincrease" label="楼梯铝背楞新增" width="46" align="center"></el-table-column>
      <el-table-column prop="loutialbreplace" label="楼梯铝背楞替换" width="46" align="center"></el-table-column>
      <el-table-column prop="loutimountings" label="楼梯配件新增" width="46" align="center"></el-table-column>

      <el-table-column label="铝件错误率" width="50" align="center">{{al}}</el-table-column>
      <el-table-column label="铁件错误率" width="50" align="center">{{iron}}</el-table-column>
      <el-table-column label="铝背楞错误率" width="50" align="center">{{alb}}</el-table-column>

      <el-table-column label="错误总占比" width="50" align="center">{{totlincrease}}</el-table-column>

      <el-table-column label="配件新增总量" width="50" align="center">{{mountingstotal}}</el-table-column>

      <el-table-column prop="remark" label="备注" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>
    <!-- <el-table :data="radioss" :show-header="false" style="width: 100%;">
      <el-table-column prop="title" width="200" align="center"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-checkbox size="mini" v-model="scope.row.qiangchecked" label="墙">墙</el-checkbox>
          <el-checkbox size="mini" v-model="scope.row.liangchecked" label="梁">梁</el-checkbox>
          <el-checkbox size="mini" v-model="scope.row.loumianchecked" label="楼面">楼面</el-checkbox>
          <el-checkbox size="mini" v-model="scope.row.jiedianchecked" label="节点">节点</el-checkbox>
          <el-checkbox size="mini" v-model="scope.row.diaomochecked" label="吊模">吊模</el-checkbox>
          <el-checkbox size="mini" v-model="scope.row.loutichecked" label="楼梯">楼梯</el-checkbox>
        </template>
      </el-table-column>
    </el-table>-->

    <div style="margin: 20px 0;"></div>

    <el-form :model="tables[0]" :rules="rules" ref="tables[0]">
      <el-table :data="tables" style="width: 100%;font-size: 10px;">
        <el-table-column label="填写错误信息" align="center">
          <el-table-column prop="qiangalincrease" label="墙铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangalincrease">
                <el-input
                  v-model="scope.row.qiangalincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="qiangalreplace" label="墙铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangalreplace">
                <el-input v-model="scope.row.qiangalreplace" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="qiangironincrease" label="墙铁件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangironincrease">
                <el-input
                  v-model="scope.row.qiangironincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="qiangironreplace" label="墙铁件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangironreplace">
                <el-input
                  v-model="scope.row.qiangironreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangalbincrease" label="墙铝背楞新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangalbincrease">
                <el-input
                  v-model="scope.row.qiangalbincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangalbreplace" label="墙铝背楞替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangalbreplace">
                <el-input
                  v-model="scope.row.qiangalbreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangmountings" label="墙配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangmountings">
                <el-input v-model="scope.row.qiangmountings" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangalincrease" label="梁铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangalincrease">
                <el-input
                  v-model="scope.row.liangalincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangalreplace" label="梁铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangalreplace">
                <el-input v-model="scope.row.liangalreplace" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangmountings" label="梁配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangmountings">
                <el-input v-model="scope.row.liangmountings" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="loumianalincrease" label="楼面铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianalincrease">
                <el-input
                  v-model="scope.row.loumianalincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianalreplace" label="楼面铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianalreplace">
                <el-input
                  v-model="scope.row.loumianalreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianmountings" label="楼面配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianmountings">
                <el-input
                  v-model="scope.row.loumianmountings"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomoalincrease" label="吊模铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomoalincrease">
                <el-input
                  v-model="scope.row.diaomoalincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomoalreplace" label="吊模铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomoalreplace">
                <el-input
                  v-model="scope.row.diaomoalreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomoironincrease" label="吊模铁件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomoironincrease">
                <el-input
                  v-model="scope.row.diaomoironincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomoironreplace" label="吊模铁件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomoironreplace">
                <el-input
                  v-model="scope.row.diaomoironreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomomountings" label="吊模配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomomountings">
                <el-input
                  v-model="scope.row.diaomomountings"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="jiedianalincrease" label="节点铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianalincrease">
                <el-input
                  v-model="scope.row.jiedianalincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianalreplace" label="节点铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianalreplace">
                <el-input
                  v-model="scope.row.jiedianalreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianmountings" label="节点配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianmountings">
                <el-input
                  v-model="scope.row.jiedianmountings"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutialincrease" label="楼梯铝件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutialincrease">
                <el-input
                  v-model="scope.row.loutialincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutialreplace" label="楼梯铝件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutialreplace">
                <el-input v-model="scope.row.loutialreplace" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutiironincrease" label="楼梯铁件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutiironincrease">
                <el-input
                  v-model="scope.row.loutiironincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutiironreplace" label="楼梯铁件替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutiironreplace">
                <el-input
                  v-model="scope.row.loutiironreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutialbincrease" label="楼梯铝背楞新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutialbincrease">
                <el-input
                  v-model="scope.row.loutialbincrease"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutialbreplace" label="楼梯铝背楞替换" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutialbreplace">
                <el-input
                  v-model="scope.row.loutialbreplace"
                  class="input"
                  type="text-align:center"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutimountings" label="楼梯配件新增" width="55" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutimountings">
                <el-input v-model="scope.row.loutimountings" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="remark" label="备注" align="center">
            <template slot-scope="scope">
              <el-form-item prop="remark">
                <el-input v-model="scope.row.remark" class="input" type="text-align:center"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>
    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" @click="submit" style="margin-left: 45%;">确定</el-button>
      <el-button type="primary" @click="resetForm">重置</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tables: [
        {
          projectcode: "",
          qiangalincrease: "",
          qiangalreplace: "",
          qiangironincrease: "",
          qiangironreplace: "",
          qiangalbincrease: "",
          qiangalbreplace: "",
          qiangmountings: "",
          liangalincrease: "",
          liangalreplace: "",
          liangmountings: "",
          loumianalincrease: "",
          loumianalreplace: "",
          loumianmountings: "",
          diaomoalincrease: "",
          diaomoalreplace: "",
          diaomoironincrease: "",
          diaomoironreplace: "",
          diaomomountings: "",
          jiedianalincrease: "",
          jiedianalreplace: "",
          jiedianmountings: "",
          loutialincrease: "",
          loutialreplace: "",
          loutiironincrease: "",
          loutiironreplace: "",
          loutialbincrease: "",
          loutialbreplace: "",
          loutimountings: "",
          remark: ""
        }
      ],

      rules: {
        qiangalincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangironincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangironreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangmountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangalincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangalreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangmountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianalincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianalreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianmountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomoalincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomoalreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomoironincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomoironreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomomountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianalincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianalreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianmountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutiironincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutiironreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbincrease: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbreplace: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutimountings: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        remark: [{ required: true, message: "输入数据", trigger: "blur" }]
      },

      radioss: [
        {
          title: "勾选存在错误的部位：",
          qiangchecked: false,
          liangchecked: false,
          loumianchecked: false,
          jiedianchecked: false,
          diaomochecked: false,
          loutichecked: false
        }
      ]
    };
  },

  computed: {
    altotl() {
      if (this.$store.getters.getselectwrongdb.length > 0) {
        var db = this.$store.getters.getselectwrongdb[0];
        return (
          db["qiangstandardn"] +
          db["qiangstandardwithaccn"] +
          db["qiangstandardwithaccholen"] +
          db["qiangnonstandardn"] +
          db["qiangnonstandardwithaccn"] +
          db["qiangvarlayernonstandardn"] +
          db["qiangvarlayernonstandardwithaccn"] +
          db["liangstandardn"] +
          db["liangstandardwithaccn"] +
          db["liangstandardwithaccholen"] +
          db["liangnonstandardn"] +
          db["liangnonstandardwithaccn"] +
          db["liangvarlayernonstandardn"] +
          db["liangvarlayernonstandardwithaccn"] +
          db["loumianstandardn"] +
          db["loumianstandardwithaccn"] +
          db["loumianstandardwithaccholen"] +
          db["loumiannonstandardn"] +
          db["loumiannonstandardwithaccn"] +
          db["loumianvarlayernonstandardn"] +
          db["loumianvarlayernonstandardwithaccn"] +
          db["jiedianstandardn"] +
          db["jiedianstandardwithaccn"] +
          db["jiedianstandardwithaccholen"] +
          db["jiediannonstandardn"] +
          db["jiediannonstandardwithaccn"] +
          db["jiedianvarlayernonstandardn"] +
          db["jiedianvarlayernonstandardwithaccn"] +
          db["loutistandardn"] +
          db["loutistandardwithaccn"] +
          db["loutistandardwithaccholen"] +
          db["loutinonstandardn"] +
          db["loutinonstandardwithaccn"] +
          db["loutivarlayernonstandardn"] +
          db["loutivarlayernonstandardwithaccn"] +
          db["diaomostandardn"] +
          db["diaomostandardwithaccn"] +
          db["diaomostandardwithaccholen"] +
          db["diaomononstandardn"] +
          db["diaomononstandardwithaccn"] +
          db["diaomovarlayernonstandardn"] +
          db["diaomovarlayernonstandardwithaccn"] +
          db["diaomononstandardn"] +
          db["diaomononstandardwithaccn"] +
          db["diaomovarlayernonstandardn"]
        );
      } else {
        return 0;
      }
    },
    albtotl() {
      if (this.$store.getters.getselectwrongdb.length > 0) {
        var db = this.$store.getters.getselectwrongdb[0];
        return (
          db["qiangalbackstandardn"] +
          db["qiangalbacknonstandardn"] +
          db["loutialbackstandardn"] +
          db["loutialbacknonstandardn"]
        );
      } else {
        return 0;
      }
    },
    irontotl() {
      if (this.$store.getters.getselectwrongdb.length > 0) {
        var db = this.$store.getters.getselectwrongdb[0];
        return (
          db["loutiironbacknonstandardn"] +
          db["qiangironbacknonstandardn"] +
          db["anglesteeln"] +
          db["squaretuben"] +
          db["ironbox"]
        );
      } else {
        return 0;
      }
    },
    al() {
      if (this.$store.getters.getprojectInfodbwrong.length > 0) {
        var db = this.$store.getters.getprojectInfodbwrong[0];
        var alrod =
          (parseFloat(
            db["qiangalincrease"] +
              db["liangalincrease"] +
              db["loumianalincrease"] +
              db["diaomoalincrease"] +
              db["jiedianalincrease"] +
              db["loutialincrease"]
          ) /
            parseFloat(this.altotl)) *
          100;
        if (alrod === 0) return 0;
        return alrod.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    alb() {
      if (this.$store.getters.getprojectInfodbwrong.length > 0) {
        var db = this.$store.getters.getprojectInfodbwrong[0];
        var alb =
          (parseFloat(db["qiangalbincrease"] + db["loutialbincrease"]) /
            parseFloat(this.albtotl)) *
          100;
        if (alb === 0) return 0;
        return alb.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    iron() {
      if (this.$store.getters.getprojectInfodbwrong.length > 0) {
        var db = this.$store.getters.getprojectInfodbwrong[0];
        var iron =
          (parseFloat(
            db["loutiironincrease"] +
              db["diaomoironincrease"] +
              db["qiangironincrease"]
          ) /
            parseFloat(this.irontotl)) *
          100;
        if (iron === 0) return 0;

        return iron.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    totlincrease() {
      if (this.altotl !== 0 || this.altotl !== 0 || this.altotl !== 0) {
        var totlincrease =
          (parseFloat(this.iron + this.alb + this.al) /
            parseFloat(this.altotl + this.albtotl + this.irontotl)) *
          100;

        if (totlincrease === 0) return 0;

        return totlincrease.toFixed(2) + "%";
      } else {
        return 0;
      }
    },
    mountingstotal() {
      if (this.$store.getters.getprojectInfodbwrong.length > 0) {
        var db = this.$store.getters.getprojectInfodbwrong[0];

        return (
          db["loutimountings"] +
          db["diaomomountings"] +
          db["jiedianmountings"] +
          db["loumianmountings"] +
          db["liangmountings"] +
          db["qiangmountings"]
        );
      } else {
        return 0;
      }
    }
  },

  methods: {
    submit() {
      if (this.$store.getters.getselectwrong.length === 0) {
        this.$message({
          message: "选择项目！",
          type: "warning"
        });
        return;
      }

      this.$refs["tables[0]"].validate(valid => {
        if (valid) {
          this.tables[0]["projectcode"] = this.$store.getters.getselectwrong[0][
            "projectcode"
          ];
          this.$store.dispatch("setprojectwrongdb", this.tables[0]);
        }
      });
    },
    resetForm() {
      this.$refs["tables[0]"].resetFields();
    }
  }
};
</script>

<style>
.input .el-input__inner {
  padding-left: 5px;
  padding-right: 5px;
  font-size: 10px;
}
</style>