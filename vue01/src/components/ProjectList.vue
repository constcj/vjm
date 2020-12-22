<template>
  <div>
    <div>
      <el-input v-model="search" style="width: 20%; " placeholder="输入关键字搜索" />
      <el-button type="primary" @click="expexcel" style="position:absolute;right:50px;">导出数据</el-button>
    </div>

    <div style="margin: 15px 0;"></div>

    <el-checkbox
      :indeterminate="isIndeterminate"
      v-model="checkAll"
      @change="handleCheckAllChange"
    >全选</el-checkbox>

    <div style="margin: 15px 0;"></div>
    <el-checkbox-group v-model="checkedDatas" @change="handleCheckedCitiesChange">
      <el-checkbox v-for="Data in Datas" :label="Data" :key="Data">{{Data}}</el-checkbox>
    </el-checkbox-group>
    <div style="margin: 15px 0;"></div>
    <!-- style="font-size: 9px;" -->
    <div>
      <span class="demonstration" style="font-size: 13px;">图纸接收时间</span>
      <el-date-picker
        v-model="value1"
        unlink-panels
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        value-format="yyyy.MM.dd"
        :default-time="['00:00:00', '23:59:59']"
        style="width: 230px;"
      ></el-date-picker>

      <span class="demonstration" style="margin-left: 5%;font-size: 13px;">底图签字时间</span>
      <el-date-picker
        v-model="value2"
        unlink-panels
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        value-format="yyyy.MM.dd"
        :default-time="['00:00:00', '23:59:59']"
        style="width: 230px;font-size: 9px;"
      ></el-date-picker>

      <span class="demonstration" style="margin-left: 5%;font-size: 13px;">设计启动时间</span>
      <el-date-picker
        v-model="value3"
        unlink-panels
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        value-format="yyyy.MM.dd"
        :default-time="['00:00:00', '23:59:59']"
        style="width: 230px;font-size: 9px;"
      ></el-date-picker>

      <span class="demonstration" style="margin-left: 5%;font-size: 13px;">设计实际完成时间</span>
      <el-date-picker
        v-model="value4"
        unlink-panels
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        value-format="yyyy.MM.dd"
        :default-time="['00:00:00', '23:59:59']"
        style="width: 230px;"
      ></el-date-picker>
    </div>

    <el-divider></el-divider>

    <el-table
      ref="filterTable"
      :data="tabless"
      style="width: 100%;font-size: 13px;"
      @selection-change="handleSelectionChange"
      max-height="500"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" label="序号" width="50" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="250" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="80" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" width="90" align="center"></el-table-column>
      <el-table-column
        prop="tag"
        label="状态"
        width="150"
        align="center"
        :filters="this.$store.getters.gettag"
        :filter-method="filterTag "
      ></el-table-column>
      <el-table-column prop="layerheigh" label="层高(m)" width="80" align="center"></el-table-column>
      <el-table-column prop="projectdifficulty" label="难度系数" width="80" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" width="100" align="center"></el-table-column>
      <el-table-column prop="signaturetime" label="底图签字时间" width="100" align="center"></el-table-column>
      <el-table-column prop="startime" label="设计启动时间" width="100" align="center"></el-table-column>
      <el-table-column prop="realtime" label="设计实际完成时间" width="140" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" width="90" align="center"></el-table-column>
      <el-table-column prop="designmanager" label="布排负责人" width="95" align="center"></el-table-column>
      <el-table-column
        prop="department"
        label="科室"
        width="80"
        column-key="department"
        :filters="this.$store.getters.getdepartment"
        :filter-method="filterdepartment"
        align="center"
      ></el-table-column>
      <el-table-column label="项目信息">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import XLSX from "xlsx";
import fs from "file-saver";
const dataOptions = [
  "标准件数据",
  "标准件带配件数据",
  "标准件带穿墙孔数据",
  "标准件带配件及穿墙孔数据",
  "铝背楞标准件数据",
  "差错数据",
  "图纸工艺数据",
  "配件清单数据",
  "积分数据"
];
const dataOptionspart = {
  projectcode: "项目代号",
  projectname: "项目名称",
  projectsource: "项目来源",
  receivetime: "图纸接收时间",
  estimatetime: "预计进场时间",
  department: "科室",
  projectnumber: "楼栋号",
  deepeningdivision: "深化师",
  clientname: "客户名称",
  marketstaffwithcall: "市场/电话",
  templatesystem: "模板体系",
  whetherprefab: "是否预制",
  layerheigh: "层高",
  projectdifficulty: "难度系数",
  signaturetime: "底图签字时间",
  designmanager: "负责人",
  qiang: "墙设计",
  liang: "梁设计",
  louti: "楼梯设计",
  jiedian: "节点设计",
  loumian: "楼面设计",
  diaomo: "吊模设计",
  startime: "设计启动时间",
  realtime: "设计实际完成实际",
  tag: "项目状态",
  qiang: "墙设计",
  liang: "梁设计"
};
export default {
  data() {
    return {
      search: "",

      checkAll: false,
      checkedDatas: [],
      Datas: dataOptions,
      isIndeterminate: true,

      value1: "",

      value2: "",

      value3: "",

      value4: "",

      percentage: 0,

      multipleSelection: [],

      projectcode: ""
    };
  },
  mounted() {},
  computed: {
    tabless() {
      const search = this.search;
      const value1 = this.value1;
      const value2 = this.value2;
      const value3 = this.value3;
      const value4 = this.value4;

      //通过数组过滤返回需要筛选的数据
      if (search && !value1 && !value2 && !value3 && !value4) {
        //1均有输入
        return this.$store.getters.getallprojectlist.filter(
          data =>
            data.projectcode.includes(search) ||
            data.projectname.includes(search) ||
            data.designmanager.includes(search) ||
            data.deepeningdivision.includes(search) ||
            data.department.includes(search)
        );
      } else if (!search && value1 && !value2 && !value3 && !value4) {
        //2均有输入
        return this.$store.getters.getallprojectlist.filter(
          data =>
            new Date(data.receivetime) >= new Date(value1[0]) &&
            new Date(data.receivetime) <= new Date(value1[1])
        );
      } else if (!search && !value1 && value2 && !value3 && !value4) {
        //3均有输入
        return this.$store.getters.getallprojectlist.filter(
          data =>
            new Date(data.signaturetime) >= new Date(value2[0]) &&
            new Date(data.signaturetime) <= new Date(value2[1])
        );
      } else if (!search && !value1 && !value2 && value3 && !value4) {
        //4均有输入
        return this.$store.getters.getallprojectlist.filter(
          data =>
            new Date(data.startime) >= new Date(value3[0]) &&
            new Date(data.startime) <= new Date(value3[1])
        );
      } else if (!search && !value1 && !value2 && !value3 && value4) {
        //5均有输入
        return this.$store.getters.getallprojectlist.filter(
          data =>
            new Date(data.realtime) >= new Date(value4[0]) &&
            new Date(data.realtime) <= new Date(value4[1])
        );
      } else if (search && value1 && !value2 && !value3 && !value4) {
        //12均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          )
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          );
      } else if (search && !value1 && value2 && !value3 && !value4) {
        //13均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          );
      } else if (search && !value1 && !value2 && value3 && !value4) {
        //14均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          );
      } else if (search && !value1 && !value2 && !value3 && value4) {
        //15均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realime) <= new Date(value4[1])
          );
      } else if (!search && value1 && value2 && !value3 && !value4) {
        //23均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          );
      } else if (!search && value1 && !value2 && value3 && !value4) {
        //24均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          );
      } else if (!search && value1 && !value2 && !value3 && value4) {
        //25均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (!search && !value1 && value2 && value3 && !value4) {
        //34均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          );
      } else if (!search && !value1 && value2 && !value3 && value4) {
        //35均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (!search && !value1 && !value2 && value3 && value4) {
        //45均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (search && value1 && value2 && !value3 && !value4) {
        //123均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && !value2 && value3 && !value4) {
        //124均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && !value2 && !value3 && value4) {
        //125均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && !value1 && value2 && value3 && !value4) {
        //134均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && !value1 && value2 && !value3 && value4) {
        //135均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && !value1 && !value2 && value3 && value4) {
        //145均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (!search && value1 && value2 && value3 && !value4) {
        //234均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          );
      } else if (!search && value1 && value2 && !value3 && value4) {
        //235均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (!search && value1 && !value2 && value3 && value4) {
        //245均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          );
      } else if (!search && !value1 && value2 && value3 && value4) {
        //345均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (!search && value1 && value2 && value3 && value4) {
        //2345均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          );
      } else if (search && !value1 && value2 && value3 && value4) {
        //1345均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && !value2 && value3 && value4) {
        //1245均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && value2 && !value3 && value4) {
        //1235均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && value2 && value3 && !value4) {
        //1234均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else if (search && value1 && value2 && value3 && value4) {
        //12345均有输入
        return this.$store.getters.getallprojectlist
          .filter(
            data =>
              new Date(data.receivetime) >= new Date(value1[0]) &&
              new Date(data.receivetime) <= new Date(value1[1])
          )
          .filter(
            data =>
              new Date(data.signaturetime) >= new Date(value2[0]) &&
              new Date(data.signaturetime) <= new Date(value2[1])
          )
          .filter(
            data =>
              new Date(data.startime) >= new Date(value3[0]) &&
              new Date(data.startime) <= new Date(value3[1])
          )
          .filter(
            data =>
              new Date(data.realtime) >= new Date(value4[0]) &&
              new Date(data.realtime) <= new Date(value4[1])
          )
          .filter(
            data =>
              data.projectcode.includes(search) ||
              data.projectname.includes(search) ||
              data.designmanager.includes(search) ||
              data.deepeningdivision.includes(search) ||
              data.department.includes(search)
          );
      } else {
        return this.$store.getters.getallprojectlist;
      }
    }
  },
  methods: {
    handleCheckAllChange(val) {
      this.checkedDatas = val ? dataOptions : [];
      this.isIndeterminate = false;
    },
    handleCheckedCitiesChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.Datas.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.Datas.length;
    },

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

    resetDateFilter() {
      this.$refs.filterTable.clearFilter("date");
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    filterdepartment(value, row) {
      return row.department === value;
    },
    filterdate(value, row) {
      return row.date === value;
    },

    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    },

    getDate(str) {
      if (this.value1[0] !== "" && this.value1[1] !== "") {
        let da = new Date(str);
        let value1start = new Date(this.value1[0]);
        let value1end = new Date(this.value1[1]);
        if (da >= value1start && da <= value1end) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    },

    handleEdit(row) {
      sessionStorage.setItem("projectcode", row.projectcode);

      this.$store.dispatch("setprojectInfo", [row]);

      this.$router.push("/projectInformation");
    },
    expexcel() {
      if (this.multipleSelection.length > 0) {
        let filename = "数据表";
        let wb = XLSX.utils.book_new();
        let ws = XLSX.utils.json_to_sheet(
          this.$options.methods.getData(this.multipleSelection)
        );
        wb.SheetNames.push(filename);
        wb.Sheets[filename] = ws;
        const defaultCellStyle = {
          font: { name: "Verdana", sz: 13, color: "FF00FF88" },
          fill: { fgColor: { rgb: "FFFFAA00" } }
        };
        let wopts = {
          bookType: "xlsx",
          bookSST: false,
          type: "binary",
          cellStyles: true,
          defaultCellStyle: defaultCellStyle,
          showGridLines: false
        };
        let wbout = XLSX.write(wb, wopts);
        let blob = new Blob([this.$options.methods.s2ab(wbout)], {
          type: "application/octet-stream"
        });
        fs.saveAs(blob, filename + ".xlsx");
      }
    },
    s2ab(s) {
      if (typeof ArrayBuffer !== "undefined") {
        var buf = new ArrayBuffer(s.length);
        var view = new Uint8Array(buf);
        for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xff;
        return buf;
      } else {
        var buf = new Array(s.length);
        for (var i = 0; i != s.length; ++i) buf[i] = s.charCodeAt(i) & 0xff;
        return buf;
      }
    },

    getData(s) {
      let sheetdata = [];
      for (let index = 0; index < s.length; index++) {
        const element = s[index];
        let middata = {};
        for (const key in dataOptionspart) {
          if (element.hasOwnProperty(key)) {
            middata[dataOptionspart[key]] = element[key];
          }
        }
        sheetdata.push(middata);
      }
      return sheetdata;
    }
  }
};
</script>