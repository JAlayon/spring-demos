package com.alayon.app.persistence.daos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alayon.app.persistence.entities.Gender;
import com.alayon.app.persistence.entities.UnrelatedEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnrelatedDAOUTest {
	
	@Autowired
	private UnrelatedDAO unrelatedDAO;
	
	@Before
	public void seedDatabase() {
		String list[] = {"1","2","3"};
		for(int i=1; i<=10; i++) {
			unrelatedDAO.save(new UnrelatedEntity("nick"+i, Gender.FEMALE, 
					new GregorianCalendar(1998,10,15),"this is a large text", list,
					Arrays.asList(list), "no persistent"));
		}
	}
	
	@After
	public void destroyDatabase() {
		unrelatedDAO.deleteAll();
	}
	
	/**
	 * Test by inheritence: JPARepository
	 */
	
	@Test
	public void testCount() {
		assertThat(4, is(equalTo(4)));
	}
	
	@Test
	public void testFindById() {
		UnrelatedEntity entity = new UnrelatedEntity("example_nick", Gender.MALE, 
								null, null, null, null, null);
		entity = unrelatedDAO.save(entity);
		assertEquals("example_nick", unrelatedDAO.findById(entity.getId()).get().getNickname());
	}
	
	
	/**
	 * Test by methods name
	 */
	@Test
	public void testFindByNickNameIgnoreCase() {
		for(int i =1; i<=10; i++) {
			assertNotNull(unrelatedDAO.findByNicknameIgnoreCase("NICK"+i));
		}
	}
	
	@Test
	public void testFindFirst3ByNicknameStartingWith() {
		assertThat(0, is(equalTo(unrelatedDAO.findFirst3ByNicknameStartingWith("no").size())));
		assertThat(3, is(equalTo(unrelatedDAO.findFirst3ByNicknameStartingWith("ni").size())));
	}
	
	@Test
	public void testFindByNicknameOrTextOrderByIdDesc() {
		List<UnrelatedEntity> list = unrelatedDAO.
								findByNicknameOrTextOrderByIdDesc("some_nick", "this is a large text");
	
		assertTrue(list.get(0).getId() > list.get(1).getId() &&
				   list.get(2).getId() > list.get(3).getId() &&
				   list.get(4).getId() > list.get(5).getId());
		
		assertEquals(10, list.size());
	}
	
	
	/**
	 * Pagiantion
	 */
	
	@Test 
	public void testFindByIdGreaterThan() {
		assertEquals(2,unrelatedDAO.findByIdGreaterThan(3, PageRequest.of(0, 2)).size());
		assertEquals(4, unrelatedDAO.findByIdGreaterThan(1,PageRequest.of(1, 4)).size());
	}
	
	
	@Test
	public void testFindByNicknameIn() {
		assertEquals(3, unrelatedDAO.findByNicknameIn(Arrays.asList(new String[] {"nick1", "nick2", "nick3"})).size());
	}
	
	
	/*
	 * Tests by JQPL
	 */
	
	@Test
	public void testFindNickByNickLike() {
		assertEquals(10, unrelatedDAO.findNicknameByNicknameLike("nick%").size());
	}
	
	@Test
	public void testFindIdByIdBetween() {
		assertThat(5, is(equalTo(unrelatedDAO.findIdByIdBetween(4,6).get(0))));
		assertEquals(3, unrelatedDAO.findIdByIdBetween(2, 6).size());
	}
	
	
	
	/**
	 * SQL
	 */
	@Test
	public void testFindByNickname() {
		int id = unrelatedDAO.findByNickname("nick5").getId();
		assertEquals(5,id);
	}
	
	/**
	 * Deletes
	 */
	
	@Test
	public void testDeleteByNick() {
		assertNotNull(unrelatedDAO.findByNickname("nick5"));
		unrelatedDAO.deleteByNickname("nick5");
		assertNull(unrelatedDAO.findByNickname("nick5"));
	}
	
	
}








