package com.neuedu.service.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {
        if (userInfo==null)
        {
            throw new MyException("用户信息不能为空","login");
        }
        if (userInfo.getUsername()==null||userInfo.getUsername().equals(""))
        {
            throw new MyException("用户名不能为空","login");
        }
        if (userInfo.getPassword()==null||userInfo.getPassword().equals(""))
        {throw new MyException("用户密码不能为空","login");}
        int result=userInfoMapper.exsitsUsername(userInfo.getUsername());
        if (result<1)
        {
            throw new MyException("用户不存在","login");
        }

        UserInfo userInfo1=userInfoMapper.findByUsernameAndPassword(userInfo);
        if(userInfo1==null)
        {
            throw new MyException("密码错误","login");
        }
        if (userInfo1.getRole()!=0)
        {
            throw new MyException("用户没有权限","login");
        }


        return userInfo1;
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        if(record.getUsername()==null||record.getUsername().equals("") ){//用户名为空

            throw  new MyException("用户名不能为空","register.jsp");

        }
        if(record.getPassword()==null||record.getPassword().equals("") ){//密码为空

            throw  new MyException("密码不能为空","index.jsp");

        }
        if (record.getEmail()==null||record.getEmail().equals(""))
        {
            throw new MyException("邮箱不能为空","register.jsp");
        }
        if (record.getAnswer()==null||record.getAnswer().equals(""))
        {
            throw new MyException("密保答案不能为空","register.jsp");
        }
        if (record.getQuestion()==null||record.getQuestion().equals(""))
        {
            throw new MyException("密保问腿不能为空","register.jsp");
        }
        if (record.getPhone()==null||record.getPhone().equals(""))
        {
            throw new MyException("电话不能为空","");
        }
        if (record.getRole()==null)
        {
            record.setRole(1);
        }
        String password=record.getPassword();
        if (password.length()!=32)
        {
            record.setPassword(MD5Utils.getMD5Code(password));
        }
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(record.getId());
        int result=userInfoMapper.exsitsUsername(record.getUsername());
        if (result>0&&!userInfo.getUsername().equals(record.getUsername()))
        {
            throw new MyException("用户名重复","");
        }
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        if(record.getUsername()==null||record.getUsername().equals("") ){//用户名为空

            throw  new MyException("用户名不能为空","register.jsp");

        }
        if(record.getPassword()==null||record.getPassword().equals("") ){//密码为空

            throw  new MyException("密码不能为空","index.jsp");

        }
        if (record.getEmail()==null||record.getEmail().equals(""))
        {
            throw new MyException("邮箱不能为空","register.jsp");
        }
        if (record.getAnswer()==null||record.getAnswer().equals(""))
        {
            throw new MyException("密保答案不能为空","register.jsp");
        }
        if (record.getQuestion()==null||record.getQuestion().equals(""))
        {
            throw new MyException("密保问腿不能为空","register.jsp");
        }
        if (record.getPhone()==null||record.getPhone().equals(""))
        {
            throw new MyException("电话不能为空","");
        }
        if (record.getRole()==null)
        {
            record.setRole(1);
        }
        int result=userInfoMapper.exsitsUsername(record.getUsername());
        if (result>0)
        {
            throw new MyException("用户名重复","");
        }
        result=userInfoMapper.insert(record);
        return result;
    }

}
