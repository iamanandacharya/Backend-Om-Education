package com.learn;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.RegisterBean;
import com.dao.Registerdao;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("user")
public class Register {

	@Path("register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getRegister(String json) {
		RegisterBean service =null;
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement= jsonparser.parse(json);
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			//service = new RegisterBean(jsonObject.get("userid").getAsString(), jsonObject.get("password").getAsString(),
					//jsonObject.get("firstname").getAsString(), jsonObject.get("lastname").getAsString(),jsonObject.get("email").getAsString());
			service = new RegisterBean();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			service.setUserid(jsonObject.get("userid").getAsString());
	        service.setPassword(jsonObject.get("password").getAsString());
	        service.setFirstname(jsonObject.get("firstname").getAsString());
	        service.setLastname(jsonObject.get("lastname").getAsString());
	        service.setEmail(jsonObject.get("email").getAsString());
	        service.setImageurl("C:\\user\\anil");
	        service.setIsactivate(1);
	        service.setLang_key("abc");
	        service.setActivation_key("aaa");
	        service.setReset_key("aaeee");
	        service.setCreate_by(sdf.format(new java.util.Date()));
	        service.setReset_date(sdf.format(new java.util.Date()));
	        service.setModify_by(1);
	        service.setModify_date(sdf.format(new java.util.Date()));
		}
		Registerdao registerdao = new Registerdao();
		String msg = registerdao.register(service);
		
		return msg;
	}
	
	
	@Path("login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getlogin(String json) {
		RegisterBean service =null;
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement= jsonparser.parse(json);
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			service = new RegisterBean();
			service.setUserid(jsonObject.get("userid").getAsString());
	        service.setPassword(jsonObject.get("password").getAsString());
		}
		Registerdao registerdao = new Registerdao();
		String msg = registerdao.loginUser(service);
		
		return msg;
	}
	
	@Path("hello")
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }
	
	@Path("getAllUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public String  getAllUser() {
		String feeds = null;
		Registerdao registerdao = new Registerdao();
		List<RegisterBean> bean = registerdao.getAllUser();
		Gson gson = new Gson();
		feeds = gson.toJson(bean);
		return feeds;
	}
	
	@Path("deleteUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String  getDeleteUser(String json) {
		String message = null;
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement= jsonparser.parse(json);
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
		Registerdao registerdao = new Registerdao();
		message = registerdao.userDelete(jsonObject.get("userid").getAsString());
		}
		return message;
		
	}
	
	@Path("statusChange")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String  statusChange(String json) {
		String message = null;
		JsonParser jsonparser = new JsonParser();
		JsonElement jsonElement= jsonparser.parse(json);
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
		Registerdao registerdao = new Registerdao();
		message = registerdao.userActiveDeactive(jsonObject.get("userid").getAsString(),jsonObject.get("status").getAsInt());
		}
		return message;
		
	}
	
}
