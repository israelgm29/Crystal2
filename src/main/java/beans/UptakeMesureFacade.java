/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Uptake;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhona
 */
@Named(value = "uptakeMesureFacade")
@SessionScoped
public class UptakeMesureFacade implements Serializable {

   private int mesurerid;
   private UptakeFacade uf;
   private Uptake uptakeFinded;
    public UptakeMesureFacade() {
    }

    public int getMesurerid() {
        return mesurerid;
    }

    public void setMesurerid(int mesurerid) {
        this.mesurerid = mesurerid;
    }

    public UptakeFacade getUf() {
        return uf;
    }

    public void setUf(UptakeFacade uf) {
        this.uf = uf;
    }

   
    public void UptakeEstadist(){
    uptakeFinded = uf.find(mesurerid);
    FacesContext context = FacesContext.getCurrentInstance();
      if (uptakeFinded == null) {
            context.addMessage(null, new FacesMessage("El medidor no tiene aun consumo"));
            mesurerid =0 ;
        } else {
            if (uptakeFinded.getMeasurerid().equals(mesurerid)) {
                context.getExternalContext().getSessionMap().put("dataUptake", uptakeFinded);

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario o contraseña mal ", "Usuario o contrasela"));
            }
        }
    
    }

    public Uptake getUptakeFinded() {
        return uptakeFinded;
    }

    public void setUptakeFinded(Uptake uptakeFinded) {
        this.uptakeFinded = uptakeFinded;
    }
    
}
