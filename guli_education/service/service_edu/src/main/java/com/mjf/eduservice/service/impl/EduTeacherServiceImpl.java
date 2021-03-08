package com.mjf.eduservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mjf.commonutils.ResponseObject;
import com.mjf.eduservice.entity.EduTeacher;
import com.mjf.eduservice.mapper.EduTeacherMapper;
import com.mjf.eduservice.service.EduTeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-12-27
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    private EduTeacherMapper eduTeacherMapper;

    public EduTeacherServiceImpl(EduTeacherMapper eduTeacherMapper) {
        this.eduTeacherMapper = eduTeacherMapper;
    }

    /**
     * 分页条件查询讲师列表
     * @param params 分页参数+查询条件
     * @return ResponseObject
     */
    @Override
    public ResponseObject getAllTeacherPage(JSONObject params) {
        Integer pageNum = params.getInteger("pageNum");
        Integer pageSize = params.getInteger("pageSize");
        Page<EduTeacher> page = new Page<>(pageNum,pageSize);
//        QueryWrapper<JSONObject>
        eduTeacherMapper.selectPage(page,null);
        return ResponseObject.responseSuccess()
                .setData("items", page.getRecords())
                .setData("total",page.getTotal())
                .setData("current",page.getCurrent())
                .setMessage("分页查询成功!");
    }


}
