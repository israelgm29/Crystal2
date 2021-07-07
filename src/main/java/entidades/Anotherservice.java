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
@Table(name = "anotherservice")
@NamedQueries({
    @NamedQuery(name = "Anotherservice.findAll", query = "SELECT a FROM Anotherservice a"),
    @NamedQuery(name = "Anotherservice.findById", query = "SELECT a FROM Anotherservice a WHERE a.id = :id"),
    @NamedQuery(name = "Anotherservice.findByName", query = "SELECT a FROM Anotherservice a WHERE a.name = :name"),
    @NamedQuery(name = "Anotherservice.findByPrice", query = "SELECT a FROM Anotherservice a WHERE a.price = :price")})
public class Anotherservice implements Serializable {

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
    @Column(name = "price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anotherservice", fetch = FetchType.LAZY)
    private Collection<Anotherservicedetail> anotherservicedetailCollection;

    public Anotherservice() {
    }

    public Anotherservice(Integer id) {
        this.id = id;
    }

    public Anotherservice(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Collection<Anotherservicedetail> getAnotherservicedetailCollection() {
        return anotherservicedetailCollection;
    }

    public void setAnotherservicedetailCollection(Collection<Anotherservicedetail> anotherservicedetailCollection) {
        this.anotherservicedetailCollection = anotherservicedetailCollection;
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
        if (!(object instanceof Anotherservice)) {
            return false;
        }
        Anotherservice other = (Anotherservice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Anotherservice[ id=" + id + " ]";
    }
    
}
