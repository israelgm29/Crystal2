/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Uptake;
import java.util.Iterator;
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
public class UptakeFacade extends AbstractFacade<Uptake> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UptakeFacade() {
        super(Uptake.class);
    }

    public Uptake findByMeasureId(int id) {
        Query query = em.createNativeQuery("SELECT * FROM uptake WHERE measurerid = ?;", Uptake.class)
                .setParameter(1, id);
        List<Uptake> lista = query.getResultList();
        Uptake asd = null;
        if (!lista.isEmpty()) {
            return lista.get(0);
        }else{
        return null;
        }
    }
}
