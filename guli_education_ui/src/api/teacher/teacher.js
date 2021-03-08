import request from '@/utils/request';

export default {
  /**
   * 获取讲师列表-分页
   * @param  params   页码
   */
  getTeacherListPage(params) {
    return request({
      url: 'eduService/edu_teacher/getPageTeacher',
      method: 'get',
      params: params
    })

  }


}
