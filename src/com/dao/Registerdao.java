package com.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.RegisterBean;

import connection.ConnectionHandler;

public class Registerdao {
	
	public String register(RegisterBean service) {
		Connection cn = null;
		 PreparedStatement pr = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        int i = 0;
	        try {
	            Date d = new Date();
	            cn = ConnectionHandler.getConn();
	            pr = cn.prepareStatement("insert into jhi_user(login, password_hash, first_name, last_name, email, image_url, activated, lang_key, activation_key, reset_key, created_by, created_date, reset_date, last_modified_by, last_modified_date) "
	                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            pr.setString(1, service.getUserid());
	            pr.setString(2, findProperPasswordEncryption("md5",service.getPassword()));
	            pr.setString(3, service.getFirstname());
	            pr.setString(4, service.getLastname());
	            pr.setString(5, service.getEmail());
	            pr.setString(6, service.getImageurl());
	            pr.setInt(7, service.getIsactivate());
	            pr.setString(8, service.getLang_key());
	            pr.setString(9, service.getActivation_key());
	            pr.setString(10, service.getReset_key());
	            pr.setString(11, service.getCreate_by());
	            pr.setString(12, sdf.format(d));
	            pr.setString(13, service.getReset_date());
	            pr.setInt(14, service.getModify_by());
	            pr.setString(15, service.getModify_date());

	            i = pr.executeUpdate();
	            if(i > 0) {
	            	return "success";
	            }else {
	            	return "fail";
	            }

	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return "fail";
	}
	
	public String loginUser(RegisterBean service) {
		Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        int i = 0;
        try {
        	cn =ConnectionHandler.getConn();
            pr = cn.prepareStatement("select count(1) as cnt from jhi_user where email=? and password_hash=?");
            pr.setString(1, service.getUserid());
            pr.setString(2, findProperPasswordEncryption("md5",service.getPassword()));
            rs = pr.executeQuery();
            if (rs.next()) {
                i = rs.getInt("cnt");
            }
            if(i > 0) {
            	return "success";
            }else {
            	return "fail";
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
        return "fail";
    }
	
	public static String findProperPasswordEncryption(String encryptionType, String password) {
        if (encryptionType.equalsIgnoreCase("md5")) {
            return encryptString(password);
        } else if (encryptionType.equalsIgnoreCase("aes")) {
            return encryptString(password);
        }
        return "neither";
    }

    public static String encryptString(String plainText) {
        String strCipherText = "";
        try {

            byte[] defaultBytes = plainText.getBytes();
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte[] messageDigest = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            strCipherText = hexString.substring(0);
        } catch (Exception e) {
            
        }
        return strCipherText;
    }
    
    public List<RegisterBean> getAllUser() {
    	RegisterBean bean = null;
    	Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        List<RegisterBean> messages = null;
        try {
        	messages = new ArrayList<>();
        	cn =ConnectionHandler.getConn();
        	st = cn.createStatement();
        	rs = st.executeQuery("select * from jhi_user");
        	while(rs.next()) {
        		bean = new RegisterBean();
        		bean.setFirstname(rs.getString("first_name"));
        		bean.setLastname(rs.getString("last_name"));
        		bean.setEmail(rs.getString("email"));
        		bean.setIsactivate(rs.getInt("activated"));
        		messages.add(bean);
        	}
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
    	return messages;
    }
    
    public String userDelete(String user_srno) {
    	Connection cn = null;
        Statement st = null;
        //ResultSet rs = null;
        String messages = null;
        try {
        	cn = ConnectionHandler.getConn();
        	st = cn.createStatement();
        	int i = st.executeUpdate("delete from jhi_user where id="+user_srno);
        	if(i > 0) {
        		messages = "User Deleted Successfully.";
        	}else {
        		messages = "There is some problem in delete user.";
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
    	return messages;
    }
    
    public String userActiveDeactive(String user_srno,int status) {
    	Connection cn = null;
        Statement st = null;
        //ResultSet rs = null;
        String messages = null;
        try {
        	cn = ConnectionHandler.getConn();
        	st = cn.createStatement();
        	int i = st.executeUpdate("update jhi_user set activated="+status+" where id="+user_srno);
        	if(i > 0) {
        		messages = "User Status change Successfully.";
        	}else {
        		messages = "There is some problem in change user status.";
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
    	return messages;
    }

}
