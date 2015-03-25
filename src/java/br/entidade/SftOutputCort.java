/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "sft_output_cort")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftOutputCort.findAll", query = "SELECT s FROM SftOutputCort s"),
    @NamedQuery(name = "SftOutputCort.findByCortIdIdcort", query = "SELECT s FROM SftOutputCort s WHERE s.cortIdIdcort = :cortIdIdcort"),
    @NamedQuery(name = "SftOutputCort.findByCortAtAutorizacao", query = "SELECT s FROM SftOutputCort s WHERE s.cortAtAutorizacao = :cortAtAutorizacao"),
    @NamedQuery(name = "SftOutputCort.findByCortDtData", query = "SELECT s FROM SftOutputCort s WHERE s.cortDtData = :cortDtData"),
    @NamedQuery(name = "SftOutputCort.findByCortMtMotivo", query = "SELECT s FROM SftOutputCort s WHERE s.cortMtMotivo = :cortMtMotivo"),
    @NamedQuery(name = "SftOutputCort.findByCortNmNome", query = "SELECT s FROM SftOutputCort s WHERE s.cortNmNome = :cortNmNome"),
    @NamedQuery(name = "SftOutputCort.findByCortOsOscort", query = "SELECT s FROM SftOutputCort s WHERE s.cortOsOscort = :cortOsOscort"),
    @NamedQuery(name = "SftOutputCort.findByCortVlValor", query = "SELECT s FROM SftOutputCort s WHERE s.cortVlValor = :cortVlValor")})
public class SftOutputCort implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cort_id_idcort")
    private Integer cortIdIdcort;
    @Column(name = "cort_at_autorizacao")
    private String cortAtAutorizacao;
    @Column(name = "cort_dt_data")
    private String cortDtData;
    @Column(name = "cort_mt_motivo")
    private String cortMtMotivo;
    @Column(name = "cort_nm_nome")
    private String cortNmNome;
    @Column(name = "cort_os_oscort")
    private String cortOsOscort;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cort_vl_valor")
    private Float cortVlValor;
    @JoinColumn(name = "historico", referencedColumnName = "hist_id_idhist")
    @ManyToOne
    private SftCtrlHistorico historico;

    public SftOutputCort() {
    }

    public SftOutputCort(Integer cortIdIdcort) {
        this.cortIdIdcort = cortIdIdcort;
    }

    public Integer getCortIdIdcort() {
        return cortIdIdcort;
    }

    public void setCortIdIdcort(Integer cortIdIdcort) {
        this.cortIdIdcort = cortIdIdcort;
    }

    public String getCortAtAutorizacao() {
        return cortAtAutorizacao;
    }

    public void setCortAtAutorizacao(String cortAtAutorizacao) {
        this.cortAtAutorizacao = cortAtAutorizacao;
    }

    public String getCortDtData() {
        return cortDtData;
    }

    public void setCortDtData(String cortDtData) {
        this.cortDtData = cortDtData;
    }

    public String getCortMtMotivo() {
        return cortMtMotivo;
    }

    public void setCortMtMotivo(String cortMtMotivo) {
        this.cortMtMotivo = cortMtMotivo;
    }

    public String getCortNmNome() {
        return cortNmNome;
    }

    public void setCortNmNome(String cortNmNome) {
        this.cortNmNome = cortNmNome;
    }

    public String getCortOsOscort() {
        return cortOsOscort;
    }

    public void setCortOsOscort(String cortOsOscort) {
        this.cortOsOscort = cortOsOscort;
    }

    public Float getCortVlValor() {
        return cortVlValor;
    }

    public void setCortVlValor(Float cortVlValor) {
        this.cortVlValor = cortVlValor;
    }

    public SftCtrlHistorico getHistorico() {
        return historico;
    }

    public void setHistorico(SftCtrlHistorico historico) {
        this.historico = historico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cortIdIdcort != null ? cortIdIdcort.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftOutputCort)) {
            return false;
        }
        SftOutputCort other = (SftOutputCort) object;
        if ((this.cortIdIdcort == null && other.cortIdIdcort != null) || (this.cortIdIdcort != null && !this.cortIdIdcort.equals(other.cortIdIdcort))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftOutputCort[ cortIdIdcort=" + cortIdIdcort + " ]";
    }
    
}
