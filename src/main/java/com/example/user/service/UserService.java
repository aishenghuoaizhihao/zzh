package com.example.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.exception.InserUserException;
import com.example.common.exception.ModifyUserException;
import com.example.common.exception.RemoveUserException;
import com.example.user.entity.User;

import org.springframework.mail.MailAuthenticationException;

import java.util.List;

/**
 * Description
 */
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @throws InserUserException
     */
    public void add(User user) throws InserUserException;

    /**
     * 移除用户
     * @param id
     * @throws RemoveUserException
     */
    public void removeUser(Integer id) throws RemoveUserException;


    /**
     * 修改用户
     * @param user
     * @throws MailAuthenticationException
     */
    public void modifyUser(User user) throws MailAuthenticationException, ModifyUserException;


    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 分页
     * @param page
     * @param queryWrapper
     * @return
     */
    public Page<User> findByPage(Page<User> page, Wrapper<User> queryWrapper);


    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示

     * </p>
     *
     * @param page 分页对象
     * @param state 状态
     * @return 分页对象
     */
    IPage<User> selectUserPage(Page<User> page, Integer state);

    /**
     * 批量删除
     * @return
     */
    public int removes(List<Integer> listId);

    /**
     * 批量添加
     * @return
     */
    public boolean saveUsers();


    /**
     * mapper版本批量新增
     */
    public Integer inserUsers(List<User> users);

    /**
     * mapper版本批量删除
     */
    public Integer removeUsers(List<Integer> in);




}
