package com.qiuch.dubbo.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import com.qiuch.dubbo.dao.UserInfoMapper;
import com.qiuch.dubbo.pojo.UserInfo;
import com.qiuch.dubbo.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUser() {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1l);
        if (userInfo == null) {
            addUser();
            userInfo = userInfoMapper.selectByPrimaryKey(1l);
        }
        return userInfo;
    }

    @Override
    public void addUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(10);
        userInfo.setCreateTime(new Date());
        userInfo.setGender("male");
        userInfo.setName("test");
        userInfoMapper.insertSelective(userInfo);
    }

}
