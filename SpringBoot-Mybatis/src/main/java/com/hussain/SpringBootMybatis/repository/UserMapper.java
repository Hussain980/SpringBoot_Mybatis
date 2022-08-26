package com.hussain.SpringBootMybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hussain.SpringBootMybatis.entity.Users;

@Mapper
public interface UserMapper {

	@Select("select * from users")
	@Results({ @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	List<Users> findAll();

	@Insert("insert into users (first_name, last_name) values (#{firstName}, #{lastName})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int create(Users users);

	@Select("select * from users where id =#{id}")
	@Results({ @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	Users findById(Integer id);

}
