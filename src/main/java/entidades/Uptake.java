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
@Table(name = "uptake")
@NamedQueries({
    @NamedQuery(name = "Uptake.findAll", query = "SELECT u FROM Uptake u"),
    @NamedQuery(name = "Uptake.findById", query = "SELECT u FROM Uptake u WHERE u.id = :id"),
    @NamedQuery(name = "Uptake.findByDatetaked", query = "SELECT u FROM Uptake u WHERE u.datetaked = :datetaked"),
    @NamedQuery(name = "Uptake.findByLastvaluetaken", query = "SELECT u FROM Uptake u WHERE u.lastvaluetaken = :lastvaluetaken"),
    @NamedQuery(name = "Uptake.findByCurrentvaluetaken", query = "SELECT u FROM Uptake u WHERE u.currentvaluetaken = :currentvaluetaken"),
    @NamedQuery(name = "Uptake.findByBasevolume", query = "SELECT u FROM Uptake u WHERE u.basevolume = :basevolume"),
    @NamedQuery(name = "Uptake.findByBaseprice", query = "SELECT u FROM Uptake u WHERE u.baseprice = :baseprice"),
    @NamedQuery(name = "Uptake.findByExtraprice", query = "SELECT u FROM Uptake u WHERE u.extraprice = :extraprice"),
    @NamedQuery(name = "Uptake.findByVolumeconsumed", query = "SELECT u FROM Uptake u WHERE u.volumeconsumed = :volumeconsumed"),
    @NamedQuery(name = "Uptake.findByVolumeexceeded", query = "SELECT u FROM Uptake u WHERE u.volumeexceeded = :volumeexceeded"),
    @NamedQuery(name = "Uptake.findByTotalprice", query = "SELECT u FROM Uptake u WHERE u.totalprice = :totalprice"),
    @NamedQuery(name = "Uptake.findByMeasureId", query = "SELECT u FROM Uptake u WHERE u.measurerid = :measurerid"),
    @NamedQuery(name = "Uptake.findByBilled", query = "SELECT u FROM Uptake u WHERE u.billed = :billed")})
public class Uptake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetaked")
    @Temporal(TemporalType.DATE)
    private Date datetaked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastvaluetaken")
    private float lastvaluetaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentvaluetaken")
    private float currentvaluetaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basevolume")
    private float basevolume;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baseprice")
    private double baseprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extraprice")
    private double extraprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumeconsumed")
    private float volumeconsumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumeexceeded")
    private float volumeexceeded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalprice")
    private double totalprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "billed")
    private boolean billed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uptake", fetch = FetchType.LAZY)
    private Collection<Sapdetail> sapdetailCollection;
    @JoinColumn(name = "measurerid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Measurer measurerid;

    public Uptake() {
    }

    public Uptake(Integer id) {
        this.id = id;
    }

    public Uptake(Integer id, Date datetaked, float lastvaluetaken, float currentvaluetaken, float basevolume, double baseprice, double extraprice, float volumeconsumed, float volumeexceeded, double totalprice, boolean billed) {
        this.id = id;
        this.datetaked = datetaked;
        this.lastvaluetaken = lastvaluetaken;
        this.currentvaluetaken = currentvaluetaken;
        this.basevolume = basevolume;
        this.baseprice = baseprice;
        this.extraprice = extraprice;
        this.volumeconsumed = volumeconsumed;
        this.volumeexceeded = volumeexceeded;
        this.totalprice = totalprice;
        this.billed = billed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetaked() {
        return datetaked;
    }

    public void setDatetaked(Date datetaked) {
        this.datetaked = datetaked;
    }

    public float getLastvaluetaken() {
        return lastvaluetaken;
    }

    public void setLastvaluetaken(float lastvaluetaken) {
        this.lastvaluetaken = lastvaluetaken;
    }

    public float getCurrentvaluetaken() {
        return currentvaluetaken;
    }

    public void setCurrentvaluetaken(float currentvaluetaken) {
        this.currentvaluetaken = currentvaluetaken;
    }

    public float getBasevolume() {
        return basevolume;
    }

    public void setBasevolume(float basevolume) {
        this.basevolume = basevolume;
    }

    public double getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(double baseprice) {
        this.baseprice = baseprice;
    }

    public double getExtraprice() {
        return extraprice;
    }

    public void setExtraprice(double extraprice) {
        this.extraprice = extraprice;
    }

    public float getVolumeconsumed() {
        return volumeconsumed;
    }

    public void setVolumeconsumed(float volumeconsumed) {
        this.volumeconsumed = volumeconsumed;
    }

    public float getVolumeexceeded() {
        return volumeexceeded;
    }

    public void setVolumeexceeded(float volumeexceeded) {
        this.volumeexceeded = volumeexceeded;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public boolean getBilled() {
        return billed;
    }

    public void setBilled(boolean billed) {
        this.billed = billed;
    }

    public Collection<Sapdetail> getSapdetailCollection() {
        return sapdetailCollection;
    }

    public void setSapdetailCollection(Collection<Sapdetail> sapdetailCollection) {
        this.sapdetailCollection = sapdetailCollection;
    }

    public Measurer getMeasurerid() {
        return measurerid;
    }

    public void setMeasurerid(Measurer measurerid) {
        this.measurerid = measurerid;
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
        if (!(object instanceof Uptake)) {
            return false;
        }
        Uptake other = (Uptake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Uptake[ id=" + id + " ]";
    }
    
}
