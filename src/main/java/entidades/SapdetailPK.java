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
public class SapdetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoiceid")
    private int invoiceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uptakeid")
    private int uptakeid;

    public SapdetailPK() {
    }

    public SapdetailPK(int id, int invoiceid, int uptakeid) {
        this.id = id;
        this.invoiceid = invoiceid;
        this.uptakeid = uptakeid;
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

    public int getUptakeid() {
        return uptakeid;
    }

    public void setUptakeid(int uptakeid) {
        this.uptakeid = uptakeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) invoiceid;
        hash += (int) uptakeid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SapdetailPK)) {
            return false;
        }
        SapdetailPK other = (SapdetailPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.invoiceid != other.invoiceid) {
            return false;
        }
        if (this.uptakeid != other.uptakeid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SapdetailPK[ id=" + id + ", invoiceid=" + invoiceid + ", uptakeid=" + uptakeid + " ]";
    }
    
}
