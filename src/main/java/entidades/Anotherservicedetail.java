/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhona
 */
@Entity
@Table(name = "anotherservicedetail")
@NamedQueries({
    @NamedQuery(name = "Anotherservicedetail.findAll", query = "SELECT a FROM Anotherservicedetail a"),
    @NamedQuery(name = "Anotherservicedetail.findById", query = "SELECT a FROM Anotherservicedetail a WHERE a.anotherservicedetailPK.id = :id"),
    @NamedQuery(name = "Anotherservicedetail.findByInvoiceid", query = "SELECT a FROM Anotherservicedetail a WHERE a.anotherservicedetailPK.invoiceid = :invoiceid"),
    @NamedQuery(name = "Anotherservicedetail.findByAnotherserviceid", query = "SELECT a FROM Anotherservicedetail a WHERE a.anotherservicedetailPK.anotherserviceid = :anotherserviceid"),
    @NamedQuery(name = "Anotherservicedetail.findByPrice", query = "SELECT a FROM Anotherservicedetail a WHERE a.price = :price")})
public class Anotherservicedetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnotherservicedetailPK anotherservicedetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "anotherserviceid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Anotherservice anotherservice;
    @JoinColumn(name = "invoiceid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Invoice invoice;

    public Anotherservicedetail() {
    }

    public Anotherservicedetail(AnotherservicedetailPK anotherservicedetailPK) {
        this.anotherservicedetailPK = anotherservicedetailPK;
    }

    public Anotherservicedetail(AnotherservicedetailPK anotherservicedetailPK, double price) {
        this.anotherservicedetailPK = anotherservicedetailPK;
        this.price = price;
    }

    public Anotherservicedetail(int id, int invoiceid, int anotherserviceid) {
        this.anotherservicedetailPK = new AnotherservicedetailPK(id, invoiceid, anotherserviceid);
    }

    public AnotherservicedetailPK getAnotherservicedetailPK() {
        return anotherservicedetailPK;
    }

    public void setAnotherservicedetailPK(AnotherservicedetailPK anotherservicedetailPK) {
        this.anotherservicedetailPK = anotherservicedetailPK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Anotherservice getAnotherservice() {
        return anotherservice;
    }

    public void setAnotherservice(Anotherservice anotherservice) {
        this.anotherservice = anotherservice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anotherservicedetailPK != null ? anotherservicedetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anotherservicedetail)) {
            return false;
        }
        Anotherservicedetail other = (Anotherservicedetail) object;
        if ((this.anotherservicedetailPK == null && other.anotherservicedetailPK != null) || (this.anotherservicedetailPK != null && !this.anotherservicedetailPK.equals(other.anotherservicedetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Anotherservicedetail[ anotherservicedetailPK=" + anotherservicedetailPK + " ]";
    }
    
}
