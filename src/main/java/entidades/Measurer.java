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
import javax.validation.constraints.Size;

/**
 *
 * @author jhona
 */
@Entity
@Table(name = "measurer")
@NamedQueries({
    @NamedQuery(name = "Measurer.findAll", query = "SELECT m FROM Measurer m"),
    @NamedQuery(name = "Measurer.findById", query = "SELECT m FROM Measurer m WHERE m.id = :id"),
    @NamedQuery(name = "Measurer.findByNumber", query = "SELECT m FROM Measurer m WHERE m.number = :number"),
    @NamedQuery(name = "Measurer.findByInstallationdate", query = "SELECT m FROM Measurer m WHERE m.installationdate = :installationdate")})
public class Measurer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "installationdate")
    @Temporal(TemporalType.DATE)
    private Date installationdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measurerid", fetch = FetchType.LAZY)
    private Collection<Uptake> uptakeCollection;
    @JoinColumn(name = "sapid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sap sapid;
    @JoinColumn(name = "statusid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measurer", fetch = FetchType.LAZY)
    private Collection<Assigned> assignedCollection;

    public Measurer() {
    }

    public Measurer(Integer id) {
        this.id = id;
    }

    public Measurer(Integer id, String number, Date installationdate) {
        this.id = id;
        this.number = number;
        this.installationdate = installationdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getInstallationdate() {
        return installationdate;
    }

    public void setInstallationdate(Date installationdate) {
        this.installationdate = installationdate;
    }

    public Collection<Uptake> getUptakeCollection() {
        return uptakeCollection;
    }

    public void setUptakeCollection(Collection<Uptake> uptakeCollection) {
        this.uptakeCollection = uptakeCollection;
    }

    public Sap getSapid() {
        return sapid;
    }

    public void setSapid(Sap sapid) {
        this.sapid = sapid;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    public Collection<Assigned> getAssignedCollection() {
        return assignedCollection;
    }

    public void setAssignedCollection(Collection<Assigned> assignedCollection) {
        this.assignedCollection = assignedCollection;
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
        if (!(object instanceof Measurer)) {
            return false;
        }
        Measurer other = (Measurer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  number ;
    }
}
