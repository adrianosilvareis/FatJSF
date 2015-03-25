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
@Table(name = "fat_caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatCaixa.findAll", query = "SELECT f FROM FatCaixa f"),
    @NamedQuery(name = "FatCaixa.findById", query = "SELECT f FROM FatCaixa f WHERE f.id = :id"),
    @NamedQuery(name = "FatCaixa.findByData", query = "SELECT f FROM FatCaixa f WHERE f.data = :data")})
public class FatCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinTable(name = "fat_caixa_has_historico", joinColumns = {
        @JoinColumn(name = "caixa_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")})
    @ManyToMany
    private List<FatHistorico> fatHistoricoList;
    @JoinColumn(name = "entrada_id", referencedColumnName = "id")
    @ManyToOne
    private FatEntrada entradaId;
    @JoinColumn(name = "saida_id", referencedColumnName = "id")
    @ManyToOne
    private FatSaida saidaId;

    public FatCaixa() {
    }

    public FatCaixa(Integer id) {
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

    @XmlTransient
    public List<FatHistorico> getFatHistoricoList() {
        return fatHistoricoList;
    }

    public void setFatHistoricoList(List<FatHistorico> fatHistoricoList) {
        this.fatHistoricoList = fatHistoricoList;
    }

    public FatEntrada getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(FatEntrada entradaId) {
        this.entradaId = entradaId;
    }

    public FatSaida getSaidaId() {
        return saidaId;
    }

    public void setSaidaId(FatSaida saidaId) {
        this.saidaId = saidaId;
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
        if (!(object instanceof FatCaixa)) {
            return false;
        }
        FatCaixa other = (FatCaixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatCaixa[ id=" + id + " ]";
    }
    
}
