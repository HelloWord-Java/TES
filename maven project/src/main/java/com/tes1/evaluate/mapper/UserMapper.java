package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.User;

public interface UserMapper {
    //int deleteByPrimaryKey(Integer id);

//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(User user);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
    
    
    ///
	User findUser(User user);
	List<User> Userfind(User user);
	//获取用户列表
	List<User> getUserList(@Param("page")int page,@Param("rows")int rows,@Param("filter")String filter);
	//获取列表总数
	int getUserListTotal(String filter);
	
	// 删除用户信息
	int deleteUserInfoByIds(List<Integer> list);
	int deleteByPrimaryKey(Integer ids);
   
    int addUser(User user);
    
    User findUserById(User user);
    int updateUserById(User user);
	List<User> findteachers(User users);

}