package action;

import java.sql.SQLException;

import javax.naming.NamingException;

import bean.UserInfo;
import sql.opreate.UserInfoOpreate;
import support.MapActionSupport;

public class Register extends MapActionSupport {

	/**
	 * 用户注册
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String phone;

	public String register() throws NamingException, SQLException {
		// TODO
		System.out.println("注册名：" + userName);
		UserInfoOpreate opreate = new UserInfoOpreate();
		boolean flag = opreate.registerUser(userName, password, phone);
		if (!flag) {
			setDataMap("400.3", "注册失败！");
			return SUCCESS;
		} else {
			UserInfo userInfo = opreate.getInfoByPassword(userName, password);
			setDataMap("200", userInfo);
			return SUCCESS;
		}
	}

	public void validateRegister() {
		if (userName == null | password == null | phone == null | "".equals(userName) | "".equals(password)
				| "".equals(phone)) {
			setEmptyErrorData();
			addActionError(null);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
