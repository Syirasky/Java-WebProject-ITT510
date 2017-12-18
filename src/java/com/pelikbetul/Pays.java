/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Crappy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Pays")
public class Pays {
@XmlElement(name = "payment", type = Payment.class)
private List<Payment> pay = new ArrayList<Payment>();
    public Pays(){
    }
    
    public Pays(List<Payment> pay){
        this.pay = pay;
    }
     public List<Payment> getPay() {
        return pay;
    }
 
    public void setPay(List<Payment> pay) {
        this.pay = pay;
    }   
    
}
