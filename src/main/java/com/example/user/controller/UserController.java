package com.example.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.constant.ResponseStatusConstant;
import com.example.common.exception.InserUserException;
import com.example.common.exception.ModifyUserException;
import com.example.common.exception.RemoveUserException;
import com.example.common.utils.ResponseResult;
import com.example.user.entity.User;
import com.example.user.service.BaseService;
import com.example.user.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private BaseService baseService;

    @GetMapping("/add")
    @ResponseBody
    public ResponseResult add(User user){
        //假数据
        user.setId(1008611L);
        user.setAge(18);
        user.setEmail("599293216@qq.com");
        user.setName("zzh");
        ResponseResult responseResult=new ResponseResult();
        try {
            userService.add(user);
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
        } catch (InserUserException e) {
            //e.printStackTrace();
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            responseResult.setMessage(e.getMessage());
        }
        return responseResult;
    }

    @GetMapping("/remove")
    @ResponseBody
    public ResponseResult remove(Integer id){
        ResponseResult responseResult = new ResponseResult();
        try {
            userService.removeUser(id);
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
        } catch (RemoveUserException e) {
            //e.printStackTrace();
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            responseResult.setMessage(e.getMessage());
        }
        return responseResult;
    }

    @GetMapping("/modify")
    @ResponseBody
    public ResponseResult modify(User user){
        ResponseResult responseResult = new ResponseResult();
        //假数据
        user.setId(1008611L);
        user.setAge(18);
        user.setEmail("599293216@qq.com");
        user.setName("wx");
        try {
            userService.modifyUser(user);
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
        } catch (ModifyUserException e) {
            //e.printStackTrace();
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            responseResult.setMessage(e.getMessage());
        }catch (Exception e2) {
            //e2.printStackTrace();
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            responseResult.setMessage(e2.getMessage());
        }
        return responseResult;

    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResponseResult findAll(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(userService.findAll());
        return responseResult;
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ResponseResult findByPage(){
        ResponseResult responseResult = new ResponseResult();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>();
        page.setSize(3);//每页条


        IPage<User> userIPage = userService.findByPage(
                new Page(1,1),
                new QueryWrapper<User>()
        );
        System.out.println(userIPage);
        responseResult.setData(userIPage);
        return responseResult;
    }

    @GetMapping("/page")
    @ResponseBody
    public ResponseResult selectUserPage() {

        ResponseResult responseResult = new ResponseResult();
        Page<User> userPage = new Page<>();
        userPage.setSize(5);//每页条
        IPage<User> userIPage = userService.selectUserPage(userPage, 1);
        List<User> records = userIPage.getRecords();
        System.out.println("------->"+records);
        for (User user:records) {
            System.out.println("--->>>>>"+user);
        }
        responseResult.setData(records);
        return responseResult;
    }


    @GetMapping("/removes")
    @ResponseBody
    public ResponseResult removes() {

        ResponseResult responseResult = new ResponseResult();
        List<Integer> listId = new ArrayList<>();
        listId.add(3);
        listId.add(4);
        listId.add(5);
        int removes = userService.removes(listId);

        responseResult.setData(removes);
        return responseResult;

    }


    @Deprecated
    @GetMapping("/saves")
    public ResponseResult saves(){
        ResponseResult responseResult = new ResponseResult();
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("张志豪");
        user.setEmail("599293216@qq.com");
        user.setAge(200);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("三金");
        user2.setEmail("599293216@qq.com");
        user2.setAge(100);

        users.add(user);
        users.add(user2);
        baseService.saveBatch(users);
        return responseResult;
    }


    @GetMapping("/saveUsers")
    @ResponseBody
    public ResponseResult saveUsers(){
        ResponseResult responseResult = new ResponseResult();
        Integer integer = userService.inserUsers(Arrays.asList(new User(6L,"张三", 12, "2230821943@qq.com"), new User(7L,"王五", 14, "123456789@xinlang.com"), new User(8L,"李四", 15, "789456123@weibo.com")));
        responseResult.setData(integer);
        return responseResult;
    }

    @GetMapping("/removeUsers")
    @ResponseBody
    public ResponseResult removeUsers(){
        ResponseResult responseResult = new ResponseResult();
        List<Integer> list = Arrays.asList(5, 6, 7);
        Integer integer = userService.removeUsers(list);
        responseResult.setData(list);
        return responseResult;
    }
}
