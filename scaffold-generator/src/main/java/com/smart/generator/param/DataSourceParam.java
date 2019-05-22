package com.smart.generator.param;


import com.smart.generator.config.IDbQuery;
import com.smart.generator.config.MySqlQuery;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Data
public class DataSourceParam {

	/**
	 * 驱动连接的URL
	 */
	private String url;
	/**
	 * 驱动名称
	 */
	private String driverName;
	/**
	 * 数据库连接用户名
	 */
	private String username;
	/**
	 * 数据库连接密码
	 */
	private String password;

	/**
	 * 创建数据库连接对象
	 *
	 * @return Connection
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	public IDbQuery getDbQuery() {
		return new MySqlQuery();
	}

}
