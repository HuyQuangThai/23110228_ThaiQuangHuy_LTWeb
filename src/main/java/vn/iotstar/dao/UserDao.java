package vn.iotstar.dao;

import vn.iotstar.model.User;

public interface UserDao {
	User get(String username);
	void insert(User user);
	void reset(String username, String password);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String other);
	boolean checkExistPhone(String phone);
}
