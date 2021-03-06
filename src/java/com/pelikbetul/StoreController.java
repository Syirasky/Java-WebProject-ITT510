/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;
import java.io.IOException;
import java.io.OutputStream;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
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
    private int loggedcustid;
    private double totalprice;
    private Payment pm;
    private List<Integer> cartitem;
    private List<Books> itemdb ;    
    private List<Integer> newcart = new ArrayList<>()    ;
    private List<Integer> a;
    private List<Books> p ;
    private List<Books> bookcart;
    private List<Books> test = new ArrayList<Books>();
     /**
     * @return the loggedcustid
     */
    public int getLoggedcustid() {
        return loggedcustid;
    }

    /**
     * @param loggedcustid the loggedcustid to set
     */
    public void setLoggedcustid(int loggedcustid) {
        this.loggedcustid = loggedcustid;
    }

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
        setBookcart(null);
        
        
    }
      /**
     * @return the bookcart
     */
    public List<Books> getBookcart() {
        return bookcart;
    }

    /**
     * @param bookcart the bookcart to set
     */
    public void setBookcart(List<Books> bookcart) {
        this.bookcart = bookcart;
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
        try{
                session = NewHibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(b);
                session.getTransaction().commit();
                session.close();

                clear();
                    try{
                            FacesContext.getCurrentInstance().getExternalContext().redirect("/BookStorePelikSangat/faces/admin/List.xhtml");

                    } 
                    catch (IOException e) {
                    }

	}
        catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }}
     
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
     public List<Payment> getAllPayments() {
        List<Payment> bs = new ArrayList<Payment>();
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            
            bs = ((List<Payment>) session.createQuery("from Payment").list());
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        setLp(bs);
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
     public String updateB() {
        Books b2 = new Books(bookid, btitle, bisbn,quantity,price);
            try{    session = NewHibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("update Books set btitle = '"+ getBtitle()+"',bisbn='"+getBisbn() +"',quantity="+getQuantity()+",price="+getPrice()+" where bookid ="+getBookid());
                query.executeUpdate(); 
                session.getTransaction().commit();
                session.close();
            } catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }
            
       return "/admin/List.xhtml";
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
        try{
                session = NewHibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                e =(Books) session.get(Books.class, n);
                session.delete(e);
                session.getTransaction().commit();
                session.close();
                makelist();
       } catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }
    }
     // %%%%%%%%%%%%%%%% User Control %%%%%%%%%%%%%%%%%%%%%%%%%%
      public void addindb2(){
        //e = new Event("bbb","bbb","bbb","bbb");
        u = new User(0,getUser(),getPwd());
       try{ 
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
        } catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }
	}
      public String dologin2(){
       
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String q = "from User where user=:userName2 and pwd=:password2";
        Query query = session.createQuery(q);
        query.setParameter("userName2", getUser());
        query.setParameter("password2", getPwd());
        
        if(query.list().size() == 0){
        System.out.println("Account does not exist!");
        return "login.xhtml";
               }else{
                    System.out.println("Login Success!");
                    setLu((List<User>) query.list());
                    HttpSession s = getSession();
                                    s.setAttribute("username2", getUser());
                    List<User> userlist = new ArrayList<User>(); 
                    userlist = getLu();
                    for(User k:userlist){
                         setLoggedcustid(k.getId());
                     }
                    
                    return "success";
                }

       }
        
       

	public String getUserSession2() {
		HttpSession s = getSession();
                testurl();
		if (s.getAttribute("username2") == null){
                        try {
                                   FacesContext.getCurrentInstance().getExternalContext()
                                 .redirect("/BookStorePelikSangat/faces/login.xhtml");
                               } 
                        catch (IOException e) {}
                }
                return (String) s.getAttribute("username2");
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
        
        itemdb= getBooksById(id);
        int ids = id;
        
        for(Books k:itemdb){  
        System.out.println("Quantity :"+k.quantity);  
        if (k.quantity>0){
            newcart.add(ids);
            System.out.println("Added to cartitem list with bookid"+ ids);
            setAfterBuy(ids);
            System.out.println("Quantity Updated");
            setCartitem(newcart);
            System.out.println("setCartitem :"+getCartitem().size());
            System.out.println("New cart :"+newcart.size());
            test.add(k);
        }
        else{
            System.out.println("Quantity is not enough !");
            }
        }
        setBookcart(test);
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
        
       public double calculateTotal(){
           double tot = 0.0;
           List<Books> bcpay = new ArrayList<Books>();
           bcpay = getBookcart();
           System.out.println("bcpay size :"+ bcpay.size());
           for(Books k:bcpay){
              System.out.println(k.getPrice()); 
              tot = k.getPrice() + tot;
              
           }
           System.out.println("Total Price : "+tot);
           setTotalprice(tot);
           return tot;
       } 
        
        public void addindbpayment(){
        //e = new Event("bbb","bbb","bbb","bbb");
       
       
        double tot = calculateTotal();
        Payment pms = new Payment(0,getLoggedcustid(),tot);
        
        System.out.println("NI Payment "+getLoggedcustid()+" "+pms.getPaymentid()+" "+pms.getTotalprice());
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pms);
        try 
        {
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
                session.getTransaction().rollback();
                session.close();
           }
        clear();
        setBookcart(null);
        test.clear();
        itemdb.clear();
        
        
           try{
                  FacesContext.getCurrentInstance().getExternalContext().redirect("/BookStorePelikSangat/faces/index.xhtml");
          } 
          catch (IOException e) {}
        
	}
        
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&DOWNLOAD REPORT&&&&&&&&&&&&&&&&&&&&&&&&
        public void downloadPdf() throws IOException {
        // Get the FacesContext
        FacesContext facesContext = FacesContext.getCurrentInstance();
         String PDF_URL = "http://localhost:8080/BookStorePelikSangat/faces/admin/New.txt";
        // Get HTTP response
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
         
        // Set response headers
        response.reset();   // Reset the response in the first place
        response.setHeader("Content-Type", "application/text");  // Set only the content type
         
        // Open response output stream
        OutputStream responseOutputStream = response.getOutputStream();
         
        // Read PDF contents
        URL url = new URL(PDF_URL);
        InputStream pdfInputStream = url.openStream();
         
        // Read PDF contents and write them to the output
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
         
        // Make sure that everything is out
        responseOutputStream.flush();
          
        // Close both streams
        pdfInputStream.close();
        responseOutputStream.close();
         
        // JSF doc: 
        // Signal the JavaServer Faces implementation that the HTTP response for this request has already been generated 
        // (such as an HTTP redirect), and that the request processing lifecycle should be terminated
        // as soon as the current phase is completed.
        facesContext.responseComplete();
         
    }   
        
        public void CreateReport(){
              ObjToXml o2x = new ObjToXml();
              o2x.createPayXml();
        }
        
        //********************************************************************
     
}
