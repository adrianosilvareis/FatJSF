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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "fat_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatConvenio.findAll", query = "SELECT f FROM FatConvenio f"),
    @NamedQuery(name = "FatConvenio.findById", query = "SELECT f FROM FatConvenio f WHERE f.id = :id"),
    @NamedQuery(name = "FatConvenio.findByCodigo", query = "SELECT f FROM FatConvenio f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "FatConvenio.findByDescricao", query = "SELECT f FROM FatConvenio f WHERE f.descricao = :descricao")})
public class FatConvenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "fkConv")
    private List<SftOutputInco> sftOutputIncoList;
    @JoinColumn(name = "mascara_convenio_id", referencedColumnName = "id")
    @ManyToOne
    private FatMascaraConvenio mascaraConvenioId;
    @OneToMany(mappedBy = "fkConv")
    private List<SftOutputGlos> sftOutputGlosList;
    @OneToMany(mappedBy = "convenioId")
    private List<FatProducao> fatProducaoList;

    public FatConvenio() {
    }

    public FatConvenio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<SftOutputInco> getSftOutputIncoList() {
        return sftOutputIncoList;
    }

    public void setSftOutputIncoList(List<SftOutputInco> sftOutputIncoList) {
        this.sftOutputIncoList = sftOutputIncoList;
    }

    public FatMascaraConvenio getMascaraConvenioId() {
        return mascaraConvenioId;
    }

    public void setMascaraConvenioId(FatMascaraConvenio mascaraConvenioId) {
        this.mascaraConvenioId = mascaraConvenioId;
    }

    @XmlTransient
    public List<SftOutputGlos> getSftOutputGlosList() {
        return sftOutputGlosList;
    }

    public void setSftOutputGlosList(List<SftOutputGlos> sftOutputGlosList) {
        this.sftOutputGlosList = sftOutputGlosList;
    }

    @XmlTransient
    public List<FatProducao> getFatProducaoList() {
        return fatProducaoList;
    }

    public void setFatProducaoList(List<FatProducao> fatProducaoList) {
        this.fatProducaoList = fatProducaoList;
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
        if (!(object instanceof FatConvenio)) {
            return false;
        }
        FatConvenio other = (FatConvenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatConvenio[ id=" + id + " ]";
    }
    
}
