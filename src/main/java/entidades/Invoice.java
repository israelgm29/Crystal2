/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhona
 */
@Entity
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id"),
    @NamedQuery(name = "Invoice.findByNumber", query = "SELECT i FROM Invoice i WHERE i.number = :number"),
    @NamedQuery(name = "Invoice.findByDateofissue", query = "SELECT i FROM Invoice i WHERE i.dateofissue = :dateofissue"),
    @NamedQuery(name = "Invoice.findByTotaltopay", query = "SELECT i FROM Invoice i WHERE i.totaltopay = :totaltopay"),
    @NamedQuery(name = "Invoice.findByPayed", query = "SELECT i FROM Invoice i WHERE i.payed = :payed")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofissue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofissue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaltopay")
    private double totaltopay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payed")
    private boolean payed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice", fetch = FetchType.LAZY)
    private Collection<Sapdetail> sapdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice", fetch = FetchType.LAZY)
    private Collection<Anotherservicedetail> anotherservicedetailCollection;
    @JoinColumn(name = "beneficiaryid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Beneficiary beneficiaryid;
    @JoinColumn(name = "debtcollectorid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operator debtcollectorid;

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Invoice(Integer id, int number, Date dateofissue, double totaltopay, boolean payed) {
        this.id = id;
        this.number = number;
        this.dateofissue = dateofissue;
        this.totaltopay = totaltopay;
        this.payed = payed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(Date dateofissue) {
        this.dateofissue = dateofissue;
    }

    public double getTotaltopay() {
        return totaltopay;
    }

    public void setTotaltopay(double totaltopay) {
        this.totaltopay = totaltopay;
    }

    public boolean getPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Collection<Sapdetail> getSapdetailCollection() {
        return sapdetailCollection;
    }

    public void setSapdetailCollection(Collection<Sapdetail> sapdetailCollection) {
        this.sapdetailCollection = sapdetailCollection;
    }

    public Collection<Anotherservicedetail> getAnotherservicedetailCollection() {
        return anotherservicedetailCollection;
    }

    public void setAnotherservicedetailCollection(Collection<Anotherservicedetail> anotherservicedetailCollection) {
        this.anotherservicedetailCollection = anotherservicedetailCollection;
    }

    public Beneficiary getBeneficiaryid() {
        return beneficiaryid;
    }

    public void setBeneficiaryid(Beneficiary beneficiaryid) {
        this.beneficiaryid = beneficiaryid;
    }

    public Operator getDebtcollectorid() {
        return debtcollectorid;
    }

    public void setDebtcollectorid(Operator debtcollectorid) {
        this.debtcollectorid = debtcollectorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Invoice[ id=" + id + " ]";
    }
    
}
