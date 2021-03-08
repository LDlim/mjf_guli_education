package com.mjf.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

/**
 * mybatis-plus配置
 * @author LDlim
 * @date 2020/12/26 15:56
 */
@Configuration
@MapperScan("com.mjf.eduservice.mapper")
public class MybatisPlusConfig {

    /**
     * mybatis-plus 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor  optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


    /**
     * mybatis-plus 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInnerInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
