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
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.mapping.Map;
import org.hibernate.Transaction;

/**
 *
 * @author Crappy
 */
@Named(value = "storeController")
@SessionScoped
public class StoreController implements Serializable {

    

    /**
     * Creates a new instance of StoreController
     */
    public StoreController() {
    }
    
    
    private Books b,e;
    private User u;
    private Integer bookid;
    private String btitle;
    private String bisbn;
    private int quantity;
    private double price;
    private Session session;
    private List<Books> lb ;
    private List<Admin> la ;
    private List<Payment> lp;
    private List<User> lu;
    private String user;
    private String pwd;
    private Integer id;
    private String adminid;
    private String adminpwd;
    private boolean editable;
    private String saveurl;
    private Integer paymentid;
    private int custid;
    private double totalprice;
    private List<Integer> cartitem;
    public void setBookid(int bookid) {
     this.bookid = bookid;
    }
     public int getBookid() {
        return this.bookid;
    }
    public String getBtitle() {
        return this.btitle;
    }
    
    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
    public String getBisbn() {
        return this.bisbn;
    }
    
    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public void clear(){
        btitle=null;
        bisbn = null;
        quantity=0;
        price = 0;
        
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the adminid
     */
    public String getAdminid() {
        return adminid;
    }

    /**
     * @param adminid the adminid to set
     */
    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    /**
     * @return the adminpwd
     */
    public String getAdminpwd() {
        return adminpwd;
    }

    /**
     * @param adminpwd the adminpwd to set
     */
    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    /**
     * @return the paymentid
     */
    public Integer getPaymentid() {
        return paymentid;
    }

    /**
     * @param paymentid the paymentid to set
     */
    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the la
     */
    public List<Admin> getLa() {
        return la;
    }

    /**
     * @return the lp
     */
    public List<Payment> getLp() {
        return lp;
    }

    /**
     * @param lp the lp to set
     */
    public void setLp(List<Payment> lp) {
        this.lp = lp;
    }

    /**
     * @return the lu
     */
    public List<User> getLu() {
        return lu;
    }

    /**
     * @param lu the lu to set
     */
    public void setLu(List<User> lu) {
        this.lu = lu;
    }

    /**
     * @return the cartitem
     */
    public List<Integer> getCartitem() {
        return cartitem;
    }

    /**
     * @param cartitem the cartitem to set
     */
    public void setCartitem(List<Integer> cartitem) {
        this.cartitem = cartitem;
    }

    /**
     * @return the custid
     */
    public int getCustid() {
        return custid;
    }

    /**
     * @param custid the custid to set
     */
    public void setCustid(int custid) {
        this.custid = custid;
    }

    /**
     * @return the totalprice
     */
    public double getTotalprice() {
        return totalprice;
    }

    /**
     * @param totalprice the totalprice to set
     */
    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    
    
   
    
     
     //-----+--------+++++++++++++++++++++++++++++++++++++++++--------------------------
     public void addindb(){
        //e = new Event("bbb","bbb","bbb","bbb");
        b = new Books(0,getBtitle(),getBisbn(),getQuantity(),getPrice());
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(b);
        session.getTransaction().commit();
        session.close();
        
        clear();
            try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BookStorePelikSangat/faces/index.xhtml");
                    
            } 
            catch (IOException e) {}
            session.getTransaction().rollback();
	}
      
    public List<Books> getAllBooks() {
        List<Books> bs = new ArrayList<Books>();
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            
            bs = ((List<Books>) session.createQuery("from Books").list());
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return bs;
    }
      public List<Books> getBooksByIsbn(String bis) {
        System.out.println(bis);
//        Customer cust = null;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Books where bisbn = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", bis);
            //cust = (Customer) query.uniqueResult();
            List<Books> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
      public List<Books> getBooksById(int id) {
        System.out.println(id);
//        Customer cust = null;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Books where bookid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            //cust = (Customer) query.uniqueResult();
            List<Books> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
     
     //--------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^----------------
     
     public void setLb(List<Books> lb) {
         this.lb = lb;
        }
      public void makelist(){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       
        setLb((List<Books>) session.createQuery("from Books").list());
        
        
        session.getTransaction().commit();
        session.close();
        
    }
     
       public List<Books> getLb() {
        return lb;
    }
       
    public String getAllByIDShow(int id, String title, String isbn, int content,double pr) {
        this.bookid = id;
        this.btitle = title;
        this.bisbn = isbn;
        this.quantity = content;
        this.price=pr;
        return "/admin/update.xhtml";
    }
     public void updateB() {
        Books b2 = new Books(bookid, btitle, bisbn,quantity,price);
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Books set btitle = '"+ getBtitle()+"',bisbn='"+getBisbn() +"',quantity="+getQuantity()+",price="+getPrice()+" where bookid ="+getBookid());
        query.executeUpdate(); 
        session.getTransaction().commit();
        session.close();
       
    }
     
     public void testurl(){
         FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
        // returns something like "/myapplication/home.faces"
        String fullURI = servletRequest.getRequestURI();
        System.out.println("URi ni haaa:"+fullURI);
        saveurl = fullURI;
     }
     
     
     
     //----------------------------------
     //LOGIN - ADMIN
     //----------------------------------
       
        public String dologin(){
       
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String q = "from Admin where adminid=:userName and adminpwd=:password";
        Query query = session.createQuery(q);
        query.setParameter("userName", getAdminid());
        query.setParameter("password", getAdminpwd());
        
        if(query.list().size() == 0){
        System.out.println("Account does not exist!");
        return "loginadmin.xhtml";
               }else{
                    System.out.println("Login Success!");
                    setLa((List<Admin>) query.list());
                    HttpSession s = getSession();
                                    s.setAttribute("username", getAdminid());
                    
                    return "/BookStorePelikSangat/faces/admin/List.xhtml";
                }

       }
         public void setLa(List<Admin> la) {
        this.la = la;
         }
        public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserLogin() {
		HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return s.getAttribute("username").toString();
	}

	public String getUserSession() {
		HttpSession s = getSession();
                testurl();
		if (s.getAttribute("username") == null){
                        try {
                                   FacesContext.getCurrentInstance().getExternalContext()
                                 .redirect("/BookStorePelikSangat/faces/admin/loginadmin.xhtml");
                               } 
                        catch (IOException e) {}
                }
                return (String) s.getAttribute("username");
	}
        
        
        public void logout() {
	//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //session.invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         try {
                                   FacesContext.getCurrentInstance().getExternalContext()
                                 .redirect("/BookStorePelikSangat/faces/admin/loginadmin.xhtml");
                               } 
                        catch (IOException e) {}
	}
   
    
    
    //Finish 
     public void deletehuhu(int n){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        e =(Books) session.get(Books.class, n);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        makelist();
        
    }
     // %%%%%%%%%%%%%%%% User Control %%%%%%%%%%%%%%%%%%%%%%%%%%
      public void addindb2(){
        //e = new Event("bbb","bbb","bbb","bbb");
        u = new User(0,getUser(),getPwd());
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        clear();
            try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/BookStorePelikSangat/faces/index.xhtml");
            } 
            catch (IOException e) {}
        
	}
      public String dologin2(){
       
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String q = "from User where user=:userName and pwd=:password";
        Query query = session.createQuery(q);
        query.setParameter("userName", getUser());
        query.setParameter("password", getPwd());
        
        if(query.list().size() == 0){
        System.out.println("Account does not exist!");
        return "login.xhtml";
               }else{
                    System.out.println("Login Success!");
                    setLu((List<User>) query.list());
                    HttpSession s = getSession();
                                    s.setAttribute("username", getUser());
                    
                    return "success";
                }

       }
        
       

	public String getUserSession2() {
		HttpSession s = getSession();
                testurl();
		if (s.getAttribute("username") == null){
                        try {
                                   FacesContext.getCurrentInstance().getExternalContext()
                                 .redirect("/BookStorePelikSangat/faces/login.xhtml");
                               } 
                        catch (IOException e) {}
                }
                return (String) s.getAttribute("username");
	}
        
        
        public String logout2() {
	//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //session.invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         try {
                                   FacesContext.getCurrentInstance().getExternalContext()
                                 .redirect("/BookStorePelikSangat/faces/login.xhtml");
                                   return "success";
                               } 
                        catch (IOException e) {}
         return "error";
	}
     
     
     // &&&&&&&&&&&&&&&& End User Control &&&&&&&&&&&&&&&&&&&&&&
   
        
//%%%%%%%%%%%%%%%%%%%%%%%%%%Item Logic %%%%%%%%%%%%%%%%%%%%%%%%
        public void AddtoCart(int id){
        List<Books> itemdb ;    
        List<Integer> newcart = new ArrayList<>()    ;
        itemdb = getBooksById(id);    
        int ids = id;
        
        for(Books k:itemdb){  
        System.out.println("Quantity :"+k.quantity);  
        if (k.quantity>0){
            newcart.add(ids);
            System.out.println("Added to cartitem list with bookid"+ ids);
            setAfterBuy(ids);
            System.out.println("Quantity Updated");
        }
        else{
            System.out.println("Quantity is not enough !");
        }
        }  
        
        
        }
        public void setAfterBuy(int id){
            int ids = id;
            List<Books> itemdb ;    
            itemdb = getBooksById(id);    
            Books k = (Books)itemdb.get(0);
            k.quantity = k.quantity - 1;
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("update Books set btitle = '"+ k.getBtitle()+"',bisbn='"+k.getBisbn()+"',quantity="+k.quantity+",price="+k.price+" where bookid ="+ids);
            
            try{
                query.executeUpdate(); 
                session.getTransaction().commit();
                session.close();
            }
           catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }
            
            
        }
        
        //*************************END USER LOGIC****************************
     
}
