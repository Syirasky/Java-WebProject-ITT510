/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import org.hibernate.Session;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import javax.servlet.http.HttpSession;  
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.hibernate.mapping.Map;
/**
 *
 * @author Crappy
 */
public class test {
    public static void main(String[] args) {
		System.out.println("running");
                Session session = NewHibernateUtil.getSessionFactory().openSession();
		Books s =  new Books(123,"update","update",1,1);
		session.beginTransaction();
		Query query = session.createQuery("update Books set btitle = 'ABCD E'" +
    				" where bookid = 102");
                int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
                System.out.println("Result "+result);
                
                StoreController a = new StoreController();
                a.setAfterBuy(102);
        
	}
}
