/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_glosa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatGlosa.findAll", query = "SELECT f FROM FatGlosa f"),
    @NamedQuery(name = "FatGlosa.findById", query = "SELECT f FROM FatGlosa f WHERE f.id = :id"),
    @NamedQuery(name = "FatGlosa.findByData", query = "SELECT f FROM FatGlosa f WHERE f.data = :data"),
    @NamedQuery(name = "FatGlosa.findByFechado", query = "SELECT f FROM FatGlosa f WHERE f.fechado = :fechado"),
    @NamedQuery(name = "FatGlosa.findByValor", query = "SELECT f FROM FatGlosa f WHERE f.valor = :valor")})
public class FatGlosa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "fechado")
    private Boolean fechado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinTable(name = "fat_glosa_has_historico", joinColumns = {
        @JoinColumn(name = "glosa_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")})
    @ManyToMany
    private List<FatHistorico> fatHistoricoList;
    @OneToMany(mappedBy = "glosaId")
    private List<FatPerda> fatPerdaList;
    @OneToMany(mappedBy = "glosaId")
    private List<FatRecurso> fatRecursoList;
    @JoinColumn(name = "fatura_id", referencedColumnName = "id")
    @ManyToOne
    private FatFatura faturaId;

    public FatGlosa() {
    }

    public FatGlosa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getFechado() {
        return fechado;
    }

    public void setFechado(Boolean fechado) {
        this.fechado = fechado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<FatHistorico> getFatHistoricoList() {
        return fatHistoricoList;
    }

    public void setFatHistoricoList(List<FatHistorico> fatHistoricoList) {
        this.fatHistoricoList = fatHistoricoList;
    }

    @XmlTransient
    public List<FatPerda> getFatPerdaList() {
        return fatPerdaList;
    }

    public void setFatPerdaList(List<FatPerda> fatPerdaList) {
        this.fatPerdaList = fatPerdaList;
    }

    @XmlTransient
    public List<FatRecurso> getFatRecursoList() {
        return fatRecursoList;
    }

    public void setFatRecursoList(List<FatRecurso> fatRecursoList) {
        this.fatRecursoList = fatRecursoList;
    }

    public FatFatura getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(FatFatura faturaId) {
        this.faturaId = faturaId;
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
        if (!(object instanceof FatGlosa)) {
            return false;
        }
        FatGlosa other = (FatGlosa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatGlosa[ id=" + id + " ]";
    }
    
}
