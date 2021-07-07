/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Assigned;
import entidades.Beneficiary;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhona
 */
@Named(value = "assignedSearchController")
@SessionScoped
public class AssignedSearchController implements Serializable {

    private Assigned current;
    private Beneficiary beneficiary;
    @EJB
    private AssignedFacade facade;
    @EJB
    private BeneficiaryFacade beneficiaryFacade;

    public AssignedSearchController() {
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Assigned getCurrent() {
        return current;
    }

    public void setCurrent(Assigned current) {
        this.current = current;
    }

    public Assigned getSelected() {
        if (current == null) {
            current = new Assigned();
            current.setAssignedPK(new entidades.AssignedPK());

        }
        return current;
    }

    public void buscarAsignado() {
        System.out.println("El id entrante es" + current.getBeneficiary().getId() + "");
        Beneficiary b = new Beneficiary();
        b = beneficiaryFacade.findBeneficiaryByID(current.getBeneficiary().getId());
//
        if (b != null) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.getExternalContext().getSessionMap().put("Beneficiario", b);
        }

    }
    
     public void buscarNuevoAsignado() {
        System.out.println("El id entrante es" + current.getBeneficiary().getId() + "");
      
      Beneficiary beneficiary = beneficiaryFacade.findBeneficiaryByID(current.getBeneficiary().getId());
//
        if (beneficiary != null) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.getExternalContext().getSessionMap().put("NuevoAsignado", beneficiary);
        }

    }
    public void buscarMedidorBeneficiario() {
        try {
            List<Assigned> measurer = facade.findMeasurerByBeneficiary(current.getBeneficiary().getId());
            System.out.println("El id entrante es" + current.getBeneficiary().getId() + "");
            System.out.println(measurer.size());
            FacesContext context = FacesContext.getCurrentInstance();
            if (measurer.size() > 0) {

                context.getExternalContext().getSessionMap().put("currentmeasurer", measurer);
             
            } else {
                measurer = null;
                 FacesContext context3 = FacesContext.getCurrentInstance();
                 context3.getExternalContext().getSessionMap().put("currentmeasurer", measurer);
                context.getPartialViewContext().getEvalScripts().add(" swal({\n"
                        + "                    title: \"Atencion\",\n"
                        + "                    icon: \"info\",\n"
                        + "                    text: \" El Usuario seleccionado no tiene ningun medidor\",\n"
                        + "                    buttons: true,\n"
                        + "                    dangerMode: true,\n"
                        + "                });");
               
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

   
}
