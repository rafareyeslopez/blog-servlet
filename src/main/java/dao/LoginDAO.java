package dao;

import model.User;

public interface LoginDAO {

	boolean login(String name, String password);

	User getUser(String name, String password);
}
