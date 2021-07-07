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
public class AssignedPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beneficiaryid")
    private int beneficiaryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "measurerid")
    private int measurerid;

    public AssignedPK() {
    }

    public AssignedPK(int id, int beneficiaryid, int measurerid) {
        this.id = id;
        this.beneficiaryid = beneficiaryid;
        this.measurerid = measurerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBeneficiaryid() {
        return beneficiaryid;
    }

    public void setBeneficiaryid(int beneficiaryid) {
        this.beneficiaryid = beneficiaryid;
    }

    public int getMeasurerid() {
        return measurerid;
    }

    public void setMeasurerid(int measurerid) {
        this.measurerid = measurerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) beneficiaryid;
        hash += (int) measurerid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignedPK)) {
            return false;
        }
        AssignedPK other = (AssignedPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.beneficiaryid != other.beneficiaryid) {
            return false;
        }
        if (this.measurerid != other.measurerid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AssignedPK[ id=" + id + ", beneficiaryid=" + beneficiaryid + ", measurerid=" + measurerid + " ]";
    }
    
}
