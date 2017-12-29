package com.learn;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.CategoryBean;
import com.dao.Categorydao;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("category")
public class Category {

	@Path("getAllCategory")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCategory() {
		String feeds = null;
		Categorydao categorydao = new Categorydao();
		List<CategoryBean> bean = categorydao.getAllCategory(0);
		Gson gson = new Gson();
		feeds = gson.toJson(bean);
		return feeds;
	}

	@Path("addCategory")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addCategory(String json) {
		Categorydao categorydao = new Categorydao();
		CategoryBean bean = new CategoryBean();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			bean.setCategory_name(jsonObject.get("category_name").getAsString());
			bean.setDescription(jsonObject.get("description").getAsString());
		}
		String msg = categorydao.addCategory(bean);

		return msg;
	}

	@Path("editCategory")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String editCategory(String json) {
		String feeds = null;
		Categorydao categorydao = new Categorydao();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			List<CategoryBean> bean = categorydao.getAllCategory(jsonObject.get("id").getAsInt());
			Gson gson = new Gson();
			feeds = gson.toJson(bean);
		}
		return feeds;
	}

	@Path("updateCategory")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCategory(String json) {
		Categorydao categorydao = new Categorydao();
		CategoryBean bean = new CategoryBean();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			bean.setSr_no(jsonObject.get("id").getAsInt());
			bean.setCategory_name(jsonObject.get("category_name").getAsString());
			bean.setDescription(jsonObject.get("description").getAsString());
		}
		String msg = categorydao.updateCategory(bean);
		return msg;
	}

	@Path("deleteCategory")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCategory(String json) {
		Categorydao categorydao = new Categorydao();
		String msg = "";
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			msg = categorydao.deleteCategory(jsonObject.get("id").getAsInt());
		}
		return msg;
	}

}
