package com.pack;

public interface UserDAO {

	User loadByUsernameAndPassword(String userName, String password);

}
