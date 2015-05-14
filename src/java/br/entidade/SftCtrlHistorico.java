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
@Table(name = "sft_ctrl_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftCtrlHistorico.findAll", query = "SELECT s FROM SftCtrlHistorico s"),
    @NamedQuery(name = "SftCtrlHistorico.findByHistIdIdhist", query = "SELECT s FROM SftCtrlHistorico s WHERE s.histIdIdhist = :histIdIdhist"),
    @NamedQuery(name = "SftCtrlHistorico.findByHistDtRegis", query = "SELECT s FROM SftCtrlHistorico s WHERE s.histDtRegis = :histDtRegis"),
    @NamedQuery(name = "SftCtrlHistorico.findByHistNmDescricao", query = "SELECT s FROM SftCtrlHistorico s WHERE s.histNmDescricao = :histNmDescricao")})
public class SftCtrlHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hist_id_idhist")
    private Integer histIdIdhist;
    @Column(name = "hist_dt_regis")
    @Temporal(TemporalType.TIMESTAMP)
    private Date histDtRegis;
    @Column(name = "hist_nm_descricao")
    private String histNmDescricao;
    @JoinTable(name = "sft_inco_has_historico", joinColumns = {
        @JoinColumn(name = "idhist", referencedColumnName = "hist_id_idhist")}, inverseJoinColumns = {
        @JoinColumn(name = "idinco", referencedColumnName = "inco_id_idinco")})
    @ManyToMany
    private List<SftOutputInco> sftOutputIncoList;
    @JoinTable(name = "sft_part_has_historico", joinColumns = {
        @JoinColumn(name = "idhist", referencedColumnName = "hist_id_idhist")}, inverseJoinColumns = {
        @JoinColumn(name = "idpart", referencedColumnName = "part_id_idpart")})
    @ManyToMany
    private List<SftOutputPart> sftOutputPartList;
    @ManyToMany(mappedBy = "sftCtrlHistoricoList")
    private List<SftOutputGlos> sftOutputGlosList;
    @JoinColumn(name = "fk_acao", referencedColumnName = "acao_id_idacao")
    @ManyToOne
    private SftCtrlAcao fkAcao;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne
    private FatUsuarios usuariosId;
    @OneToMany(mappedBy = "historico")
    private List<SftOutputDesc> sftOutputDescList;
    @OneToMany(mappedBy = "historico")
    private List<SftOutputCort> sftOutputCortList;
    
    public SftCtrlHistorico() {
    }

    public SftCtrlHistorico(Integer histIdIdhist) {
        this.histIdIdhist = histIdIdhist;
    }

    public Integer getHistIdIdhist() {
        return histIdIdhist;
    }

    public void setHistIdIdhist(Integer histIdIdhist) {
        this.histIdIdhist = histIdIdhist;
    }

    public Date getHistDtRegis() {
        return histDtRegis;
    }

    public void setHistDtRegis(Date histDtRegis) {
        this.histDtRegis = histDtRegis;
    }

    public String getHistNmDescricao() {
        return histNmDescricao;
    }

    public void setHistNmDescricao(String histNmDescricao) {
        this.histNmDescricao = histNmDescricao;
    }

    @XmlTransient
    public List<SftOutputInco> getSftOutputIncoList() {
        return sftOutputIncoList;
    }

    public void setSftOutputIncoList(List<SftOutputInco> sftOutputIncoList) {
        this.sftOutputIncoList = sftOutputIncoList;
    }

    @XmlTransient
    public List<SftOutputGlos> getSftOutputGlosList() {
        return sftOutputGlosList;
    }

    public void setSftOutputGlosList(List<SftOutputGlos> sftOutputGlosList) {
        this.sftOutputGlosList = sftOutputGlosList;
    }

    public SftCtrlAcao getFkAcao() {
        return fkAcao;
    }

    public void setFkAcao(SftCtrlAcao fkAcao) {
        this.fkAcao = fkAcao;
    }

    public FatUsuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(FatUsuarios usuariosId) {
        this.usuariosId = usuariosId;
    }

    @XmlTransient
    public List<SftOutputDesc> getSftOutputDescList() {
        return sftOutputDescList;
    }

    public void setSftOutputDescList(List<SftOutputDesc> sftOutputDescList) {
        this.sftOutputDescList = sftOutputDescList;
    }

    @XmlTransient
    public List<SftOutputCort> getSftOutputCortList() {
        return sftOutputCortList;
    }

    public void setSftOutputCortList(List<SftOutputCort> sftOutputCortList) {
        this.sftOutputCortList = sftOutputCortList;
    }

    @XmlTransient
    public List<SftOutputPart> getSftOutputPartList() {
        return sftOutputPartList;
    }

    public void setSftOutputPartList(List<SftOutputPart> sftOutputPartList) {
        this.sftOutputPartList = sftOutputPartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histIdIdhist != null ? histIdIdhist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftCtrlHistorico)) {
            return false;
        }
        SftCtrlHistorico other = (SftCtrlHistorico) object;
        if ((this.histIdIdhist == null && other.histIdIdhist != null) || (this.histIdIdhist != null && !this.histIdIdhist.equals(other.histIdIdhist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftCtrlHistorico[ histIdIdhist=" + histIdIdhist + " ]";
    }
    
}
