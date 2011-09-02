package com.houstoninc.smileyfeedback;

import java.util.List;

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

	public List<String> persons() {
		return dao.fetchPersons();
	}
}
