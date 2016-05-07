package com.sa.tcm.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sa.tcm.dao.LoginDAO;
import com.sa.tcm.utils.CacheControlPhaseListener;

@ManagedBean
@SessionScoped
public class Login {

	private static final long serialVersionUID = 1094801825228386363L;
	private String pwd;
    private String msg;
    private String user;
    private String role;
    @ManagedProperty("#{cacheController}")
    CacheControlPhaseListener cacheController;
    
    
	public CacheControlPhaseListener getCacheController() {
		return cacheController;
	}
	public void setCacheController(CacheControlPhaseListener cacheController) {
		this.cacheController = cacheController;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	 //validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd,role);
        if (valid) {
            HttpSession session = SessionBean.getSession();
            cacheController.isLoggedIn = "Y";
            
            session.setAttribute("username", user);
            return "/MyTemplateHome";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Incorrect Username / Passowrd / Role ",
                            "Please enter correct username,Password & Role"));
            return "login";
        }
    }
 
    //logout event, invalidate session
    public String logout() {
    	cacheController.isLoggedIn = "N";
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login";
    }
}
