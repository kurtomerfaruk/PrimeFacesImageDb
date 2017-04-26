package com.kurtomerfaruk.primefacesimagetodb.controllers;

import com.kurtomerfaruk.primefacesimagetodb.models.Images;
import com.kurtomerfaruk.primefacesimagetodb.services.ImagesFacade;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import org.omnifaces.util.Utils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Omer Faruk Kurt
 * @Created on date 25/04/2017 16:37:27 
 */
@ManagedBean
@ApplicationScoped
public class FileUploadController {

    @Inject
    private ImagesController imagesController;
    
    @EJB
    private ImagesFacade service;
    
    private StreamedContent image=null;

    public FileUploadController() {
    }

    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (image == null) {
            InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/user2-160x160.jpg");
            return new DefaultStreamedContent(is);
        }
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/user2-160x160.jpg");
            return new DefaultStreamedContent(is);
        }
        return image;
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }
    
    

    
    public void fileUpload(FileUploadEvent event){
         try {
            UploadedFile file = event.getFile();
            image = new DefaultStreamedContent(file.getInputstream(), "image/jpeg");
             Images images = imagesController.getSelected();
             images.setImage(Utils.toByteArray(image.getStream()));
             images.setName(file.getFileName());
             images.setSize(String.valueOf(file.getSize()));
             images.setExtension(file.getContentType());
             imagesController.setSelected(images);
            //imagesController.getSelected().setImage(Utils.toByteArray(new DefaultStreamedContent(file.getInputstream(), "image/jpeg").getStream()));
        } catch (Exception e) {
            System.out.println("Resim yuklenirken hata olustu:" + e.getMessage());
        }
    }
    
    public void imageClear(){
        image=null;
        
    }
    
    public void findImage(Integer imageId) {
        if (imageId != null) {
            Images images = service.find(imageId);
            if (images.getImage() != null) {
                image = new DefaultStreamedContent(new ByteArrayInputStream(images.getImage()));
            } 
        }
    }
    
}
