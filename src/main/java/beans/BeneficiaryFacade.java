/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Beneficiary;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhona
 */
@Stateless
public class BeneficiaryFacade extends AbstractFacade<Beneficiary> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BeneficiaryFacade() {
        super(Beneficiary.class);
    }

    public Beneficiary findBeneficiaryByID(int id) {
        Beneficiary b = em.createNamedQuery("Beneficiary.findById", Beneficiary.class)
                .setParameter("id", id)
                .getSingleResult();
        System.out.println("El beneficiario encontado es "+b+"");
        return b;
    }

}
