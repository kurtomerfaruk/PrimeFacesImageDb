package com.kurtomerfaruk.primefacesimagetodb.services;

import com.kurtomerfaruk.primefacesimagetodb.models.Images;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Omer Faruk Kurt
 * @Created on date 25/04/2017 16:31:47 
 * @blog http://kurtomerfaruk.com
 * @mail kurtomerfaruk@gmail.com 
 */
@Stateless
public class ImagesFacade extends AbstractFacade<Images> {
    @PersistenceContext(unitName = "com.kurtomerfaruk_PrimeFacesImageToDb_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagesFacade() {
        super(Images.class);
    }

}
