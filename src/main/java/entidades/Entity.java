/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhona
 */
@javax.persistence.Entity
@Table(name = "entity")
@NamedQueries({
    @NamedQuery(name = "Entity.findAll", query = "SELECT e FROM Entity e"),
    @NamedQuery(name = "Entity.findByProvince", query = "SELECT e FROM Entity e WHERE e.province = :province"),
    @NamedQuery(name = "Entity.findByCanton", query = "SELECT e FROM Entity e WHERE e.canton = :canton"),
    @NamedQuery(name = "Entity.findByCommunity", query = "SELECT e FROM Entity e WHERE e.community = :community"),
    @NamedQuery(name = "Entity.findByAddress", query = "SELECT e FROM Entity e WHERE e.address = :address"),
    @NamedQuery(name = "Entity.findByTelephone", query = "SELECT e FROM Entity e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Entity.findByEmail", query = "SELECT e FROM Entity e WHERE e.email = :email"),
    @NamedQuery(name = "Entity.findByRuc", query = "SELECT e FROM Entity e WHERE e.ruc = :ruc")})
public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "canton")
    private String canton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "community")
    private String community;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ruc")
    private String ruc;

    public Entity() {
    }

    public Entity(String province) {
        this.province = province;
    }

    public Entity(String province, String canton, String community, String address, String telephone, String email, String ruc) {
        this.province = province;
        this.canton = canton;
        this.community = community;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.ruc = ruc;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (province != null ? province.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) object;
        if ((this.province == null && other.province != null) || (this.province != null && !this.province.equals(other.province))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entity[ province=" + province + " ]";
    }
    
}
