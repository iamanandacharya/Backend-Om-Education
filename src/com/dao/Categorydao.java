package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.CategoryBean;

import connection.ConnectionHandler;

public class Categorydao {

	public List<CategoryBean> getAllCategory(int sr_no) {
		CategoryBean bean = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		List<CategoryBean> messages = null;
		try {
			messages = new ArrayList<>();
			cn = ConnectionHandler.getConn();
			st = cn.createStatement();
			if (sr_no != 0) {
				rs = st.executeQuery("select id,name,description from tbl_category where id=" + sr_no);
			} else {
				rs = st.executeQuery("select id,name,description from tbl_category");
			}
			while (rs.next()) {
				bean = new CategoryBean();
				bean.setSr_no(rs.getInt("id"));
				bean.setCategory_name(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				messages.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return messages;
	}

	public String addCategory(CategoryBean bean) {
		Connection cn = null;
		PreparedStatement pr = null;
		int i = 0;
		try {
			cn = ConnectionHandler.getConn();
			pr = cn.prepareStatement("insert into tbl_category(description, name) " + "values(?,?)");
			pr.setString(1, bean.getDescription());
			pr.setString(2, bean.getCategory_name());
			i = pr.executeUpdate();
			if (i > 0) {
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";

	}

	public String updateCategory(CategoryBean bean) {
		Connection cn = null;
		PreparedStatement pr = null;
		int i = 0;
		try {
			cn = ConnectionHandler.getConn();
			pr = cn.prepareStatement("update tbl_category set description=?, name=? where id=?");
			pr.setString(1, bean.getDescription());
			pr.setString(2, bean.getCategory_name());
			pr.setInt(3, bean.getSr_no());
			i = pr.executeUpdate();
			if (i > 0) {
				return "successly updated.";
			} else {
				return "fail to update.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";

	}
	
	public String deleteCategory(int sr_no) {
		Connection cn = null;
		PreparedStatement pr = null;
		int i = 0;
		try {
			cn = ConnectionHandler.getConn();
			pr = cn.prepareStatement("delete from tbl_category where id=?");
			pr.setInt(1, sr_no);
			i = pr.executeUpdate();
			if (i > 0) {
				return "successly deleted.";
			} else {
				return "fail to delete.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";

	}

}
