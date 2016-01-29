package action;

import java.sql.SQLException;

import javax.naming.NamingException;

import sql.opreate.UserInfoOpreate;
import support.MapActionSupport;

public class IsPhoneExit extends MapActionSupport{

	/**
	 * 验证手机号是否已存在
	 */
	private static final long serialVersionUID = 1L;
	
	private String phone;
	
	public String isPhoneExit() throws NamingException, SQLException{
		if(phone == null | "".equals(phone)){
			setEmptyErrorData();
			return SUCCESS;
		}
		UserInfoOpreate opreate = new UserInfoOpreate();
		boolean flag = opreate.isPhoneExit(phone);
		if(flag){
			setDataMap("400.5", "手机号已存在");
			return SUCCESS;
		}else{
			setDataMap("200", "手机号可用");
			return SUCCESS;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
