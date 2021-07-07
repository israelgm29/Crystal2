/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "assigned")
@NamedQueries({
    @NamedQuery(name = "Assigned.findAll", query = "SELECT a FROM Assigned a"),
    @NamedQuery(name = "Assigned.findById", query = "SELECT a FROM Assigned a WHERE a.assignedPK.id = :id"),
    @NamedQuery(name = "Assigned.findByBeneficiaryid", query = "SELECT a FROM Assigned a WHERE a.assignedPK.beneficiaryid = :beneficiaryid"),
    @NamedQuery(name = "Assigned.findByMeasurerid", query = "SELECT a FROM Assigned a WHERE a.assignedPK.measurerid = :measurerid"),
    @NamedQuery(name = "Assigned.findMeasureByBeneficiaryId", query = "SELECT a.assignedPK.measurerid FROM Assigned a WHERE a.assignedPK.beneficiaryid = :beneficiaryid"),
    @NamedQuery(name = "Assigned.findByDebt", query = "SELECT a FROM Assigned a WHERE a.debt = :debt"),
    @NamedQuery(name = "Assigned.findByAssignmentdate", query = "SELECT a FROM Assigned a WHERE a.assignmentdate = :assignmentdate"),
    @NamedQuery(name = "Assigned.findByStatus", query = "SELECT a FROM Assigned a WHERE a.status = :status")})
public class Assigned implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssignedPK assignedPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "debt")
    private double debt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignmentdate")
    @Temporal(TemporalType.DATE)
    private Date assignmentdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "beneficiaryid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Beneficiary beneficiary;
    @JoinColumn(name = "measurerid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Measurer measurer;

    public Assigned() {
    }

    public Assigned(AssignedPK assignedPK) {
        this.assignedPK = assignedPK;
    }

    public Assigned(AssignedPK assignedPK, double debt, Date assignmentdate, String status) {
        this.assignedPK = assignedPK;
        this.debt = debt;
        this.assignmentdate = assignmentdate;
        this.status = status;
    }

    public Assigned(int id, int beneficiaryid, int measurerid) {
        this.assignedPK = new AssignedPK(id, beneficiaryid, measurerid);
    }

    public AssignedPK getAssignedPK() {
        return assignedPK;
    }

    public void setAssignedPK(AssignedPK assignedPK) {
        this.assignedPK = assignedPK;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Date getAssignmentdate() {
        return assignmentdate;
    }

    public void setAssignmentdate(Date assignmentdate) {
        this.assignmentdate = assignmentdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Measurer getMeasurer() {
        return measurer;
    }

    public void setMeasurer(Measurer measurer) {
        this.measurer = measurer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignedPK != null ? assignedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assigned)) {
            return false;
        }
        Assigned other = (Assigned) object;
        if ((this.assignedPK == null && other.assignedPK != null) || (this.assignedPK != null && !this.assignedPK.equals(other.assignedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+beneficiary.getLastname()+" "+beneficiary.getFirstname()+"";
    }
    
}
