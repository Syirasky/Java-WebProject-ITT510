/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Crappy
 */
@WebService(serviceName = "WSTest")
public class WSTest {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

   
    @WebMethod(operationName = "GetListBook")
    public Books[] GetListBook() {
        //TODO write your implementation code here:
        StoreController sc = new StoreController();
        int i = 0;
        List<Books> bk ;
        bk = sc.getAllBooks();
        Books[] bookarray = new Books[bk.size()];
        for (Books p:bk){
            bookarray[i] = p;
            i++;
        }
        return bookarray;
    }
}
