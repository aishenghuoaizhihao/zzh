package com.example.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 啪啪啪
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page 分页对象
     * @param state 状态
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page<User> page, @Param("state") Integer state);

    /**
     * mapper版本批量新增
     */
    public Integer inserUsers(List<User> users);

    /**
     * mapper版本批量删除
     */
    public Integer deleteUsers(List<Integer> in);

    /**
     * 批量修改
     */
    public Integer updateUsers(List<User> users);

}