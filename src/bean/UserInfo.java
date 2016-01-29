package bean;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	private String userName;
	private String headSculptureUrl;
	private String lastLoginTime;

	public UserInfo() {
	};

	public UserInfo(String userId, String userName, String headSculptureUrl, String lastLoginTime) {
		this.userId = userId;
		this.userName = userName;
		this.headSculptureUrl = headSculptureUrl;
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadSculptureUrl() {
		return headSculptureUrl;
	}

	public void setHeadSculptureUrl(String headSculptureUrl) {
		this.headSculptureUrl = headSculptureUrl;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
