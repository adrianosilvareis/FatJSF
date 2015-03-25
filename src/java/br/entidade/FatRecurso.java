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
@Table(name = "fat_recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatRecurso.findAll", query = "SELECT f FROM FatRecurso f"),
    @NamedQuery(name = "FatRecurso.findById", query = "SELECT f FROM FatRecurso f WHERE f.id = :id"),
    @NamedQuery(name = "FatRecurso.findByData", query = "SELECT f FROM FatRecurso f WHERE f.data = :data"),
    @NamedQuery(name = "FatRecurso.findByRecurso", query = "SELECT f FROM FatRecurso f WHERE f.recurso = :recurso"),
    @NamedQuery(name = "FatRecurso.findByResposta", query = "SELECT f FROM FatRecurso f WHERE f.resposta = :resposta"),
    @NamedQuery(name = "FatRecurso.findByValor", query = "SELECT f FROM FatRecurso f WHERE f.valor = :valor")})
public class FatRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "recurso")
    private String recurso;
    @Column(name = "resposta")
    private Boolean resposta;
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "glosa_id", referencedColumnName = "id")
    @ManyToOne
    private FatGlosa glosaId;
    @JoinColumn(name = "imposto_id", referencedColumnName = "id")
    @ManyToOne
    private FatImposto impostoId;

    public FatRecurso() {
    }

    public FatRecurso(Integer id) {
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

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        this.resposta = resposta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public FatGlosa getGlosaId() {
        return glosaId;
    }

    public void setGlosaId(FatGlosa glosaId) {
        this.glosaId = glosaId;
    }

    public FatImposto getImpostoId() {
        return impostoId;
    }

    public void setImpostoId(FatImposto impostoId) {
        this.impostoId = impostoId;
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
        if (!(object instanceof FatRecurso)) {
            return false;
        }
        FatRecurso other = (FatRecurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatRecurso[ id=" + id + " ]";
    }
    
}
