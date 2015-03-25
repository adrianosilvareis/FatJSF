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
@Table(name = "sft_input_ncon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftInputNcon.findAll", query = "SELECT s FROM SftInputNcon s"),
    @NamedQuery(name = "SftInputNcon.findByNconIdIdncon", query = "SELECT s FROM SftInputNcon s WHERE s.nconIdIdncon = :nconIdIdncon"),
    @NamedQuery(name = "SftInputNcon.findByNconNmNmncon", query = "SELECT s FROM SftInputNcon s WHERE s.nconNmNmncon = :nconNmNmncon")})
public class SftInputNcon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ncon_id_idncon")
    private Integer nconIdIdncon;
    @Column(name = "ncon_nm_nmncon")
    private String nconNmNmncon;
    @OneToMany(mappedBy = "fkNcon")
    private List<SftOutputInco> sftOutputIncoList;
    @OneToMany(mappedBy = "fkNcon")
    private List<SftOutputGlos> sftOutputGlosList;

    public SftInputNcon() {
    }

    public SftInputNcon(Integer nconIdIdncon) {
        this.nconIdIdncon = nconIdIdncon;
    }

    public Integer getNconIdIdncon() {
        return nconIdIdncon;
    }

    public void setNconIdIdncon(Integer nconIdIdncon) {
        this.nconIdIdncon = nconIdIdncon;
    }

    public String getNconNmNmncon() {
        return nconNmNmncon;
    }

    public void setNconNmNmncon(String nconNmNmncon) {
        this.nconNmNmncon = nconNmNmncon;
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
        hash += (nconIdIdncon != null ? nconIdIdncon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftInputNcon)) {
            return false;
        }
        SftInputNcon other = (SftInputNcon) object;
        if ((this.nconIdIdncon == null && other.nconIdIdncon != null) || (this.nconIdIdncon != null && !this.nconIdIdncon.equals(other.nconIdIdncon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftInputNcon[ nconIdIdncon=" + nconIdIdncon + " ]";
    }
    
}
