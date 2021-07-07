/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Assigned;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jhona
 */
@Stateless
public class AssignedFacade extends AbstractFacade<Assigned> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AssignedFacade() {
        super(Assigned.class);
    }
//Buscar todos los medidores que tenga el beneficiario ---> buscando por el id de beneficiario

    public List<Assigned> findMeasurerByBeneficiary(int id) {
        List<Assigned> lista = new ArrayList<>();
        lista=null;
        try {
            lista = em.createNamedQuery("Assigned.findByBeneficiaryid", Assigned.class)
                .setParameter("beneficiaryid", id)
                .getResultList(); 
        } catch (Exception e) {
             throw e;
        }
       
        //retorna la lista de medidores
        return lista;
        
    }

//// Buscar Beneficiario Simple por id --- Retorna un beneficiario de la clase Assignamed
//    public Assigned findSimpleBeneficiaryById(int benefId) {
////        System.err.println(benefId);
//        List<Assigned> assigned = new ArrayList<>();
//        assigned = em.createNativeQuery("SELECT DISTINCT ON (beneficiaryid) id, beneficiaryid, measurerid, debt, assignmentdate, status FROM public.assigned WHERE beneficiaryid = ?;", Assigned.class)
//                .setParameter(1, benefId)
//                .getResultList();
//        Assigned succsess = new Assigned();
//        for (int i = 0; i < assigned.size(); i++) {
//            succsess = assigned.get(i);
//            System.out.println(succsess.getBeneficiary());
//        }
//        return succsess;
//    }

}
