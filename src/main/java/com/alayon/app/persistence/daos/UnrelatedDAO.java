package com.alayon.app.persistence.daos;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alayon.app.persistence.entities.UnrelatedEntity;

public interface UnrelatedDAO extends JpaRepository<UnrelatedEntity, Integer>{

	/**
	 * Querys by methods name
	 * 
	 * +find/delete
	 * 		[First],[First%n%],[Distinct]
	 * +By
	 * 		%Atr%:
	 * 			+Is,Equals,Between,LesssThan,LessThanEqual,GreaterThan,GreaterThanEqual,
	 * 			 After,Before,IsNotNull,Like,NotLike,StartingWith,EndingWith,
	 * 			 Containing,Not,In,NotIn,True,False
	 * 		IgnoreCase
	 * 		And,Or
	 * 
	 * +OrderBy
	 * 		%Atr%Desc, %Atr%Asc
	 */
	
	UnrelatedEntity findByNicknameIgnoreCase(String nickname);
	List<UnrelatedEntity> findFirst3ByNicknameStartingWith(String prefix);
	List<UnrelatedEntity> findByNicknameOrTextOrderByIdDesc(String nickname, String text);
	List<UnrelatedEntity> findByIdGreaterThan(int id, Pageable pageable);
	List<UnrelatedEntity> findByNicknameIn(Collection<String> values);
	
	/**
	 * Querys by JQPL
	 * ?1 ?2 ?3 ...
	 * :name ....@Param("name")
	 */
	
	@Query("select u.nickname from un_related u where u.nickname like :nick")
	List<String> findNicknameByNicknameLike(String nick);
	
	@Query("select u.id from un_related u where u.id > :initial and u.id < :end")
	List<Integer> findIdByIdBetween(int initial, int end);
	
	
	
	/**
	 * Querys by SQL
	 */
	@Query(value="SELECT * FROM un_related WHERE nickname = ?1", nativeQuery=true)
	UnrelatedEntity findByNickname(String nick);
	
	@Transactional
	int deleteByNickname(String nickname);
}
