/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pelikbetul;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.io.InputStream;
import javax.faces.context.FacesContext;
/**
 *
 * @author Crappy
 */
@Named(value = "fileDownloadView")
@SessionScoped
public class FileDownloadView implements Serializable {

       
    private StreamedContent file;
     
    public FileDownloadView() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pay.xml");
        file = new DefaultStreamedContent(stream, "text/xml", "report_payment.xml");
    }
 
    public StreamedContent getFile() {
        return file;
    }
}
