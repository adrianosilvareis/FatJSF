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
@Table(name = "fat_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatHistorico.findAll", query = "SELECT f FROM FatHistorico f"),
    @NamedQuery(name = "FatHistorico.findById", query = "SELECT f FROM FatHistorico f WHERE f.id = :id"),
    @NamedQuery(name = "FatHistorico.findByData", query = "SELECT f FROM FatHistorico f WHERE f.data = :data"),
    @NamedQuery(name = "FatHistorico.findByDescricao", query = "SELECT f FROM FatHistorico f WHERE f.descricao = :descricao")})
public class FatHistorico implements Serializable {
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
    @JoinTable(name = "fat_producao_has_historico", joinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "producao_id", referencedColumnName = "id")})
    @ManyToMany
    private List<FatProducao> fatProducaoList;
    @ManyToMany(mappedBy = "fatHistoricoList")
    private List<FatCaixa> fatCaixaList;
    @ManyToMany(mappedBy = "fatHistoricoList")
    private List<FatFatura> fatFaturaList;
    @ManyToMany(mappedBy = "fatHistoricoList")
    private List<FatGlosa> fatGlosaList;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne
    private FatUsuarios usuariosId;

    public FatHistorico() {
    }

    public FatHistorico(Integer id) {
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

    @XmlTransient
    public List<FatProducao> getFatProducaoList() {
        return fatProducaoList;
    }

    public void setFatProducaoList(List<FatProducao> fatProducaoList) {
        this.fatProducaoList = fatProducaoList;
    }

    @XmlTransient
    public List<FatCaixa> getFatCaixaList() {
        return fatCaixaList;
    }

    public void setFatCaixaList(List<FatCaixa> fatCaixaList) {
        this.fatCaixaList = fatCaixaList;
    }

    @XmlTransient
    public List<FatFatura> getFatFaturaList() {
        return fatFaturaList;
    }

    public void setFatFaturaList(List<FatFatura> fatFaturaList) {
        this.fatFaturaList = fatFaturaList;
    }

    @XmlTransient
    public List<FatGlosa> getFatGlosaList() {
        return fatGlosaList;
    }

    public void setFatGlosaList(List<FatGlosa> fatGlosaList) {
        this.fatGlosaList = fatGlosaList;
    }

    public FatUsuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(FatUsuarios usuariosId) {
        this.usuariosId = usuariosId;
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
        if (!(object instanceof FatHistorico)) {
            return false;
        }
        FatHistorico other = (FatHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatHistorico[ id=" + id + " ]";
    }
    
}
