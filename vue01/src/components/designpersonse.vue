<template>
  <div>
    <el-table ref="multipleTable" :data="this.$store.getters.getdesignpersonselect">
      <el-table-column prop="projectsource" label="订单来源" width="80" align="center"></el-table-column>
      <el-table-column prop="projectname" label="项目名称" width="400" align="center"></el-table-column>
      <el-table-column prop="projectnumber" label="栋号" width="150" align="center"></el-table-column>
      <el-table-column prop="projectcode" label="项目代号" width="200" align="center"></el-table-column>
      <el-table-column prop="receivetime" label="图纸接收时间" align="center"></el-table-column>
      <el-table-column prop="estimatetime" label="预计进场时间" align="center"></el-table-column>
      <el-table-column prop="deepeningdivision" label="深化师" align="center"></el-table-column>
    </el-table>

    <div style="margin: 15px 0;"></div>

    <el-form :model="qiang[0]" :rules="rulesqiang" ref="qiang[0]">
      <el-table
        ref="multipleTable"
        :data="qiang"
        style="font-size: 9px;"
        v-if="this.$store.getters.getdesigns.indexOf('qiang')>-1"
      >
        <el-table-column label="墙" align="center">
          <el-table-column prop="qiangstandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandardn">
                <el-input v-model="scope.row.qiangstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangstandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandarda">
                <el-input v-model="scope.row.qiangstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangstandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandardwithaccn">
                <el-input v-model="scope.row.qiangstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangstandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandardwithacca">
                <el-input v-model="scope.row.qiangstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangstandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandardwithaccholen">
                <el-input v-model="scope.row.qiangstandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangstandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangstandardwithaccholea">
                <el-input v-model="scope.row.qiangstandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangnonstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangnonstandardn">
                <el-input v-model="scope.row.qiangnonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangnonstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangnonstandarda">
                <el-input v-model="scope.row.qiangnonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="qiangnonstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangnonstandardwithaccn">
                <el-input v-model="scope.row.qiangnonstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangnonstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangnonstandardwithacca">
                <el-input v-model="scope.row.qiangnonstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangvarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangvarlayernonstandardn">
                <el-input v-model="scope.row.qiangvarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="qiangvarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="qiangvarlayernonstandarda">
                <el-input v-model="scope.row.qiangvarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="qiangvarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangvarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.qiangvarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="qiangvarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangvarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.qiangvarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangalbackstandardn"
            label="铝背楞标准件数量"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangalbackstandardn">
                <el-input v-model="scope.row.qiangalbackstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangalbackstandardl"
            label="铝背楞标准件长度"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangalbackstandardl">
                <el-input v-model="scope.row.qiangalbackstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangalbacknonstandardn"
            label="铝背楞非标件数量"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangalbacknonstandardn">
                <el-input v-model="scope.row.qiangalbacknonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangalbacknonstandardl"
            label="铝背楞非标件长度"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangalbacknonstandardl">
                <el-input v-model="scope.row.qiangalbacknonstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangironbacknonstandardn"
            label="铁背楞数量"
            v-if="this.$store.getters.getsyst==='铁背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangironbacknonstandardn">
                <el-input v-model="scope.row.qiangironbacknonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="qiangironbacknonstandardl"
            label="铁背楞长度"
            v-if="this.$store.getters.getsyst==='铁背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="qiangironbacknonstandardl">
                <el-input v-model="scope.row.qiangironbacknonstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="liang[0]" :rules="rulesliang" ref="liang[0]">
      <el-table
        ref="multipleTable"
        :data="liang"
        v-if="this.$store.getters.getdesigns.indexOf('liang')>-1"
        style="font-size: 9px;"
      >
        <el-table-column label="梁" align="center">
          <el-table-column prop="liangstandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandardn">
                <el-input v-model="scope.row.liangstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangstandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandarda">
                <el-input v-model="scope.row.liangstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangstandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandardwithaccn">
                <el-input v-model="scope.row.liangstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangstandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandardwithacca">
                <el-input v-model="scope.row.liangstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangstandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandardwithaccholen">
                <el-input v-model="scope.row.liangstandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangstandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangstandardwithaccholea">
                <el-input v-model="scope.row.liangstandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangnonstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangnonstandardn">
                <el-input v-model="scope.row.liangnonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangnonstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangnonstandarda">
                <el-input v-model="scope.row.liangnonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="liangnonstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangnonstandardwithaccn">
                <el-input v-model="scope.row.liangnonstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangnonstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangnonstandardwithacca">
                <el-input v-model="scope.row.liangnonstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangvarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangvarlayernonstandardn">
                <el-input v-model="scope.row.liangvarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="liangvarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="liangvarlayernonstandarda">
                <el-input v-model="scope.row.liangvarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="liangvarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="liangvarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.liangvarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="liangvarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="liangvarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.liangvarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="loumian[0]" :rules="rulesloumian" ref="loumian[0]">
      <el-table
        ref="multipleTable"
        :data="loumian"
        v-if="this.$store.getters.getdesigns.indexOf('loumian')>-1"
        style="font-size: 9px;"
      >
        <el-table-column label="楼面" align="center">
          <el-table-column prop="loumianstandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandardn">
                <el-input v-model="scope.row.loumianstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianstandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandarda">
                <el-input v-model="scope.row.loumianstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianstandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandardwithaccn">
                <el-input v-model="scope.row.loumianstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianstandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandardwithacca">
                <el-input v-model="scope.row.loumianstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianstandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandardwithaccholen">
                <el-input v-model="scope.row.loumianstandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianstandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianstandardwithaccholea">
                <el-input v-model="scope.row.loumianstandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumiannonstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumiannonstandardn">
                <el-input v-model="scope.row.loumiannonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumiannonstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumiannonstandarda">
                <el-input v-model="scope.row.loumiannonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="loumiannonstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumiannonstandardwithaccn">
                <el-input v-model="scope.row.loumiannonstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumiannonstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumiannonstandardwithacca">
                <el-input v-model="scope.row.loumiannonstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianvarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianvarlayernonstandardn">
                <el-input v-model="scope.row.loumianvarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loumianvarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loumianvarlayernonstandarda">
                <el-input v-model="scope.row.loumianvarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="loumianvarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loumianvarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.loumianvarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="loumianvarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loumianvarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.loumianvarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="jiedian[0]" :rules="rulesjiedian" ref="jiedian[0]">
      <el-table
        ref="multipleTable"
        :data="jiedian"
        v-if="this.$store.getters.getdesigns.indexOf('jiedian')>-1"
        style="font-size: 9px;"
      >
        <el-table-column label="节点" align="center">
          <el-table-column prop="jiedianstandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandardn">
                <el-input v-model="scope.row.jiedianstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianstandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandarda">
                <el-input v-model="scope.row.jiedianstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianstandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandardwithaccn">
                <el-input v-model="scope.row.jiedianstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianstandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandardwithacca">
                <el-input v-model="scope.row.jiedianstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianstandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandardwithaccholen">
                <el-input v-model="scope.row.jiedianstandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianstandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianstandardwithaccholea">
                <el-input v-model="scope.row.jiedianstandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiediannonstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiediannonstandardn">
                <el-input v-model="scope.row.jiediannonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiediannonstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiediannonstandarda">
                <el-input v-model="scope.row.jiediannonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="jiediannonstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiediannonstandardwithaccn">
                <el-input v-model="scope.row.jiediannonstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiediannonstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiediannonstandardwithacca">
                <el-input v-model="scope.row.jiediannonstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianvarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianvarlayernonstandardn">
                <el-input v-model="scope.row.jiedianvarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="jiedianvarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="jiedianvarlayernonstandarda">
                <el-input v-model="scope.row.jiedianvarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="jiedianvarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="jiedianvarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.jiedianvarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="jiedianvarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="jiedianvarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.jiedianvarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="louti[0]" :rules="ruleslouti" ref="louti[0]">
      <el-table
        ref="multipleTable"
        :data="louti"
        v-if="this.$store.getters.getdesigns.indexOf('louti')>-1"
        style="font-size: 9px;"
      >
        <el-table-column label="楼梯" align="center">
          <el-table-column prop="loutistandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandardn">
                <el-input v-model="scope.row.loutistandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutistandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandarda">
                <el-input v-model="scope.row.loutistandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutistandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandardwithaccn">
                <el-input v-model="scope.row.loutistandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutistandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandardwithacca">
                <el-input v-model="scope.row.loutistandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutistandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandardwithaccholen">
                <el-input v-model="scope.row.loutistandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutistandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutistandardwithaccholea">
                <el-input v-model="scope.row.loutistandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutinonstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutinonstandardn">
                <el-input v-model="scope.row.loutinonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutinonstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutinonstandarda">
                <el-input v-model="scope.row.loutinonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="loutinonstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutinonstandardwithaccn">
                <el-input v-model="scope.row.loutinonstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutinonstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutinonstandardwithacca">
                <el-input v-model="scope.row.loutinonstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutivarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutivarlayernonstandardn">
                <el-input v-model="scope.row.loutivarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="loutivarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="loutivarlayernonstandarda">
                <el-input v-model="scope.row.loutivarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="loutivarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutivarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.loutivarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="loutivarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutivarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.loutivarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutialbackstandardn"
            label="铝背楞标准件数量"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutialbackstandardn">
                <el-input v-model="scope.row.loutialbackstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutialbackstandardl"
            label="铝背楞标准件长度"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutialbackstandardl">
                <el-input v-model="scope.row.loutialbackstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutialbacknonstandardn"
            label="铝背楞非标件数量"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutialbacknonstandardn">
                <el-input v-model="scope.row.loutialbacknonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutialbacknonstandardl"
            label="铝背楞非标件长度"
            v-if="this.$store.getters.getsyst==='铝背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutialbacknonstandardl">
                <el-input v-model="scope.row.loutialbacknonstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutiironbacknonstandardn"
            label="铁背楞数量"
            v-if="this.$store.getters.getsyst==='铁背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutiironbacknonstandardn">
                <el-input v-model="scope.row.loutiironbacknonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column
            prop="loutiironbacknonstandardl"
            label="铁背楞长度"
            v-if="this.$store.getters.getsyst==='铁背楞'"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="loutiironbacknonstandardl">
                <el-input v-model="scope.row.loutiironbacknonstandardl" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>

    <el-form :model="diaomo[0]" :rules="rulesdiaomo" ref="diaomo[0]">
      <el-table
        ref="multipleTable"
        :data="diaomo"
        v-if="this.$store.getters.getdesigns.indexOf('diaomo')>-1"
        style="font-size: 9px;"
      >
        <el-table-column label="吊模" align="center">
          <el-table-column prop="diaomostandardn" label="标准件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandardn">
                <el-input v-model="scope.row.diaomostandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomostandarda" label="标准件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandarda">
                <el-input v-model="scope.row.diaomostandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomostandardwithaccn" label="标准件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandardwithaccn">
                <el-input v-model="scope.row.diaomostandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomostandardwithacca" label="标准件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandardwithacca">
                <el-input v-model="scope.row.diaomostandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomostandardwithaccholen" label="标准件带配件及穿墙孔数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandardwithaccholen">
                <el-input v-model="scope.row.diaomostandardwithaccholen" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomostandardwithaccholea" label="标准件带配件及穿墙孔面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomostandardwithaccholea">
                <el-input v-model="scope.row.diaomostandardwithaccholea" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomononstandardn" label="非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomononstandardn">
                <el-input v-model="scope.row.diaomononstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomononstandarda" label="非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomononstandarda">
                <el-input v-model="scope.row.diaomononstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="diaomononstandardwithaccn" label="非标件带配件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomononstandardwithaccn">
                <el-input v-model="scope.row.diaomononstandardwithaccn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomononstandardwithacca" label="非标件带配件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomononstandardwithacca">
                <el-input v-model="scope.row.diaomononstandardwithacca" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomovarlayernonstandardn" label="变层非标件数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomovarlayernonstandardn">
                <el-input v-model="scope.row.diaomovarlayernonstandardn" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column prop="diaomovarlayernonstandarda" label="变层非标件面积" align="center">
            <template slot-scope="scope">
              <el-form-item prop="diaomovarlayernonstandarda">
                <el-input v-model="scope.row.diaomovarlayernonstandarda" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="diaomovarlayernonstandardwithaccn"
            label="变层非标件带配件数量"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="diaomovarlayernonstandardwithaccn">
                <el-input
                  v-model="scope.row.diaomovarlayernonstandardwithaccn"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>
          <el-table-column
            prop="diaomovarlayernonstandardwithacca"
            label="变层非标件带配件面积"
            align="center"
          >
            <template slot-scope="scope">
              <el-form-item prop="diaomovarlayernonstandardwithacca">
                <el-input
                  v-model="scope.row.diaomovarlayernonstandardwithacca"
                  style="font-size: 8px;"
                ></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="squaretuben" label="方管数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="squaretuben">
                <el-input v-model="scope.row.squaretuben" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="squaretubel" label="方管长度" align="center">
            <template slot-scope="scope">
              <el-form-item prop="squaretubel">
                <el-input v-model="scope.row.squaretubel" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>

          <el-table-column prop="ironbox" label="铁盒子数量" align="center">
            <template slot-scope="scope">
              <el-form-item prop="ironbox">
                <el-input v-model="scope.row.ironbox" style="font-size: 8px;"></el-input>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-form>

    <div style="margin: 15px 0;"></div>
    <div>
      <el-button type="primary" @click="resetForm" style="margin-left: 45%;">重置</el-button>
      <el-button type="primary" @click="handleEdit" style="position: relative;margin-left: 1%;">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formNames: [
        "qiang[0]",
        "liang[0]",
        "loumian[0]",
        "jiedian[0]",
        "louti[0]",
        "diaomo[0]"
      ],

      qiang: [
        {
          qiangstandardn: "",
          qiangstandarda: "",
          qiangstandardwithaccn: "",
          qiangstandardwithacca: "",
          qiangstandardwithaccholen: "",
          qiangstandardwithaccholea: "",

          qiangnonstandardn: "",
          qiangnonstandarda: "",
          qiangnonstandardwithaccn: "",
          qiangnonstandardwithacca: "",
          qiangvarlayernonstandardn: "",
          qiangvarlayernonstandarda: "",

          qiangvarlayernonstandardwithaccn: "",
          qiangvarlayernonstandardwithacca: "",

          qiangalbackstandardn: "",
          qiangalbackstandardl: "",

          qiangalbacknonstandardn: "",
          qiangalbacknonstandardl: "",

          qiangironbacknonstandardn: "",
          qiangironbacknonstandardl: ""
        }
      ],
      liang: [
        {
          liangstandardn: "",
          liangstandarda: "",
          liangstandardwithaccn: "",
          liangstandardwithacca: "",
          liangstandardwithaccholen: "",
          liangstandardwithaccholea: "",

          liangnonstandardn: "",
          liangnonstandarda: "",
          liangnonstandardwithaccn: "",
          liangnonstandardwithacca: "",
          liangvarlayernonstandardn: "",
          liangvarlayernonstandarda: "",

          liangvarlayernonstandardwithaccn: "",
          liangvarlayernonstandardwithacca: ""
        }
      ],
      loumian: [
        {
          loumianstandardn: "",
          loumianstandarda: "",
          loumianstandardwithaccn: "",
          loumianstandardwithacca: "",
          loumianstandardwithaccholen: "",
          loumianstandardwithaccholea: "",

          loumiannonstandardn: "",
          loumiannonstandarda: "",
          loumiannonstandardwithaccn: "",
          loumiannonstandardwithacca: "",
          loumianvarlayernonstandardn: "",
          loumianvarlayernonstandarda: "",

          loumianvarlayernonstandardwithaccn: "",
          loumianvarlayernonstandardwithacca: ""
        }
      ],
      jiedian: [
        {
          jiedianstandardn: "",
          jiedianstandarda: "",
          jiedianstandardwithaccn: "",
          jiedianstandardwithacca: "",
          jiedianstandardwithaccholen: "",
          jiedianstandardwithaccholea: "",

          jiediannonstandardn: "",
          jiediannonstandarda: "",
          jiediannonstandardwithaccn: "",
          jiediannonstandardwithacca: "",
          jiedianvarlayernonstandardn: "",
          jiedianvarlayernonstandarda: "",

          jiedianvarlayernonstandardwithaccn: "",
          jiedianvarlayernonstandardwithacca: ""
        }
      ],
      diaomo: [
        {
          diaomostandardn: "",
          diaomostandarda: "",
          diaomostandardwithaccn: "",
          diaomostandardwithacca: "",
          diaomostandardwithaccholen: "",
          diaomostandardwithaccholea: "",

          diaomononstandardn: "",
          diaomononstandarda: "",
          diaomononstandardwithaccn: "",
          diaomononstandardwithacca: "",
          diaomovarlayernonstandardn: "",
          diaomovarlayernonstandarda: "",

          diaomovarlayernonstandardwithaccn: "",
          diaomovarlayernonstandardwithacca: "",

          anglesteeln: "",
          anglesteell: "",

          squaretuben: "",
          squaretubel: "",

          ironbox: ""
        }
      ],
      louti: [
        {
          loutistandardn: "",
          loutistandarda: "",
          loutistandardwithaccn: "",
          loutistandardwithacca: "",
          loutistandardwithaccholen: "",
          loutistandardwithaccholea: "",

          loutinonstandardn: "",
          loutinonstandarda: "",
          loutinonstandardwithaccn: "",
          loutinonstandardwithacca: "",
          loutivarlayernonstandardn: "",
          loutivarlayernonstandarda: "",

          loutivarlayernonstandardwithaccn: "",
          loutivarlayernonstandardwithacca: "",

          loutialbackstandardn: "",
          loutialbackstandardl: "",

          loutialbacknonstandardn: "",
          loutialbacknonstandardl: "",

          loutiironbacknonstandardn: "",
          loutiironbacknonstandardl: ""
        }
      ],
      tablesr1: [],

      multipleSelection: [],
      rulesqiang: {
        qiangstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangstandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangstandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangnonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangnonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangnonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangnonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        qiangvarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangvarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        qiangvarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangvarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbackstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbackstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbacknonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangalbacknonstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangironbacknonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        qiangironbacknonstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },

      rulesliang: {
        liangstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangstandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangstandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        liangnonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangnonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangnonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangnonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        liangvarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangvarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        liangvarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        liangvarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },

      rulesjiedian: {
        jiedianstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianstandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianstandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        jiediannonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiediannonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiediannonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiediannonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        jiedianvarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianvarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        jiedianvarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        jiedianvarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },

      ruleslouti: {
        loutistandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutistandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutistandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutistandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutistandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutistandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loutinonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutinonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutinonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutinonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loutivarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutivarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loutivarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutivarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbackstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbackstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbacknonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutialbacknonstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutiironbacknonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loutiironbacknonstandardl: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      },

      rulesdiaomo: {
        diaomostandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomostandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomostandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomostandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomostandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomostandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomononstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomononstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomononstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomononstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        diaomovarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomovarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomovarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        diaomovarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        anglesteeln: [{ required: true, message: "输入数据", trigger: "blur" }],
        anglesteell: [{ required: true, message: "输入数据", trigger: "blur" }],
        squaretuben: [{ required: true, message: "输入数据", trigger: "blur" }],
        squaretubel: [{ required: true, message: "输入数据", trigger: "blur" }],
        ironbox: [{ required: true, message: "输入数据", trigger: "blur" }]
      },

      rulesloumian: {
        loumianstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianstandardwithaccholen: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianstandardwithaccholea: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loumiannonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumiannonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumiannonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumiannonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loumianvarlayernonstandardn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianvarlayernonstandarda: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],

        loumianvarlayernonstandardwithaccn: [
          { required: true, message: "输入数据", trigger: "blur" }
        ],
        loumianvarlayernonstandardwithacca: [
          { required: true, message: "输入数据", trigger: "blur" }
        ]
      }
    };
  },

  methods: {
    handleEdit() {
      var re = false;

      if (this.$store.getters.getdesignpersonselect.length > 0) {
        if (this.$store.getters.getdesigns.indexOf("qiang") > -1) {
          this.$refs[this.formNames[0]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              return false;
            }
          });
        }
        if (this.$store.getters.getdesigns.indexOf("liang") > -1) {
          this.$refs[this.formNames[1]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              re = false;
              return false;
            }
          });
        }
        if (this.$store.getters.getdesigns.indexOf("loumian") > -1) {
          this.$refs[this.formNames[2]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              re = false;
              return false;
            }
          });
        }
        if (this.$store.getters.getdesigns.indexOf("jiedian") > -1) {
          this.$refs[this.formNames[3]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              re = false;
              return false;
            }
          });
        }
        if (this.$store.getters.getdesigns.indexOf("louti") > -1) {
          this.$refs[this.formNames[4]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              re = false;
              return false;
            }
          });
        }
        if (this.$store.getters.getdesigns.indexOf("diaomo") > -1) {
          this.$refs[this.formNames[5]].validate(valid => {
            if (valid) {
              re = true;
            } else {
              re = false;
              return false;
            }
          });
        }

        if (re) {
          var projectdb = [];
          var pe = this.$store.getters.getdesignpersonselect;
          for (let index = 0; index < pe.length; index++) {
            var regm = {};

            var qiang = JSON.parse(JSON.stringify(this.qiang[0]));
            var liang = JSON.parse(JSON.stringify(this.liang[0]));
            var jiedian = JSON.parse(JSON.stringify(this.jiedian[0]));
            var loumian = JSON.parse(JSON.stringify(this.loumian[0]));
            var louti = JSON.parse(JSON.stringify(this.louti[0]));
            var diaomo = JSON.parse(JSON.stringify(this.diaomo[0]));

            for (const key in qiang) {
              regm[key] = qiang[key];
            }
            for (const key in liang) {
              regm[key] = liang[key];
            }

            for (const key in loumian) {
              regm[key] = loumian[key];
            }
            for (const key in jiedian) {
              regm[key] = jiedian[key];
            }

            for (const key in louti) {
              regm[key] = louti[key];
            }
            for (const key in diaomo) {
              regm[key] = diaomo[key];
            }

            regm["projectcode"] = pe[index]["projectcode"];

            projectdb.push(regm);
          }

          var regions = "";

          for (
            let index = 0;
            index < this.$store.getters.getdesigns.length;
            index++
          ) {
            regions += this.$store.getters.getdesigns[index];
            if (index < this.$store.getters.getdesigns.length - 1) {
              regions += "-";
            }
          }

          var regdb = [];
          regdb.push(projectdb);
          regdb.push(regions);

          this.$store.dispatch("setregiondb", regdb);
          this.$store.dispatch("setdesignpersonselect", []);
        }
      } else {
        this.$message({
          message: "选择项目",
          type: "warning"
        });
      }
    },
    resetForm() {
      for (const key in this.qiang[0]) {
        this.qiang[0][key] = "";
      }
      for (const key in this.liang[0]) {
        this.liang[0][key] = "";
      }
      for (const key in this.loumian[0]) {
        this.loumian[0][key] = "";
      }
      for (const key in this.jiedian[0]) {
        this.jiedian[0][key] = "";
      }
      for (const key in this.louti[0]) {
        this.louti[0][key] = "";
      }
      for (const key in this.diaomo[0]) {
        this.diaomo[0][key] = "";
      }
    }
  }
};
</script>