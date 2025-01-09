package utils;

import org.mindrot.jbcrypt.BCrypt;

public class AccountUtil {
	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public static boolean verifyPassword(String inputPassword, String storedPassword) {
		return BCrypt.checkpw(inputPassword, storedPassword);
	}
}
