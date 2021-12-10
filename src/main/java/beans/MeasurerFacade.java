/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Measurer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jhona
 */
@Stateless
public class MeasurerFacade extends AbstractFacade<Measurer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MeasurerFacade() {
        super(Measurer.class);
    }
    
    public List findEnableMeasurer(){
        Query q  = (Query) em.createNativeQuery("SELECT id FROM Measurer  WHERE statusid = ?", Measurer.class).
                setParameter(1, 4);
                    
        return q.getResultList();
    }   
}
