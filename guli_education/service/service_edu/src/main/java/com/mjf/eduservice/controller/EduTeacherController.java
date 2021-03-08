package com.mjf.eduservice.controller;


import com.alibaba.fastjson.JSONObject;
import com.mjf.commonutils.ResponseObject;
import com.mjf.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-12-27
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/edu_teacher")
@CrossOrigin
public class EduTeacherController {

    private EduTeacherService eduTeacherService;


    public EduTeacherController(EduTeacherService eduTeacherService) {
        this.eduTeacherService = eduTeacherService;
    }

    /**
     * 获取所有讲师
     *
     * @return List<EduTeacher>
     */
    @ApiOperation(value = "获取所有讲师集合")
    @GetMapping("/getAllTeacher")
    public ResponseObject getAllTeacher() {
        return ResponseObject.responseSuccess()
                .setData("teacherList",eduTeacherService.list(null))
                .setMessage("查询讲师成功！");
    }


    /**
     * 根据id删除讲师
     *
     * @param id 讲师id
     */
    @ApiOperation(value = "根据id逻辑删除讲师")
    @DeleteMapping("/deleteTeacherById/{id}")
    public void deleteTeacherById(@ApiParam(name = "id", value = "讲师id", required =true) @PathVariable String id) {
        eduTeacherService.removeById(id);
    }


    /**
     * 分页条件查询讲师列表
     * @param params 分页参数
     * @return 讲师列表
     */
    @ApiOperation(value = "分页查询讲师列表",consumes = "application/json")
    @GetMapping("/getPageTeacher")
    public ResponseObject getPageTeacher(@ApiParam(name = "params", value = "分页参数",required =true)@RequestParam Map<String,Object> params) {
        return eduTeacherService.getAllTeacherPage(new JSONObject(params));
    }


//    public void cookie(HttpServletRequest request, HttpServletResponse response) {
//        Cookie cookie = new Cookie("token","DWIUNACNKJZNXCUBYAUWYBUCABHSCBZJHCBHSBAYcuBUA");
//        response.addCookie(cookie);
//        request.getCookies();
//    }
}

