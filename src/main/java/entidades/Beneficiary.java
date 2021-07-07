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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "beneficiary")
@NamedQueries({
    @NamedQuery(name = "Beneficiary.findAll", query = "SELECT b FROM Beneficiary b"),
    @NamedQuery(name = "Beneficiary.findById", query = "SELECT b FROM Beneficiary b WHERE b.id = :id"),
    @NamedQuery(name = "Beneficiary.findByDni", query = "SELECT b FROM Beneficiary b WHERE b.dni = :dni"),
    @NamedQuery(name = "Beneficiary.findByLastname", query = "SELECT b FROM Beneficiary b WHERE b.lastname = :lastname"),
    @NamedQuery(name = "Beneficiary.findByFirstname", query = "SELECT b FROM Beneficiary b WHERE b.firstname = :firstname"),
    @NamedQuery(name = "Beneficiary.findByTelephone", query = "SELECT b FROM Beneficiary b WHERE b.telephone = :telephone"),
    @NamedQuery(name = "Beneficiary.findByAddress", query = "SELECT b FROM Beneficiary b WHERE b.address = :address"),
    @NamedQuery(name = "Beneficiary.findByPlacereference", query = "SELECT b FROM Beneficiary b WHERE b.placereference = :placereference")})
public class Beneficiary implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 13)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address")
    private String address;
    @Size(max = 2147483647)
    @Column(name = "placereference")
    private String placereference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "genero")
    private String genero;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "villageid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Village villageid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiary", fetch = FetchType.LAZY)
    private Collection<Assigned> assignedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiaryid", fetch = FetchType.LAZY)
    private Collection<Invoice> invoiceCollection;

    public Beneficiary() {
    }

    public Beneficiary(Integer id) {
        this.id = id;
    }

    public Beneficiary(Integer id, String dni, String lastname, String firstname, String address) {
        this.id = id;
        this.dni = dni;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Village getVillageid() {
        return villageid;
    }

    public void setVillageid(Village villageid) {
        this.villageid = villageid;
    }

    public Collection<Assigned> getAssignedCollection() {
        return assignedCollection;
    }

    public void setAssignedCollection(Collection<Assigned> assignedCollection) {
        this.assignedCollection = assignedCollection;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
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
        if (!(object instanceof Beneficiary)) {
            return false;
        }
        Beneficiary other = (Beneficiary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlacereference() {
        return placereference;
    }

    public void setPlacereference(String placereference) {
        this.placereference = placereference;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "" +lastname  + " " + firstname + "";
    }
}
