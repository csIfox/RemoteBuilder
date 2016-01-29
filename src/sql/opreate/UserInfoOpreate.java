package sql.opreate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;

import sql.dbc.DatabaseConnection;
import bean.UserInfo;

public class UserInfoOpreate {

	public static final String SQL_GET_INFO_BY_PASSWORD = "select id,name,head_sculpture from user_info where name=? and password=?";
	public static final String SQL_GET_INFO_BY_LAST_LOGIN_TIME = "select id,name,head_sculpture from user_info where name=? and last_login_time=?";
	public static final String SQL_IS_NAME_EXIT = "select id from user_info where name=?";
	public static final String SQL_IS_PHONE_EXIT = "select id from user_info where phone=?";
	public static final String SQL_REGISTER_USER = "insert into user_info (name,password,phone)values (?,?,?)";
	public static final String SQL_UPDATA_LAST_LOGIN_TIME = "update user_info set last_login_time=? where name=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	private void init(String sql) throws NamingException, SQLException {
		connection = DatabaseConnection.getConnection();
		preparedStatement = connection.prepareStatement(sql);
	}

	public void close() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public UserInfo getInfoByPassword(String name, String password) throws NamingException, SQLException {
		this.init(SQL_GET_INFO_BY_PASSWORD);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String dateTime = this.getCurrentTime();
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(resultSet.getString("id"));
			userInfo.setUserName(resultSet.getString("name"));
			userInfo.setHeadSculptureUrl(resultSet.getString("head_sculpture"));
			userInfo.setLastLoginTime(dateTime);
			this.close();
			this.updateLastLoginTime(name, dateTime);
			return userInfo;
		} else {
			this.close();
			return null;
		}
	}

	public UserInfo getInfoByLastLoginTime(String name, String lastLoginTime) throws NamingException,
			SQLException {
		this.init(SQL_GET_INFO_BY_LAST_LOGIN_TIME);
		preparedStatement.setString(1, name);
		preparedStatement.setString(1, lastLoginTime);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String dateTime = this.getCurrentTime();
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(resultSet.getString("id"));
			userInfo.setUserName(resultSet.getString("name"));
			userInfo.setHeadSculptureUrl(resultSet.getString("head_sculpture"));
			userInfo.setLastLoginTime(dateTime);
			this.close();
			this.updateLastLoginTime(name, dateTime);
			return userInfo;
		} else {
			this.close();
			return null;
		}
	}

	public boolean isNameExit(String name) throws NamingException, SQLException {
		this.init(SQL_IS_NAME_EXIT);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			this.close();
			return true;
		} else {
			this.close();
			return false;
		}
	}

	public boolean isPhoneExit(String phone) throws NamingException, SQLException {
		this.init(SQL_IS_PHONE_EXIT);
		preparedStatement.setString(1, phone);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			this.close();
			return true;
		} else {
			this.close();
			return false;
		}
	}

	public boolean registerUser(String name, String password, String phone) throws NamingException,
			SQLException {
		if (isNameExit(name) | isPhoneExit(phone)) {
			return false;
		} else {
			this.init(SQL_REGISTER_USER);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, phone);
			int flag = preparedStatement.executeUpdate();
			this.close();
			if (flag == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean updateLastLoginTime(String name, String dateTime) throws NamingException, SQLException {
		this.init(SQL_UPDATA_LAST_LOGIN_TIME);
		preparedStatement.setString(1, dateTime);
		preparedStatement.setString(2, name);
		int flag = preparedStatement.executeUpdate();
		this.close();
		if (flag == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = format.format(System.currentTimeMillis());
		System.out.println("登录时间：  " + dateTime);
		return dateTime;
	}

}
