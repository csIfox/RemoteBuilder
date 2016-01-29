package action;

import java.sql.SQLException;

import javax.naming.NamingException;

import sql.opreate.UserInfoOpreate;
import support.MapActionSupport;
import support.ValidateSupport;

public class IsPhoneExit extends MapActionSupport {

	/**
	 * 验证手机号是否已存在
	 */
	private static final long serialVersionUID = 1L;

	private String phone;

	public String isPhoneExit() throws NamingException, SQLException {
		UserInfoOpreate opreate = new UserInfoOpreate();
		boolean flag = opreate.isPhoneExit(phone);
		if (flag) {
			setDataMap("400", "手机号已存在");
			return SUCCESS;
		} else {
			setDataMap("200", "手机号可用");
			return SUCCESS;
		}
	}

	public void validateIsPhoneExit() {
		if (phone == null) {
			setEmptyErrorData();
			addActionError(null);
		} else if (ValidateSupport.validateMobilePhone(phone) == false) {
			setEmptyErrorData();
			addActionError(null);
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
