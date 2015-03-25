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
@Table(name = "fat_saida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatSaida.findAll", query = "SELECT f FROM FatSaida f"),
    @NamedQuery(name = "FatSaida.findById", query = "SELECT f FROM FatSaida f WHERE f.id = :id"),
    @NamedQuery(name = "FatSaida.findByData", query = "SELECT f FROM FatSaida f WHERE f.data = :data"),
    @NamedQuery(name = "FatSaida.findByDescricao", query = "SELECT f FROM FatSaida f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FatSaida.findByValor", query = "SELECT f FROM FatSaida f WHERE f.valor = :valor")})
public class FatSaida implements Serializable {
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
    @Column(name = "valor")
    private String valor;
    @OneToMany(mappedBy = "saidaId")
    private List<FatCaixa> fatCaixaList;
    @JoinColumn(name = "banco_id", referencedColumnName = "id")
    @ManyToOne
    private FatBanco bancoId;

    public FatSaida() {
    }

    public FatSaida(Integer id) {
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<FatCaixa> getFatCaixaList() {
        return fatCaixaList;
    }

    public void setFatCaixaList(List<FatCaixa> fatCaixaList) {
        this.fatCaixaList = fatCaixaList;
    }

    public FatBanco getBancoId() {
        return bancoId;
    }

    public void setBancoId(FatBanco bancoId) {
        this.bancoId = bancoId;
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
        if (!(object instanceof FatSaida)) {
            return false;
        }
        FatSaida other = (FatSaida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatSaida[ id=" + id + " ]";
    }
    
}
