package dao;

import model.User;

public interface UsersDAO {
	void register(User user);

	User getUserByEmail(String email);
}
