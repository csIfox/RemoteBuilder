package support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSupport {

	private static String expressionUserName = "([_a-zA-Z0-9][\\u4e00-\\u9fa5_a-zA-Z]{3,19})|([\\u4e00-\\u9fa5][\\u4e00-\\u9fa5_a-zA-Z]{1,19})";
	private static String expressionMobilePhone = "[1][3|4|5|7|8][0-9]{9}";
	private static String expressionPassword = "[_a-zA-Z0-9]{6,20}";

	public static boolean validateUserName(String userName) {
		Pattern pattern = Pattern.compile(expressionUserName);
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}

	public static boolean validateMobilePhone(String phone) {
		Pattern pattern = Pattern.compile(expressionMobilePhone);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	public static boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile(expressionPassword);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
