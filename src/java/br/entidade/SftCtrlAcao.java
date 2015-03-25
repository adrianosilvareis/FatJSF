/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "sft_ctrl_acao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftCtrlAcao.findAll", query = "SELECT s FROM SftCtrlAcao s"),
    @NamedQuery(name = "SftCtrlAcao.findByAcaoIdIdacao", query = "SELECT s FROM SftCtrlAcao s WHERE s.acaoIdIdacao = :acaoIdIdacao"),
    @NamedQuery(name = "SftCtrlAcao.findByAcaoNmNome", query = "SELECT s FROM SftCtrlAcao s WHERE s.acaoNmNome = :acaoNmNome")})
public class SftCtrlAcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acao_id_idacao")
    private Integer acaoIdIdacao;
    @Column(name = "acao_nm_nome")
    private String acaoNmNome;
    @OneToMany(mappedBy = "fkAcao")
    private List<SftCtrlHistorico> sftCtrlHistoricoList;

    public SftCtrlAcao() {
    }

    public SftCtrlAcao(Integer acaoIdIdacao) {
        this.acaoIdIdacao = acaoIdIdacao;
    }

    public Integer getAcaoIdIdacao() {
        return acaoIdIdacao;
    }

    public void setAcaoIdIdacao(Integer acaoIdIdacao) {
        this.acaoIdIdacao = acaoIdIdacao;
    }

    public String getAcaoNmNome() {
        return acaoNmNome;
    }

    public void setAcaoNmNome(String acaoNmNome) {
        this.acaoNmNome = acaoNmNome;
    }

    @XmlTransient
    public List<SftCtrlHistorico> getSftCtrlHistoricoList() {
        return sftCtrlHistoricoList;
    }

    public void setSftCtrlHistoricoList(List<SftCtrlHistorico> sftCtrlHistoricoList) {
        this.sftCtrlHistoricoList = sftCtrlHistoricoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acaoIdIdacao != null ? acaoIdIdacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftCtrlAcao)) {
            return false;
        }
        SftCtrlAcao other = (SftCtrlAcao) object;
        if ((this.acaoIdIdacao == null && other.acaoIdIdacao != null) || (this.acaoIdIdacao != null && !this.acaoIdIdacao.equals(other.acaoIdIdacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftCtrlAcao[ acaoIdIdacao=" + acaoIdIdacao + " ]";
    }
    
}
