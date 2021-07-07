/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jhona
 */
@Entity
@Table(name = "sapdetail")
@NamedQueries({
    @NamedQuery(name = "Sapdetail.findAll", query = "SELECT s FROM Sapdetail s"),
    @NamedQuery(name = "Sapdetail.findById", query = "SELECT s FROM Sapdetail s WHERE s.sapdetailPK.id = :id"),
    @NamedQuery(name = "Sapdetail.findByInvoiceid", query = "SELECT s FROM Sapdetail s WHERE s.sapdetailPK.invoiceid = :invoiceid"),
    @NamedQuery(name = "Sapdetail.findByUptakeid", query = "SELECT s FROM Sapdetail s WHERE s.sapdetailPK.uptakeid = :uptakeid")})
public class Sapdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SapdetailPK sapdetailPK;
    @JoinColumn(name = "invoiceid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Invoice invoice;
    @JoinColumn(name = "uptakeid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Uptake uptake;

    public Sapdetail() {
    }

    public Sapdetail(SapdetailPK sapdetailPK) {
        this.sapdetailPK = sapdetailPK;
    }

    public Sapdetail(int id, int invoiceid, int uptakeid) {
        this.sapdetailPK = new SapdetailPK(id, invoiceid, uptakeid);
    }

    public SapdetailPK getSapdetailPK() {
        return sapdetailPK;
    }

    public void setSapdetailPK(SapdetailPK sapdetailPK) {
        this.sapdetailPK = sapdetailPK;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Uptake getUptake() {
        return uptake;
    }

    public void setUptake(Uptake uptake) {
        this.uptake = uptake;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sapdetailPK != null ? sapdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapdetail)) {
            return false;
        }
        Sapdetail other = (Sapdetail) object;
        if ((this.sapdetailPK == null && other.sapdetailPK != null) || (this.sapdetailPK != null && !this.sapdetailPK.equals(other.sapdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sapdetail[ sapdetailPK=" + sapdetailPK + " ]";
    }
    
}
