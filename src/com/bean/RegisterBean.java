package com.bean;

public class RegisterBean {
	
	private String userid;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String imageurl;
    private int isactivate;
    private String lang_key;
    private String activation_key;
    private String reset_key;
    private String create_by;
    private String reset_date;
    private int modify_by;
    private String modify_date;
    
    
    public RegisterBean() {
    	
    }

    public RegisterBean(String userid, String password, String firstname, String lastname, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getIsactivate() {
        return isactivate;
    }

    public void setIsactivate(int isactivate) {
        this.isactivate = isactivate;
    }

    public String getLang_key() {
        return lang_key;
    }

    public void setLang_key(String lang_key) {
        this.lang_key = lang_key;
    }

    public String getActivation_key() {
        return activation_key;
    }

    public void setActivation_key(String activation_key) {
        this.activation_key = activation_key;
    }

    public String getReset_key() {
        return reset_key;
    }

    public void setReset_key(String reset_key) {
        this.reset_key = reset_key;
    }

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getReset_date() {
		return reset_date;
	}

	public void setReset_date(String reset_date) {
		this.reset_date = reset_date;
	}

	public int getModify_by() {
		return modify_by;
	}

	public void setModify_by(int modify_by) {
		this.modify_by = modify_by;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

    
}
