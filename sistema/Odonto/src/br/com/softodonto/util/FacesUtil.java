package br.com.softodonto.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.softodonto.modelo.Usuario;


public class FacesUtil {  
    
    private static HttpSession session=null;

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		FacesUtil.session = session;
	}

	public static String getRequestParameter(String name) {  
        return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);  
    }  
  
    public static void exibirMensagemSucesso(String mensagem) {  
        exibirMensagem(FacesMessage.SEVERITY_INFO, mensagem);  
    }  
  
    public static void exibirMensagemAlerta(String mensagem) {  
        exibirMensagem(FacesMessage.SEVERITY_WARN, mensagem);  
    }  
      
    public static void exibirMensagemErro(String mensagem) {  
        exibirMensagem(FacesMessage.SEVERITY_ERROR, mensagem);  
    }  
      
    private static void exibirMensagem(FacesMessage.Severity severity, String mensagem) {  
        FacesMessage facesMessage = new FacesMessage(severity, mensagem, "");  
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);  
    }  
  
    public static ExternalContext getExternalContext() {  
        return FacesContext.getCurrentInstance().getExternalContext();  
    }    
      
    public static ServletContext getServletContext() {  
        return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();  
    }  
      
    public static HttpServletRequest getServletRequest() {  
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();  
    }  
      
    public static HttpServletResponse getServletResponse() {  
        return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();  
    }
    
    public static void redireciona(String url){  
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
        try {  
           response.sendRedirect(url);  
           FacesContext.getCurrentInstance().responseComplete();  
        }  
  
        catch (Exception ex) {  
            ex.printStackTrace();  
        }    
    }
    
    public static void sessionLogin(Usuario user){
        session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );          
        session.setAttribute("USUARIO", user);
      
    }
    
    public static void sessionLogout(){
    	session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( false ); 
    	session = null;
    }
    
    public static boolean isAtivoSession(){
    	if(session != null){
    		return true;
    	}
    	return false;
    }
    
} 
