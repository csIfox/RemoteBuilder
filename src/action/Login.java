package action;

import java.sql.SQLException;

import javax.naming.NamingException;

import sql.opreate.UserInfoOpreate;
import support.MapActionSupport;
import bean.UserInfo;

public class Login extends MapActionSupport {

	/**
	 * 用户登录验证
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String userName;
	private String password;

	public String login() throws Exception {
		
		System.out.println("用户：" + userName + "  登录");

		if (userName == null | password == null | "".equals(userName) | "".equals(password)) {
			setDataMap("400.1", "用户名或密码不能为空");
			throw new Exception();
		}
		try {
			UserInfoOpreate opreate = new UserInfoOpreate();
			UserInfo userInfo = opreate.getInfoByPassword(userName, password);
			if(userInfo != null){
				setDataMap("200", userInfo);
				return SUCCESS;
			}else{
				setDataMap("400.2", "登录验证失败");
				return SUCCESS;
			}
		} catch (NamingException e) {
			e.printStackTrace();
			setServeErrorData();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			setServeErrorData();
			return SUCCESS;
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
}
