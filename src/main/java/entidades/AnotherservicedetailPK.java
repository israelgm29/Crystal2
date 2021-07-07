/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhona
 */
@Embeddable
public class AnotherservicedetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoiceid")
    private int invoiceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anotherserviceid")
    private int anotherserviceid;

    public AnotherservicedetailPK() {
    }

    public AnotherservicedetailPK(int id, int invoiceid, int anotherserviceid) {
        this.id = id;
        this.invoiceid = invoiceid;
        this.anotherserviceid = anotherserviceid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getAnotherserviceid() {
        return anotherserviceid;
    }

    public void setAnotherserviceid(int anotherserviceid) {
        this.anotherserviceid = anotherserviceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) invoiceid;
        hash += (int) anotherserviceid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnotherservicedetailPK)) {
            return false;
        }
        AnotherservicedetailPK other = (AnotherservicedetailPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.invoiceid != other.invoiceid) {
            return false;
        }
        if (this.anotherserviceid != other.anotherserviceid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AnotherservicedetailPK[ id=" + id + ", invoiceid=" + invoiceid + ", anotherserviceid=" + anotherserviceid + " ]";
    }
    
}
