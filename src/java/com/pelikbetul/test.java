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
                
                //StoreController a = new StoreController();
             //   a.AddtoCart(102);
            //    a.AddtoCart(107);
             //   a.AddtoCart(107);
             //   a.calculateTotal();
            //    System.out.println("Total Price Test:"+a.getTotalprice());
            //    a.addindbpayment();
               ObjToXml o2x = new ObjToXml();
               o2x.createPayXml();
              
        
	}
}
