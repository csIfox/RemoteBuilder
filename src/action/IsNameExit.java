package action;

import java.sql.SQLException;

import javax.naming.NamingException;

import sql.opreate.UserInfoOpreate;
import support.MapActionSupport;

public class IsNameExit extends MapActionSupport {

	/**
	 * 认证用户名是否已存在
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	public String isNameExit() throws NamingException, SQLException {
		UserInfoOpreate opreate = new UserInfoOpreate();
		boolean flag = opreate.isNameExit(userName);
		if (flag) {
			setDataMap("400", "用户名已存在");
			return SUCCESS;
		} else {
			setDataMap("200", "用户名可用");
			return SUCCESS;
		}
	}

	public void validateIsNameExit() {
		if (userName == null | "".equals(userName)) {
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

}
