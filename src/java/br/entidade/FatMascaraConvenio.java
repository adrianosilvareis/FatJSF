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
@Table(name = "fat_mascara_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatMascaraConvenio.findAll", query = "SELECT f FROM FatMascaraConvenio f"),
    @NamedQuery(name = "FatMascaraConvenio.findById", query = "SELECT f FROM FatMascaraConvenio f WHERE f.id = :id"),
    @NamedQuery(name = "FatMascaraConvenio.findByDescricao", query = "SELECT f FROM FatMascaraConvenio f WHERE f.descricao = :descricao")})
public class FatMascaraConvenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "mascaraConvenioId")
    private List<FatConvenio> fatConvenioList;

    public FatMascaraConvenio() {
    }

    public FatMascaraConvenio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FatConvenio> getFatConvenioList() {
        return fatConvenioList;
    }

    public void setFatConvenioList(List<FatConvenio> fatConvenioList) {
        this.fatConvenioList = fatConvenioList;
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
        if (!(object instanceof FatMascaraConvenio)) {
            return false;
        }
        FatMascaraConvenio other = (FatMascaraConvenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatMascaraConvenio[ id=" + id + " ]";
    }
    
}
