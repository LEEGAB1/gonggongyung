package Service.review;

import java.util.List;

import review.Review;

public interface reviewService {
	//read, delete , readByString
	List<Review> readReview();
	List<Review> readReviewBynickname(String nickname);
	List<Review> readReviewByStorename(String storename);
	Review deleteReview(int pk);
	Review createReview(Review review);
	
}
