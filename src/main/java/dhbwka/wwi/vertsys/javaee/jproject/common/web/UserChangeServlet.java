/*
 * Copyright © 2019 Jonathan Martin, Nicolas Waguet, Nils Karbstein
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.jproject.common.web;

import dhbwka.wwi.vertsys.javaee.jproject.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.jproject.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.jproject.common.jpa.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nils
 */
@WebServlet(name = "UserChangeServlet", urlPatterns = {"/app/change/"})
public class UserChangeServlet extends HttpServlet {

    @EJB
    ValidationBean validationBean;
    
    @EJB
    UserBean userBean;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/User/user.jsp").forward(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = this.userBean.getCurrentUser();
        
        List<String> errors = this.validationBean.validate(user);
        
        String password_old = request.getParameter("change_password1");
        String password_new = request.getParameter("change_password2");
        String first_name = request.getParameter("change_vorname");
        String last_name = request.getParameter("change_nachname");
                
        
        if(first_name.isEmpty()|| last_name.isEmpty()){
          errors.add("Bitte tragen Sie vor und Nachname ein");
        }
        else{
            this.userBean.updateFirstName(user, first_name);
            this.userBean.updateLastName(user, last_name);    
        }
        
        if(password_old.isEmpty()||password_new.isEmpty()){
            errors.add("Bitte tragen Sie das Alte und das Neue Passwort ein.");
        }else{
            try {
                this.userBean.changePassword(user, password_old, password_new);
            } catch (UserBean.InvalidCredentialsException ex) {
               errors.add(ex.getMessage());
            }
        }
        
        if(errors.isEmpty()){
            response.sendRedirect(WebUtils.appUrl(request, "/app/dashboard/"));
        } else{
            
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            
            HttpSession session = request.getSession();
            session.setAttribute("signup_form", formValues);
            
            response.sendRedirect(request.getRequestURI());
        }
        
        
        
    }



}
