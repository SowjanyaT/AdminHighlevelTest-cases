package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.UniformBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class UniformDAO {

	Properties properties; 
	
	public UniformDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UniformBean> getuniforms(){
		String sql = properties.getProperty("get.uniforms"); 
		
		GetConnection gc  = new GetConnection(); 
		List<UniformBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<UniformBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				UniformBean temp = new UniformBean(); 
				temp.setName(gc.rs1.getString(1));
				temp.setDescription(gc.rs1.getString(2));
				temp.setMetatag(gc.rs1.getString(3));
				temp.setMetatagD(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new UniformDAO().getuniforms().forEach(System.out :: println);
	}
}
