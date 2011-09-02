package com.houstoninc.smileyfeedback;

public class FeedbackRepository {
	private final DAO dao;

	public FeedbackRepository(DAO dao) {
		this.dao = dao;
	}

	public void save(Feedback feedback) {
		dao.saveFeedback(feedback);
	}

	public Integer fetch(String name) {
		return dao.fetchFeedback(name);
	}
}
