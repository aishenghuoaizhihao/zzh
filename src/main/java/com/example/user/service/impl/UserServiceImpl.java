package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.exception.InserUserException;
import com.example.common.exception.ModifyUserException;
import com.example.common.exception.RemoveUserException;
import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.BaseService;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Description:zzh
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private BaseService baseService;



    @Override
    public void add(User user) throws InserUserException {
        Integer count = userMapper.insert(user);
        if(count==null){
            throw new InserUserException("添加用户失败!");
        }
    }

    @Override
    public void removeUser(Integer id) throws RemoveUserException {
        Integer count = userMapper.deleteById(id);
        if(count==null){
            throw new RemoveUserException("移除用户失败!");
        }

    }

    @Override
    public void modifyUser(User user) throws ModifyUserException {
        Integer count=userMapper.updateById(user);
        if(count==null){
            throw new ModifyUserException("修改用户失败！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        return userMapper.selectList(userQueryWrapper.eq("id","5"));
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<User> findByPage(Page<User> page, Wrapper<User> queryWrapper) {
        Page<User> userPage = (Page<User>) userMapper.selectPage(page, queryWrapper);
        return userPage;
    }



    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public IPage<User> selectUserPage(Page<User> page, Integer state) {

        // page.setOptimizeCountSql(false);
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, state);
    }

    @Override
    public int removes(List<Integer> listId) {
        Integer count=userMapper.deleteBatchIds(listId);
        return count;
    }

    @Override
    public boolean saveUsers() {
        return true;
    }

    @Override
    public Integer inserUsers(List<User> users) {
        return userMapper.inserUsers(users);
    }

    @Override
    public Integer removeUsers(List<Integer> in) {
        return userMapper.deleteUsers(in);
    }
}
