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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "audit")
@NamedQueries({
    @NamedQuery(name = "Audit.findAll", query = "SELECT a FROM Audit a"),
    @NamedQuery(name = "Audit.findById", query = "SELECT a FROM Audit a WHERE a.id = :id"),
    @NamedQuery(name = "Audit.findByExecuteddate", query = "SELECT a FROM Audit a WHERE a.executeddate = :executeddate"),
    @NamedQuery(name = "Audit.findByTableaffected", query = "SELECT a FROM Audit a WHERE a.tableaffected = :tableaffected"),
    @NamedQuery(name = "Audit.findByActionname", query = "SELECT a FROM Audit a WHERE a.actionname = :actionname"),
    @NamedQuery(name = "Audit.findByDescription", query = "SELECT a FROM Audit a WHERE a.description = :description")})
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "executeddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executeddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tableaffected")
    private String tableaffected;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "actionname")
    private String actionname;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "operatorid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operator operatorid;

    public Audit() {
    }

    public Audit(Integer id) {
        this.id = id;
    }

    public Audit(Integer id, Date executeddate, String tableaffected, String actionname) {
        this.id = id;
        this.executeddate = executeddate;
        this.tableaffected = tableaffected;
        this.actionname = actionname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExecuteddate() {
        return executeddate;
    }

    public void setExecuteddate(Date executeddate) {
        this.executeddate = executeddate;
    }

    public String getTableaffected() {
        return tableaffected;
    }

    public void setTableaffected(String tableaffected) {
        this.tableaffected = tableaffected;
    }

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Operator getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Operator operatorid) {
        this.operatorid = operatorid;
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
        if (!(object instanceof Audit)) {
            return false;
        }
        Audit other = (Audit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Audit[ id=" + id + " ]";
    }
    
}
