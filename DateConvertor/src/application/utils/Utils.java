package application.utils;

public class Utils {

	public static boolean isNumber(char c) {
		try {
			Long.parseLong(String.valueOf(c));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
