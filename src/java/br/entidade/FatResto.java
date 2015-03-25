/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_resto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatResto.findAll", query = "SELECT f FROM FatResto f"),
    @NamedQuery(name = "FatResto.findById", query = "SELECT f FROM FatResto f WHERE f.id = :id"),
    @NamedQuery(name = "FatResto.findByData", query = "SELECT f FROM FatResto f WHERE f.data = :data"),
    @NamedQuery(name = "FatResto.findByFechamento", query = "SELECT f FROM FatResto f WHERE f.fechamento = :fechamento"),
    @NamedQuery(name = "FatResto.findByValor", query = "SELECT f FROM FatResto f WHERE f.valor = :valor")})
public class FatResto implements Serializable {
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
    @JoinColumn(name = "producao_id", referencedColumnName = "id")
    @ManyToOne
    private FatProducao producaoId;

    public FatResto() {
    }

    public FatResto(Integer id) {
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

    public FatProducao getProducaoId() {
        return producaoId;
    }

    public void setProducaoId(FatProducao producaoId) {
        this.producaoId = producaoId;
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
        if (!(object instanceof FatResto)) {
            return false;
        }
        FatResto other = (FatResto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatResto[ id=" + id + " ]";
    }
    
}
