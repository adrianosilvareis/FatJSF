/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "sft_input_stat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftInputStat.findAll", query = "SELECT s FROM SftInputStat s"),
    @NamedQuery(name = "SftInputStat.findByStatusIdIdstatus", query = "SELECT s FROM SftInputStat s WHERE s.statusIdIdstatus = :statusIdIdstatus"),
    @NamedQuery(name = "SftInputStat.findByStatusNmDescricao", query = "SELECT s FROM SftInputStat s WHERE s.statusNmDescricao = :statusNmDescricao")})
public class SftInputStat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id_idstatus")
    private Integer statusIdIdstatus;
    @Column(name = "status_nm_descricao")
    private String statusNmDescricao;
    @OneToMany(mappedBy = "fkStat")
    private List<SftOutputInco> sftOutputIncoList;
    @OneToMany(mappedBy = "fkStat")
    private List<SftOutputGlos> sftOutputGlosList;

    public SftInputStat() {
    }

    public SftInputStat(Integer statusIdIdstatus) {
        this.statusIdIdstatus = statusIdIdstatus;
    }

    public Integer getStatusIdIdstatus() {
        return statusIdIdstatus;
    }

    public void setStatusIdIdstatus(Integer statusIdIdstatus) {
        this.statusIdIdstatus = statusIdIdstatus;
    }

    public String getStatusNmDescricao() {
        return statusNmDescricao;
    }

    public void setStatusNmDescricao(String statusNmDescricao) {
        this.statusNmDescricao = statusNmDescricao;
    }

    @XmlTransient
    public List<SftOutputInco> getSftOutputIncoList() {
        return sftOutputIncoList;
    }

    public void setSftOutputIncoList(List<SftOutputInco> sftOutputIncoList) {
        this.sftOutputIncoList = sftOutputIncoList;
    }

    @XmlTransient
    public List<SftOutputGlos> getSftOutputGlosList() {
        return sftOutputGlosList;
    }

    public void setSftOutputGlosList(List<SftOutputGlos> sftOutputGlosList) {
        this.sftOutputGlosList = sftOutputGlosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusIdIdstatus != null ? statusIdIdstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftInputStat)) {
            return false;
        }
        SftInputStat other = (SftInputStat) object;
        if ((this.statusIdIdstatus == null && other.statusIdIdstatus != null) || (this.statusIdIdstatus != null && !this.statusIdIdstatus.equals(other.statusIdIdstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftInputStat[ statusIdIdstatus=" + statusIdIdstatus + " ]";
    }
    
}
