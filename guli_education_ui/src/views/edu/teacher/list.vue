<template>
  <div class="app-container">
    <el-form :inline="true" :model="searchInfo" class="demo-form-inline">
      <el-form-item label="讲师姓名">
        <el-input v-model="searchInfo.teacher_name" placeholder="讲师姓名"></el-input>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-col :span="11">
          <el-form-item prop="date1">
            <el-date-picker type="date" placeholder="选择开始日期" v-model="searchInfo.start_date"
                            style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-form-item prop="date2">
            <el-date-picker type="date" placeholder="选择结束日期" v-model="searchInfo.end_date"
                            style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="姓名" width="100" align="center">
        <template slot-scope="scope">
          <el-tag size="medium">{{ scope.row.name }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="头衔" width="100">
        <template slot-scope="scope">
          {{ scope.row.level===1?'高级讲师':'首席讲师' }}
        </template>
      </el-table-column>

      <el-table-column label="讲师资历" align="center">
        <template slot-scope="scope">
          {{scope.row.career}}
        </template>
      </el-table-column>
      <el-table-column label="头像" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.avatar" style="height: 40px;width:40px">
        </template>
      </el-table-column>

      <el-table-column label="添加时间" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.gmtCreate }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="sort" label="排序" width="60"/>

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block" style="margin-left: 640px;">
      <!--      <span class="demonstration">完整功能</span>-->
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                     :current-page="page.current" :page-sizes="[5, 10, 15, 20]" :page-size="page.pageSize"
                     layout="total, sizes, prev, pager, next, jumper" :total="page.total">
      </el-pagination>
    </div>
  </div>

</template>
<script>
    import teacher from '@/api/teacher/teacher'

    export default {
        name: "list",
        data() {
            return {
                tableData: [],
                page: {
                    current: 1,
                    pageSize: 10
                },
                searchInfo: {}
            }
        },
        created() {
            this.getTeacherListPage(1)
        },
        methods: {
            /**
             * 获取讲师列表-分页+模糊查询
             * @param pageNum
             */
            getTeacherListPage(pageNum) {
                let params = {};
                params = this.searchInfo;
                params.pageNum = pageNum;
                params.pageSize = this.page.pageSize;
                teacher.getTeacherListPage(params).then(result => {
                    this.tableData = result.data.items
                    this.page.total = result.data.total
                    this.page.current = result.data.current
                })
            },
            /**
             * 分页参数-单页数量改变事件-val=单页数量
             */
            handleSizeChange(val) {
                this.page.pageSize = val;
                this.getTeacherListPage(1)
            },
            /**
             * 分页参数-页码改变事件-val=页码
             */
            handleCurrentChange(val) {
                this.getTeacherListPage(val)
            },
        }

    }
</script>

<style scoped>

</style>
