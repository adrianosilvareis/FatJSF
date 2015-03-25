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
@Table(name = "fat_nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatNota.findAll", query = "SELECT f FROM FatNota f"),
    @NamedQuery(name = "FatNota.findById", query = "SELECT f FROM FatNota f WHERE f.id = :id"),
    @NamedQuery(name = "FatNota.findByData", query = "SELECT f FROM FatNota f WHERE f.data = :data"),
    @NamedQuery(name = "FatNota.findByEncerrado", query = "SELECT f FROM FatNota f WHERE f.encerrado = :encerrado"),
    @NamedQuery(name = "FatNota.findByValor", query = "SELECT f FROM FatNota f WHERE f.valor = :valor")})
public class FatNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "encerrado")
    private Boolean encerrado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "fatura_id", referencedColumnName = "id")
    @ManyToOne
    private FatFatura faturaId;
    @OneToMany(mappedBy = "notaId")
    private List<FatEntrada> fatEntradaList;
    @OneToMany(mappedBy = "notaId")
    private List<FatDevedores> fatDevedoresList;

    public FatNota() {
    }

    public FatNota(Integer id) {
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

    public Boolean getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(Boolean encerrado) {
        this.encerrado = encerrado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public FatFatura getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(FatFatura faturaId) {
        this.faturaId = faturaId;
    }

    @XmlTransient
    public List<FatEntrada> getFatEntradaList() {
        return fatEntradaList;
    }

    public void setFatEntradaList(List<FatEntrada> fatEntradaList) {
        this.fatEntradaList = fatEntradaList;
    }

    @XmlTransient
    public List<FatDevedores> getFatDevedoresList() {
        return fatDevedoresList;
    }

    public void setFatDevedoresList(List<FatDevedores> fatDevedoresList) {
        this.fatDevedoresList = fatDevedoresList;
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
        if (!(object instanceof FatNota)) {
            return false;
        }
        FatNota other = (FatNota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatNota[ id=" + id + " ]";
    }
    
}
