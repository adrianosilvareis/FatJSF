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
@Table(name = "sft_input_unid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftInputUnid.findAll", query = "SELECT s FROM SftInputUnid s"),
    @NamedQuery(name = "SftInputUnid.findByUnidIdIdunid", query = "SELECT s FROM SftInputUnid s WHERE s.unidIdIdunid = :unidIdIdunid"),
    @NamedQuery(name = "SftInputUnid.findByUnidCodCodigo", query = "SELECT s FROM SftInputUnid s WHERE s.unidCodCodigo = :unidCodCodigo"),
    @NamedQuery(name = "SftInputUnid.findByUnidNmNmunid", query = "SELECT s FROM SftInputUnid s WHERE s.unidNmNmunid = :unidNmNmunid")})
public class SftInputUnid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unid_id_idunid")
    private Integer unidIdIdunid;
    @Column(name = "unid_cod_codigo")
    private Integer unidCodCodigo;
    @Column(name = "unid_nm_nmunid")
    private String unidNmNmunid;
    @OneToMany(mappedBy = "fkUnid")
    private List<SftOutputInco> sftOutputIncoList;
    @OneToMany(mappedBy = "fkUnid")
    private List<SftOutputGlos> sftOutputGlosList;
    @OneToMany(mappedBy = "fkUnid")
    private List<SftOutputPart> sftOutputPartList;

    public SftInputUnid() {
    }

    public SftInputUnid(Integer unidIdIdunid) {
        this.unidIdIdunid = unidIdIdunid;
    }

    public Integer getUnidIdIdunid() {
        return unidIdIdunid;
    }

    public void setUnidIdIdunid(Integer unidIdIdunid) {
        this.unidIdIdunid = unidIdIdunid;
    }

    public Integer getUnidCodCodigo() {
        return unidCodCodigo;
    }

    public void setUnidCodCodigo(Integer unidCodCodigo) {
        this.unidCodCodigo = unidCodCodigo;
    }

    public String getUnidNmNmunid() {
        return unidNmNmunid;
    }

    public void setUnidNmNmunid(String unidNmNmunid) {
        this.unidNmNmunid = unidNmNmunid;
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

    @XmlTransient
    public List<SftOutputPart> getSftOutputPartList() {
        return sftOutputPartList;
    }

    public void setSftOutputPartList(List<SftOutputPart> sftOutputPartList) {
        this.sftOutputPartList = sftOutputPartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidIdIdunid != null ? unidIdIdunid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftInputUnid)) {
            return false;
        }
        SftInputUnid other = (SftInputUnid) object;
        if ((this.unidIdIdunid == null && other.unidIdIdunid != null) || (this.unidIdIdunid != null && !this.unidIdIdunid.equals(other.unidIdIdunid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftInputUnid[ unidIdIdunid=" + unidIdIdunid + " ]";
    }
    
}
