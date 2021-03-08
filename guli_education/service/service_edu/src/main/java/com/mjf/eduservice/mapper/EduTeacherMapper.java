package com.mjf.eduservice.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mjf.eduservice.entity.EduTeacher;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-12-27
 */
@Repository
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {
    JSONObject getAllTeacher();
}
