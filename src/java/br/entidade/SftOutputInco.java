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
@Table(name = "sft_output_inco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftOutputInco.findAll", query = "SELECT s FROM SftOutputInco s"),
    @NamedQuery(name = "SftOutputInco.findMaxYear", query = "SELECT MAX(FUNCTION('Year', s.incoDtRegis)) FROM SftOutputInco s"),
    @NamedQuery(name = "SftOutputInco.findMaxMonth", query = "SELECT MAX(FUNCTION('Month', s.incoDtRegis)) FROM SftOutputInco s WHERE FUNCTION('Year', s.incoDtRegis) like :ano"),
    @NamedQuery(name = "SftOutputInco.findAtual", query = "SELECT s FROM SftOutputInco s WHERE FUNCTION('Year', s.incoDtRegis) like :ano AND FUNCTION('Month', s.incoDtRegis) like :mes"),
    @NamedQuery(name = "SftOutputInco.findPeriodo", query = "SELECT s FROM SftOutputInco s WHERE s.incoDtRegis >= :inicial AND s.incoDtRegis <= :fim ORDER BY s.incoDtRegis DESC"),
    @NamedQuery(name = "SftOutputInco.findByIncoIdIdinco", query = "SELECT s FROM SftOutputInco s WHERE s.incoIdIdinco = :incoIdIdinco"),
    @NamedQuery(name = "SftOutputInco.findByIncoDtRegis", query = "SELECT s FROM SftOutputInco s WHERE s.incoDtRegis = :incoDtRegis"),
    @NamedQuery(name = "SftOutputInco.findByIncoObObsinco", query = "SELECT s FROM SftOutputInco s WHERE s.incoObObsinco = :incoObObsinco"),
    @NamedQuery(name = "SftOutputInco.findByIncoOsNumos", query = "SELECT s FROM SftOutputInco s WHERE s.incoOsNumos = :incoOsNumos")})
public class SftOutputInco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inco_id_idinco")
    private Integer incoIdIdinco;
    @Column(name = "inco_dt_regis")
    @Temporal(TemporalType.DATE)
    private Date incoDtRegis;
    @Column(name = "inco_ob_obsinco")
    private String incoObObsinco;
    @Column(name = "inco_os_numos")
    private String incoOsNumos;
    @ManyToMany(mappedBy = "sftOutputIncoList")
    private List<SftCtrlHistorico> sftCtrlHistoricoList;
    @JoinColumn(name = "fk_aten", referencedColumnName = "aten_id_idaten")
    @ManyToOne
    private SftInputAten fkAten;
    @JoinColumn(name = "fk_conv", referencedColumnName = "id")
    @ManyToOne
    private FatConvenio fkConv;
    @JoinColumn(name = "fk_ncon", referencedColumnName = "ncon_id_idncon")
    @ManyToOne
    private SftInputNcon fkNcon;
    @JoinColumn(name = "fk_stat", referencedColumnName = "status_id_idstatus")
    @ManyToOne
    private SftInputStat fkStat;
    @JoinColumn(name = "fk_unid", referencedColumnName = "unid_id_idunid")
    @ManyToOne
    private SftInputUnid fkUnid;

    public SftOutputInco() {
    }

    public SftOutputInco(Integer incoIdIdinco) {
        this.incoIdIdinco = incoIdIdinco;
    }

    public Integer getIncoIdIdinco() {
        return incoIdIdinco;
    }

    public void setIncoIdIdinco(Integer incoIdIdinco) {
        this.incoIdIdinco = incoIdIdinco;
    }

    public Date getIncoDtRegis() {
        return incoDtRegis;
    }

    public void setIncoDtRegis(Date incoDtRegis) {
        this.incoDtRegis = incoDtRegis;
    }

    public String getIncoObObsinco() {
        return incoObObsinco;
    }

    public void setIncoObObsinco(String incoObObsinco) {
        this.incoObObsinco = incoObObsinco;
    }

    public String getIncoOsNumos() {
        return incoOsNumos;
    }

    public void setIncoOsNumos(String incoOsNumos) {
        this.incoOsNumos = incoOsNumos;
    }

    @XmlTransient
    public List<SftCtrlHistorico> getSftCtrlHistoricoList() {
        return sftCtrlHistoricoList;
    }

    public void setSftCtrlHistoricoList(List<SftCtrlHistorico> sftCtrlHistoricoList) {
        this.sftCtrlHistoricoList = sftCtrlHistoricoList;
    }

    public SftInputAten getFkAten() {
        return fkAten;
    }

    public void setFkAten(SftInputAten fkAten) {
        this.fkAten = fkAten;
    }

    public FatConvenio getFkConv() {
        return fkConv;
    }

    public void setFkConv(FatConvenio fkConv) {
        this.fkConv = fkConv;
    }

    public SftInputNcon getFkNcon() {
        return fkNcon;
    }

    public void setFkNcon(SftInputNcon fkNcon) {
        this.fkNcon = fkNcon;
    }

    public SftInputStat getFkStat() {
        return fkStat;
    }

    public void setFkStat(SftInputStat fkStat) {
        this.fkStat = fkStat;
    }

    public SftInputUnid getFkUnid() {
        return fkUnid;
    }

    public void setFkUnid(SftInputUnid fkUnid) {
        this.fkUnid = fkUnid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incoIdIdinco != null ? incoIdIdinco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftOutputInco)) {
            return false;
        }
        SftOutputInco other = (SftOutputInco) object;
        if ((this.incoIdIdinco == null && other.incoIdIdinco != null) || (this.incoIdIdinco != null && !this.incoIdIdinco.equals(other.incoIdIdinco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftOutputInco[ incoIdIdinco=" + incoIdIdinco + " ]";
    }
    
}
