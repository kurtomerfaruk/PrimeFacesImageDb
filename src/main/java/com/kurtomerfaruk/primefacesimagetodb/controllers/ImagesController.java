package com.kurtomerfaruk.primefacesimagetodb.controllers;

import com.kurtomerfaruk.primefacesimagetodb.controllers.util.MobilePageController;
import com.kurtomerfaruk.primefacesimagetodb.models.Images;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Omer Faruk Kurt
 * @Created on date 25/04/2017 16:31:47 
 * @blog http://kurtomerfaruk.com
 * @mail kurtomerfaruk@gmail.com 
 */

@Named(value = "imagesController")
@ViewScoped
public class ImagesController extends AbstractController<Images> {
    private static final long serialVersionUID = -4549216213990661616L;

    @Inject
    private MobilePageController mobilePageController;

    public ImagesController() {
        // Inform the Abstract parent controller of the concrete Images Entity
        super(Images.class);
    }

}
