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
@Table(name = "fat_fatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatFatura.findAll", query = "SELECT f FROM FatFatura f"),
    @NamedQuery(name = "FatFatura.findById", query = "SELECT f FROM FatFatura f WHERE f.id = :id"),
    @NamedQuery(name = "FatFatura.findByData", query = "SELECT f FROM FatFatura f WHERE f.data = :data"),
    @NamedQuery(name = "FatFatura.findByFechamento", query = "SELECT f FROM FatFatura f WHERE f.fechamento = :fechamento"),
    @NamedQuery(name = "FatFatura.findByValor", query = "SELECT f FROM FatFatura f WHERE f.valor = :valor")})
public class FatFatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "fechamento")
    private Boolean fechamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinTable(name = "fat_fatura_has_historico", joinColumns = {
        @JoinColumn(name = "fatura_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")})
    @ManyToMany
    private List<FatHistorico> fatHistoricoList;
    @OneToMany(mappedBy = "faturaId")
    private List<FatNota> fatNotaList;
    @JoinColumn(name = "imposto_id", referencedColumnName = "id")
    @ManyToOne
    private FatImposto impostoId;
    @JoinColumn(name = "producao_id", referencedColumnName = "id")
    @ManyToOne
    private FatProducao producaoId;
    @OneToMany(mappedBy = "faturaId")
    private List<FatGlosa> fatGlosaList;

    public FatFatura() {
    }

    public FatFatura(Integer id) {
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

    public Boolean getFechamento() {
        return fechamento;
    }

    public void setFechamento(Boolean fechamento) {
        this.fechamento = fechamento;
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
    public List<FatNota> getFatNotaList() {
        return fatNotaList;
    }

    public void setFatNotaList(List<FatNota> fatNotaList) {
        this.fatNotaList = fatNotaList;
    }

    public FatImposto getImpostoId() {
        return impostoId;
    }

    public void setImpostoId(FatImposto impostoId) {
        this.impostoId = impostoId;
    }

    public FatProducao getProducaoId() {
        return producaoId;
    }

    public void setProducaoId(FatProducao producaoId) {
        this.producaoId = producaoId;
    }

    @XmlTransient
    public List<FatGlosa> getFatGlosaList() {
        return fatGlosaList;
    }

    public void setFatGlosaList(List<FatGlosa> fatGlosaList) {
        this.fatGlosaList = fatGlosaList;
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
        if (!(object instanceof FatFatura)) {
            return false;
        }
        FatFatura other = (FatFatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatFatura[ id=" + id + " ]";
    }
    
}
