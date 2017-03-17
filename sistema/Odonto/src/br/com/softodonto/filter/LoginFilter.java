package br.com.softodonto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{	
	
	@Override
	public void destroy() {

		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	/*	UsuarioManagedBean usuarioManagedBean = (UsuarioManagedBean) 
                 ((HttpServletRequest) request)
                   .getSession().getAttribute("usuarioBean");
		
	    HttpServletRequest httpRequest = (HttpServletRequest)request; 
		String raizProjeto = httpRequest.getContextPath();		
		String currentView = httpRequest.getRequestURI(); //retorna a url completa (com o contexto). Ex:  suaplicacao/pasta/pagina.jsf    
		
		if (currentView.contains("login")){
			chain.doFilter(request, response);
		}else if(usuarioManagedBean == null || usuarioManagedBean.getUserLogado()==null){
			((HttpServletResponse)response).sendRedirect
            (raizProjeto + "/admin/login.jsf");
		}else{
			chain.doFilter(request, response);
		}*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
	
}
