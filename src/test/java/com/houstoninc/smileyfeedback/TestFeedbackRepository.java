package com.houstoninc.smileyfeedback;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class TestFeedbackRepository {

	@Test
	public void shouldSaveFeedback() {
		Mockery mockery = new Mockery();
		final DAO dao = mockery.mock(DAO.class);
		final Feedback feedback = new Feedback("Marno", 50, "Additional comments");
		
		mockery.checking(new Expectations() {{
			oneOf(dao).saveFeedback(feedback);
		}});
		
		new FeedbackRepository(dao).save(feedback);
		
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void shouldFetchPreviousFeedback() {
		Mockery mockery = new Mockery();
		final DAO dao = mockery.mock(DAO.class);
		
		mockery.checking(new Expectations() {{
			oneOf(dao).fetchFeedback("Marno"); will(returnValue(50));
		}});
		
		assertEquals(Integer.valueOf(50), new FeedbackRepository(dao).fetch("Marno"));
		
		mockery.assertIsSatisfied();
	}
}
