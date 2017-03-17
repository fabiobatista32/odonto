package br.com.softodonto.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException{      
        
        String code = null, message = null, type = null;
        Object codeObj, messageObj, typeObj;

        // Recuperar os três atributos de erro
        codeObj = req.getAttribute("javax.servlet.error.status_code");
        messageObj = req.getAttribute("javax.servlet.error.message");
        typeObj = req.getAttribute("javax.servlet.error.exception_type");

        // Converte os atributos para string
        if (codeObj != null)
          code = codeObj.toString();
        if (messageObj != null)
          message = messageObj.toString();
        if (typeObj != null)
          type = typeObj.toString();
        
        req.setAttribute("code", code);
        req.setAttribute("message", message);
        req.setAttribute("type", type);
        
 
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/erros/erro.jsf");
        requestDispatcher.forward(req, res);
    }
 
    public void doGet(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException{
        doPost(req, res);
    }  

}
