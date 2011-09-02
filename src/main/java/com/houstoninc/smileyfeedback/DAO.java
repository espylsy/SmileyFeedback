package com.houstoninc.smileyfeedback;

public interface DAO {

	void saveFeedback(Feedback feedback);

	Integer fetchFeedback(String name);

}
