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
@Table(name = "fat_perda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatPerda.findAll", query = "SELECT f FROM FatPerda f"),
    @NamedQuery(name = "FatPerda.findById", query = "SELECT f FROM FatPerda f WHERE f.id = :id"),
    @NamedQuery(name = "FatPerda.findByData", query = "SELECT f FROM FatPerda f WHERE f.data = :data"),
    @NamedQuery(name = "FatPerda.findByDescricao", query = "SELECT f FROM FatPerda f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FatPerda.findByValor", query = "SELECT f FROM FatPerda f WHERE f.valor = :valor")})
public class FatPerda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "glosa_id", referencedColumnName = "id")
    @ManyToOne
    private FatGlosa glosaId;

    public FatPerda() {
    }

    public FatPerda(Integer id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public FatGlosa getGlosaId() {
        return glosaId;
    }

    public void setGlosaId(FatGlosa glosaId) {
        this.glosaId = glosaId;
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
        if (!(object instanceof FatPerda)) {
            return false;
        }
        FatPerda other = (FatPerda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatPerda[ id=" + id + " ]";
    }
    
}
