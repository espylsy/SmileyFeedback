package com.houstoninc.smileyfeedback;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFeedbackRepository {

	private Mockery mockery;
	private DAO dao;

	@Before
	public void setUp() {
		mockery = new Mockery();
		dao = mockery.mock(DAO.class);
	}
	
	@Test
	public void shouldSaveFeedback() {
		final Feedback feedback = new Feedback("Marno", 50, "Additional comments");
		
		mockery.checking(new Expectations() {{
			oneOf(dao).saveFeedback(feedback);
		}});
		
		new FeedbackRepository(dao).save(feedback);
	}
	
	@Test
	public void shouldFetchPreviousFeedback() {
		mockery.checking(new Expectations() {{
			oneOf(dao).fetchFeedback("Marno"); will(returnValue(50));
		}});
		
		assertEquals(Integer.valueOf(50), new FeedbackRepository(dao).fetch("Marno"));
	}
	
	@Test
	public void shouldFetchListOfPersonsToGiveFeedback() {
		@SuppressWarnings("serial")
		final List<String> persons = new ArrayList<String>() {{
			add("Marno");
			add("Esko");
		}};
		
		mockery.checking(new Expectations() {{
			oneOf(dao).fetchPersons(); will(returnValue(persons));
		}});
		
		assertEquals(persons, new FeedbackRepository(dao).persons());
	}
	
	
	@After
	public void tearDown() {
		mockery.assertIsSatisfied();
	}
}
