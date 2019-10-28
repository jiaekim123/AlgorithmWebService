package com.algorithm;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class mySQLConnectionTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/algorithm";
	private static final String TIMEJONE = "?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private static final String USER = "algorithm";
	private static final String PW = "algorithm@23";
	
	@Test
	public void testMySQLConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL+TIMEJONE, USER, PW)){
			System.out.println("Success to connect MySQL ["+URL+"]");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println("Fail to connect MySQL ["+URL+"]");
			e.printStackTrace();
			fail("Fail to Connect");
		}

	}

}
