package com.learn;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.bean.CourseBean;
import com.dao.Coursedao;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("course")
public class Course {
	
	@Path("getAllCourse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public String  getAllCourse() {
		String feeds = null;
		Coursedao coursedao = new Coursedao();
		List<CourseBean> bean = coursedao.getAllCourse(0);
		Gson gson = new Gson();
		feeds = gson.toJson(bean);
		return feeds;
	}
	@Path("getIdALLCourse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCourse(String id) {
		String feed = null;
		Coursedao coursedao  = new Coursedao();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonelement = jsonparser.parse(id);
		if(jsonelement.isJsonObject()) {
			JsonObject jsonobject = jsonelement.getAsJsonObject();
			List<CourseBean> bean = coursedao.getAllCourse(jsonobject.get("id").getAsInt());
			Gson gson = new Gson();
			feed = gson.toJson(bean);
		}
		return feed;
		
	}
	
	@Path("addCourse")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addCourse(String json) {
		Coursedao coursedao = new Coursedao();
		CourseBean bean = new CourseBean();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			bean.setCourse_name(jsonObject.get("category_name").getAsString());
			bean.setDescription(jsonObject.get("description").getAsString());
		}
		String msg = coursedao.addCourse(bean);

		return msg;
	}

	@Path("editCourse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String editCourse(String json) {
		String feeds = null;
		Coursedao coursedao = new Coursedao();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			List<CourseBean> bean = coursedao.getAllCourse(jsonObject.get("id").getAsInt());
			System.out.println(bean);
			Gson gson = new Gson();
			feeds = gson.toJson(bean);
		}
		return feeds;
	}

	@Path("updateCourse")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCourse(String json) {
		Coursedao coursedao = new Coursedao();
		CourseBean bean = new CourseBean();
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			bean.setSr_no(jsonObject.get("id").getAsInt());
			bean.setCourse_name(jsonObject.get("course_name").getAsString());
			bean.setDescription(jsonObject.get("description").getAsString());
		}
		String msg = coursedao.updateCourse(bean);
		return msg;
	}

	@Path("deleteCourse")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCourse(String json) {
		Coursedao coursedao = new Coursedao();
		String msg = "";
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement = jsonparser.parse(json);
		if (jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			msg = coursedao.deleteCourse(jsonObject.get("id").getAsInt());
		}
		return msg;
	}

}
