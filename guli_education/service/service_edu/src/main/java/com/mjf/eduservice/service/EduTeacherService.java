package com.mjf.eduservice.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mjf.commonutils.ResponseObject;
import com.mjf.eduservice.entity.EduTeacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-12-27
 */
public interface EduTeacherService extends IService<EduTeacher> {



    //    IPage<EduTeacher> selectTeacherPage(Page<EduTeacher> page);
    /**
     * 分页条件查询讲师列表
     * @param params 分页参数+查询条件
     * @return ResponseObject
     */
    ResponseObject getAllTeacherPage(JSONObject params);
}
