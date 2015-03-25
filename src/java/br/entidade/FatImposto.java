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
@Table(name = "fat_imposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatImposto.findAll", query = "SELECT f FROM FatImposto f"),
    @NamedQuery(name = "FatImposto.findById", query = "SELECT f FROM FatImposto f WHERE f.id = :id"),
    @NamedQuery(name = "FatImposto.findByDecricao", query = "SELECT f FROM FatImposto f WHERE f.decricao = :decricao"),
    @NamedQuery(name = "FatImposto.findByValor", query = "SELECT f FROM FatImposto f WHERE f.valor = :valor")})
public class FatImposto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "decricao")
    private String decricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @OneToMany(mappedBy = "impostoId")
    private List<FatFatura> fatFaturaList;
    @OneToMany(mappedBy = "impostoId")
    private List<FatRecurso> fatRecursoList;

    public FatImposto() {
    }

    public FatImposto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<FatFatura> getFatFaturaList() {
        return fatFaturaList;
    }

    public void setFatFaturaList(List<FatFatura> fatFaturaList) {
        this.fatFaturaList = fatFaturaList;
    }

    @XmlTransient
    public List<FatRecurso> getFatRecursoList() {
        return fatRecursoList;
    }

    public void setFatRecursoList(List<FatRecurso> fatRecursoList) {
        this.fatRecursoList = fatRecursoList;
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
        if (!(object instanceof FatImposto)) {
            return false;
        }
        FatImposto other = (FatImposto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatImposto[ id=" + id + " ]";
    }
    
}
