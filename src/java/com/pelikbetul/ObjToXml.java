/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;
import java.io.File;
import java.util.List;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
/**
 *
 * @author Crappy
 */
public class ObjToXml {
    public void createPayXml(){
        
            try{
                StoreController sc = new StoreController();
                int i = 0;
                List<Payment> pl ;
                pl = sc.getAllPayments();
                Payment pay = new Payment();
                pay = (Payment) pl.get(0);
                sc.getLp();
                System.out.println("Going Marshal..\nSize payment list "+pl.size());
                JAXBContext context = JAXBContext.newInstance(Pays.class);
                Marshaller marshaller = context.createMarshaller();

                /** output the XML in pretty format */
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                /** display the output in the console */
                marshaller.marshal(new Pays(pl), System.out);

                /** put the XML to the file - will be used by the unmarshal example */
                marshaller.marshal(new Pays(pl), new File("pay.xml"));
                System.out.println("Done..");
                
            } catch(JAXBException e) {
                e.printStackTrace();
            }
    }
}
