package com.houstoninc.smileyfeedback;

import java.util.List;

public interface DAO {

	void saveFeedback(Feedback feedback);

	Integer fetchFeedback(String name);

	List<String> fetchPersons();

}
