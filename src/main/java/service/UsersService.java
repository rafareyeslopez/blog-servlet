package service;

public interface UsersService {

	void register(String email, String password, String name, String lastLame);

	boolean login(String email, String password);
}
