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
@Table(name = "sft_output_glos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftOutputGlos.findAll", query = "SELECT s FROM SftOutputGlos s"),
    @NamedQuery(name = "SftOutputGlos.findByGlosIdIdglos", query = "SELECT s FROM SftOutputGlos s WHERE s.glosIdIdglos = :glosIdIdglos"),
    @NamedQuery(name = "SftOutputGlos.findByGlosDtRegis", query = "SELECT s FROM SftOutputGlos s WHERE s.glosDtRegis = :glosDtRegis"),
    @NamedQuery(name = "SftOutputGlos.findByGlosObObsglos", query = "SELECT s FROM SftOutputGlos s WHERE s.glosObObsglos = :glosObObsglos"),
    @NamedQuery(name = "SftOutputGlos.findByGlosOsNumos", query = "SELECT s FROM SftOutputGlos s WHERE s.glosOsNumos = :glosOsNumos"),
    @NamedQuery(name = "SftOutputGlos.findByGlosVlVlos", query = "SELECT s FROM SftOutputGlos s WHERE s.glosVlVlos = :glosVlVlos")})
public class SftOutputGlos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "glos_id_idglos")
    private Integer glosIdIdglos;
    @Column(name = "glos_dt_regis")
    @Temporal(TemporalType.DATE)
    private Date glosDtRegis;
    @Column(name = "glos_ob_obsglos")
    private String glosObObsglos;
    @Column(name = "glos_os_numos")
    private String glosOsNumos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "glos_vl_vlos")
    private Double glosVlVlos;
    @JoinTable(name = "sft_glos_has_historico", joinColumns = {
        @JoinColumn(name = "idglos", referencedColumnName = "glos_id_idglos")}, inverseJoinColumns = {
        @JoinColumn(name = "idhist", referencedColumnName = "hist_id_idhist")})
    @ManyToMany
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

    public SftOutputGlos() {
    }

    public SftOutputGlos(Integer glosIdIdglos) {
        this.glosIdIdglos = glosIdIdglos;
    }

    public Integer getGlosIdIdglos() {
        return glosIdIdglos;
    }

    public void setGlosIdIdglos(Integer glosIdIdglos) {
        this.glosIdIdglos = glosIdIdglos;
    }

    public Date getGlosDtRegis() {
        return glosDtRegis;
    }

    public void setGlosDtRegis(Date glosDtRegis) {
        this.glosDtRegis = glosDtRegis;
    }

    public String getGlosObObsglos() {
        return glosObObsglos;
    }

    public void setGlosObObsglos(String glosObObsglos) {
        this.glosObObsglos = glosObObsglos;
    }

    public String getGlosOsNumos() {
        return glosOsNumos;
    }

    public void setGlosOsNumos(String glosOsNumos) {
        this.glosOsNumos = glosOsNumos;
    }

    public Double getGlosVlVlos() {
        return glosVlVlos;
    }

    public void setGlosVlVlos(Double glosVlVlos) {
        this.glosVlVlos = glosVlVlos;
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
        hash += (glosIdIdglos != null ? glosIdIdglos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftOutputGlos)) {
            return false;
        }
        SftOutputGlos other = (SftOutputGlos) object;
        if ((this.glosIdIdglos == null && other.glosIdIdglos != null) || (this.glosIdIdglos != null && !this.glosIdIdglos.equals(other.glosIdIdglos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftOutputGlos[ glosIdIdglos=" + glosIdIdglos + " ]";
    }
    
}
