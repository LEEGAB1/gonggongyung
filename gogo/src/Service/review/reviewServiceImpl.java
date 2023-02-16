package Service.review;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import review.Review;
import review.ReviewDAO;
import zerozerotwo.dbutil.ConnectionProvider;

public class reviewServiceImpl implements reviewService{
	private ReviewDAO dao;

	public reviewServiceImpl(ReviewDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Review> readReview() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.reviewSelect(conn);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Review> readReviewBynickname(String nickname) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.reviewSelectBynickname(conn, nickname);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Review> readReviewByStorename(String storename) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.reviewSelectByStoreName(conn, storename);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Override
	public Review deleteReview(int pk) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Review review = dao.reviewSelectByPk(conn, pk);
			if(review != null) {
				dao.reviewdelete(conn, pk);
			}
			conn.commit();
			
			return review;
		} catch(RuntimeException | SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Review createReview(Review review) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			int key = dao.reviewInsert(conn, review);
			conn.commit();
			
			review.setPk(key);
			return review;
		} catch (RuntimeException | SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


}
