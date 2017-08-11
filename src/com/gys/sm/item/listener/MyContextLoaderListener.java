package com.gys.sm.item.listener;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.gys.sm.item.constant.SysConstants;

public class MyContextLoaderListener extends ContextLoaderListener {
	private static Logger logger=Logger.getLogger(MyContextLoaderListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("===================创建jdbc配置文件===================");
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		FileOutputStream outputstream=null;
		try {
			String propFileName=event.getServletContext().getRealPath(File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"jdbc.properties");
			if(!new File(propFileName).exists()){
				new File(propFileName).createNewFile();
			}
			Properties prop=new Properties();
			prop.load(MyContextLoaderListener.class.getClassLoader().getResourceAsStream("/jdbc.properties"));
			
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup(SysConstants.JNDINAME);
			conn =ds.getConnection();
			pst=conn.prepareStatement("SELECT t.key,t.value FROM sys_jdbc_properties t");
			rs=pst.executeQuery();
			while (rs.next()) {
				prop.setProperty(rs.getString("key"), rs.getString("value"));
			}
			outputstream=new FileOutputStream(propFileName);
			prop.store(outputstream, "动态加载JDBC配置");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("加载JDBC配置出错", e);
		}finally{
			try {
				if(outputstream!=null){
					outputstream.close();
				}
				if(rs!=null){
					rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		super.contextInitialized(event);
	}
	
}
