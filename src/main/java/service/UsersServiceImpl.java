package service;

import dao.UsersDAO;
import dao.UsersDAOJDBCimpl;
import model.User;

public class UsersServiceImpl implements UsersService {

	private UsersDAO dao;

	public UsersServiceImpl() {
		dao = new UsersDAOJDBCimpl();
	}

	@Override
	public void register(String email, String password, String name, String lastName) {
		User user = new User(email, password, name, lastName);
		dao.register(user);
	}

	@Override
	public boolean login(String email, String password) {

		User userByEmail = dao.getUserByEmail(email);

		if (userByEmail == null) {
			return false;
		} else {
			String decodedPassword = Md5.ConvertToMd5(password);
			if (userByEmail.getPassword().equals(decodedPassword)) {
				return true;
			} else {
				return false;
			}
		}

	}
}
