package com.pack;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class LoginServiceTest{

	LoginServiceImpl service;
	UserDAO mockDao;

	@Before
	public void setUp() throws Exception {
		service = new LoginServiceImpl();
		//mockDao = createStrictMock(UserDAO.class);
		mockDao = EasyMock.createMock(UserDAO.class);
		service.setUserDAO(mockDao);
	}
	@Test
	public void testLogin() throws Exception {
		User results = new User();
		String userName = "userName";
		String password = "testPassword";
		String passwordHash = "þÓ¶&I7€€³Ni=.";
		expect(mockDao.loadByUsernameAndPassword(eq(userName),
						eq(passwordHash))).andReturn(results);
		replay(mockDao);
		assertTrue(service.login(userName, password));
		verify(mockDao);
		assertTrue(true);
	}

}
