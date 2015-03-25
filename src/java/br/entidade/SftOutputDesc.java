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
@Table(name = "sft_output_desc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftOutputDesc.findAll", query = "SELECT s FROM SftOutputDesc s"),
    @NamedQuery(name = "SftOutputDesc.findByDescIdIddesc", query = "SELECT s FROM SftOutputDesc s WHERE s.descIdIddesc = :descIdIddesc"),
    @NamedQuery(name = "SftOutputDesc.findByDescDtData", query = "SELECT s FROM SftOutputDesc s WHERE s.descDtData = :descDtData"),
    @NamedQuery(name = "SftOutputDesc.findByDescNmAtendente", query = "SELECT s FROM SftOutputDesc s WHERE s.descNmAtendente = :descNmAtendente"),
    @NamedQuery(name = "SftOutputDesc.findByDescNmAutorizado", query = "SELECT s FROM SftOutputDesc s WHERE s.descNmAutorizado = :descNmAutorizado"),
    @NamedQuery(name = "SftOutputDesc.findByDescNmNome", query = "SELECT s FROM SftOutputDesc s WHERE s.descNmNome = :descNmNome"),
    @NamedQuery(name = "SftOutputDesc.findByDescOsOs", query = "SELECT s FROM SftOutputDesc s WHERE s.descOsOs = :descOsOs"),
    @NamedQuery(name = "SftOutputDesc.findByDescVlDesconto", query = "SELECT s FROM SftOutputDesc s WHERE s.descVlDesconto = :descVlDesconto"),
    @NamedQuery(name = "SftOutputDesc.findByDescVlLiquido", query = "SELECT s FROM SftOutputDesc s WHERE s.descVlLiquido = :descVlLiquido"),
    @NamedQuery(name = "SftOutputDesc.findByDescVlTotal", query = "SELECT s FROM SftOutputDesc s WHERE s.descVlTotal = :descVlTotal")})
public class SftOutputDesc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desc_id_iddesc")
    private Integer descIdIddesc;
    @Column(name = "desc_dt_data")
    private String descDtData;
    @Column(name = "desc_nm_atendente")
    private String descNmAtendente;
    @Column(name = "desc_nm_autorizado")
    private String descNmAutorizado;
    @Column(name = "desc_nm_nome")
    private String descNmNome;
    @Column(name = "desc_os_os")
    private String descOsOs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desc_vl_desconto")
    private Float descVlDesconto;
    @Column(name = "desc_vl_liquido")
    private Float descVlLiquido;
    @Column(name = "desc_vl_total")
    private Float descVlTotal;
    @JoinColumn(name = "historico", referencedColumnName = "hist_id_idhist")
    @ManyToOne
    private SftCtrlHistorico historico;

    public SftOutputDesc() {
    }

    public SftOutputDesc(Integer descIdIddesc) {
        this.descIdIddesc = descIdIddesc;
    }

    public Integer getDescIdIddesc() {
        return descIdIddesc;
    }

    public void setDescIdIddesc(Integer descIdIddesc) {
        this.descIdIddesc = descIdIddesc;
    }

    public String getDescDtData() {
        return descDtData;
    }

    public void setDescDtData(String descDtData) {
        this.descDtData = descDtData;
    }

    public String getDescNmAtendente() {
        return descNmAtendente;
    }

    public void setDescNmAtendente(String descNmAtendente) {
        this.descNmAtendente = descNmAtendente;
    }

    public String getDescNmAutorizado() {
        return descNmAutorizado;
    }

    public void setDescNmAutorizado(String descNmAutorizado) {
        this.descNmAutorizado = descNmAutorizado;
    }

    public String getDescNmNome() {
        return descNmNome;
    }

    public void setDescNmNome(String descNmNome) {
        this.descNmNome = descNmNome;
    }

    public String getDescOsOs() {
        return descOsOs;
    }

    public void setDescOsOs(String descOsOs) {
        this.descOsOs = descOsOs;
    }

    public Float getDescVlDesconto() {
        return descVlDesconto;
    }

    public void setDescVlDesconto(Float descVlDesconto) {
        this.descVlDesconto = descVlDesconto;
    }

    public Float getDescVlLiquido() {
        return descVlLiquido;
    }

    public void setDescVlLiquido(Float descVlLiquido) {
        this.descVlLiquido = descVlLiquido;
    }

    public Float getDescVlTotal() {
        return descVlTotal;
    }

    public void setDescVlTotal(Float descVlTotal) {
        this.descVlTotal = descVlTotal;
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
        hash += (descIdIddesc != null ? descIdIddesc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftOutputDesc)) {
            return false;
        }
        SftOutputDesc other = (SftOutputDesc) object;
        if ((this.descIdIddesc == null && other.descIdIddesc != null) || (this.descIdIddesc != null && !this.descIdIddesc.equals(other.descIdIddesc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftOutputDesc[ descIdIddesc=" + descIdIddesc + " ]";
    }
    
}
