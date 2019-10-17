package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.mapper.UserMapper;

@Service
public class UserService {
@Autowired
private UserMapper userMapper;
	public User findUser(User user) {
		return userMapper.findUser(user);
	}
	public List<User> Userfind(User user){
		return userMapper.Userfind(user);
}
	/**
	 * 获取用户列表
	 * @param page
	 * @param rows
	 * @param filter
	 * @return
	 */
	public List<User> getUserList(int page, int rows, String filter){
		return userMapper.getUserList(page,rows,filter);
	}
	
	/**
	 * 获取用户列表总数
	 * @param filter
	 * @return
	 */
	public int getUserListTotal(String filter){
		return userMapper.getUserListTotal(filter);
	}
	/**
	 * 批量删除用户
	 * @param id
	 * @return
	 */
	public int removeUserInfoByIds(List<Integer> list) {  
        return userMapper.deleteUserInfoByIds(list);  
    } 
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer ids) {  
        return userMapper.deleteByPrimaryKey(ids);  
    }

	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	public User findUserById(User user) {
		return userMapper.findUserById(user);
	}
	public int updateUserById(User user) {
		return userMapper.updateUserById(user);
	}
	public List<User> findteachers(User users) {
		return userMapper.findteachers(users);
	} 
}
