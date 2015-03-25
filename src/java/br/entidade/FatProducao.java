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
@Table(name = "fat_producao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatProducao.findAll", query = "SELECT f FROM FatProducao f"),
    @NamedQuery(name = "FatProducao.findById", query = "SELECT f FROM FatProducao f WHERE f.id = :id"),
    @NamedQuery(name = "FatProducao.findByEnviado", query = "SELECT f FROM FatProducao f WHERE f.enviado = :enviado"),
    @NamedQuery(name = "FatProducao.findByFinal1", query = "SELECT f FROM FatProducao f WHERE f.final1 = :final1"),
    @NamedQuery(name = "FatProducao.findByInicial", query = "SELECT f FROM FatProducao f WHERE f.inicial = :inicial"),
    @NamedQuery(name = "FatProducao.findByValor", query = "SELECT f FROM FatProducao f WHERE f.valor = :valor")})
public class FatProducao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "enviado")
    private Boolean enviado;
    @Column(name = "final")
    @Temporal(TemporalType.DATE)
    private Date final1;
    @Column(name = "inicial")
    @Temporal(TemporalType.DATE)
    private Date inicial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @ManyToMany(mappedBy = "fatProducaoList")
    private List<FatHistorico> fatHistoricoList;
    @OneToMany(mappedBy = "producaoId")
    private List<FatResto> fatRestoList;
    @OneToMany(mappedBy = "producaoId")
    private List<FatFatura> fatFaturaList;
    @JoinColumn(name = "convenio_id", referencedColumnName = "id")
    @ManyToOne
    private FatConvenio convenioId;

    public FatProducao() {
    }

    public FatProducao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public Date getFinal1() {
        return final1;
    }

    public void setFinal1(Date final1) {
        this.final1 = final1;
    }

    public Date getInicial() {
        return inicial;
    }

    public void setInicial(Date inicial) {
        this.inicial = inicial;
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
    public List<FatResto> getFatRestoList() {
        return fatRestoList;
    }

    public void setFatRestoList(List<FatResto> fatRestoList) {
        this.fatRestoList = fatRestoList;
    }

    @XmlTransient
    public List<FatFatura> getFatFaturaList() {
        return fatFaturaList;
    }

    public void setFatFaturaList(List<FatFatura> fatFaturaList) {
        this.fatFaturaList = fatFaturaList;
    }

    public FatConvenio getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(FatConvenio convenioId) {
        this.convenioId = convenioId;
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
        if (!(object instanceof FatProducao)) {
            return false;
        }
        FatProducao other = (FatProducao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatProducao[ id=" + id + " ]";
    }
    
}
