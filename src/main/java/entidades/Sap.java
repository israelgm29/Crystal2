/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhona
 */
@Entity
@Table(name = "sap")
@NamedQueries({
    @NamedQuery(name = "Sap.findAll", query = "SELECT s FROM Sap s"),
    @NamedQuery(name = "Sap.findById", query = "SELECT s FROM Sap s WHERE s.id = :id"),
    @NamedQuery(name = "Sap.findByName", query = "SELECT s FROM Sap s WHERE s.name = :name"),
    @NamedQuery(name = "Sap.findByBasevolume", query = "SELECT s FROM Sap s WHERE s.basevolume = :basevolume"),
    @NamedQuery(name = "Sap.findByBaseprice", query = "SELECT s FROM Sap s WHERE s.baseprice = :baseprice"),
    @NamedQuery(name = "Sap.findByExtraprice", query = "SELECT s FROM Sap s WHERE s.extraprice = :extraprice")})
public class Sap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sapid", fetch = FetchType.LAZY)
    private Collection<Measurer> measurerCollection;

    public Sap() {
    }

    public Sap(Integer id) {
        this.id = id;
    }

    public Sap(Integer id, String name, float basevolume, double baseprice, double extraprice) {
        this.id = id;
        this.name = name;
        this.basevolume = basevolume;
        this.baseprice = baseprice;
        this.extraprice = extraprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Collection<Measurer> getMeasurerCollection() {
        return measurerCollection;
    }

    public void setMeasurerCollection(Collection<Measurer> measurerCollection) {
        this.measurerCollection = measurerCollection;
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
        if (!(object instanceof Sap)) {
            return false;
        }
        Sap other = (Sap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
