package action;

import support.MapActionSupport;

public class ErrorResolve extends MapActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String defaultError() {
		setDataMap("400", "请检查链接正误！");
		return SUCCESS;
	}

	public String serverError() {
		setDataMap("500", "服务器故障");
		return SUCCESS;
	}
}
