package com.muscle.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.muscle.repository.entity.PersonalEntity;

@Repository
@Mapper
public interface PersonalMapper {
	@Select("select count(id) from mslmgt.personal")
	int selectCount();

	@Select("select max(id) from mslmgt.personal")
	int selectMaxid();

	@Select("select * from mslmgt.personal where id = #{id} order by id")
	PersonalEntity selectById(@Param("id") Integer id);

	@Select("select * from mslmgt.personal where name = #{name} order by id")
	List<PersonalEntity> selectByName(@Param("name") String name);

	// TODO
	// insert, update, delte 
}
