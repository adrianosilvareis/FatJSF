/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "sft_output_part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftOutputPart.findAll", query = "SELECT s FROM SftOutputPart s"),
    @NamedQuery(name = "SftOutputPart.findByPartIdIdpart", query = "SELECT s FROM SftOutputPart s WHERE s.partIdIdpart = :partIdIdpart"),
    @NamedQuery(name = "SftOutputPart.findByPartDataRegist", query = "SELECT s FROM SftOutputPart s WHERE s.partDataRegist = :partDataRegist"),
    @NamedQuery(name = "SftOutputPart.findByPartNmPaciente", query = "SELECT s FROM SftOutputPart s WHERE s.partNmPaciente = :partNmPaciente"),
    @NamedQuery(name = "SftOutputPart.findByPartOsOspart", query = "SELECT s FROM SftOutputPart s WHERE s.partOsOspart = :partOsOspart"),
    @NamedQuery(name = "SftOutputPart.findByPartVlDebito", query = "SELECT s FROM SftOutputPart s WHERE s.partVlDebito = :partVlDebito"),
    @NamedQuery(name = "SftOutputPart.findByPartVlDesc", query = "SELECT s FROM SftOutputPart s WHERE s.partVlDesc = :partVlDesc"),
    @NamedQuery(name = "SftOutputPart.findByPartVlLiquido", query = "SELECT s FROM SftOutputPart s WHERE s.partVlLiquido = :partVlLiquido"),
    @NamedQuery(name = "SftOutputPart.findByPartVlPago", query = "SELECT s FROM SftOutputPart s WHERE s.partVlPago = :partVlPago"),
    @NamedQuery(name = "SftOutputPart.findByPartVlTotal", query = "SELECT s FROM SftOutputPart s WHERE s.partVlTotal = :partVlTotal")})
public class SftOutputPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "part_id_idpart")
    private Integer partIdIdpart;
    @Column(name = "part_data_regist")
    private String partDataRegist;
    @Column(name = "part_nm_paciente")
    private String partNmPaciente;
    @Column(name = "part_os_ospart")
    private String partOsOspart;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "part_vl_debito")
    private Double partVlDebito;
    @Column(name = "part_vl_desc")
    private Double partVlDesc;
    @Column(name = "part_vl_liquido")
    private Double partVlLiquido;
    @Column(name = "part_vl_pago")
    private Double partVlPago;
    @Column(name = "part_vl_total")
    private Double partVlTotal;
    @JoinColumn(name = "fk_aten", referencedColumnName = "aten_id_idaten")
    @ManyToOne
    private SftInputAten fkAten;
    @JoinColumn(name = "fk_unid", referencedColumnName = "unid_id_idunid")
    @ManyToOne
    private SftInputUnid fkUnid;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "sftOutputPartList")
    private List<SftCtrlHistorico> sftCtrlHistoricoList;
    

    public SftOutputPart() {
    }

    public SftOutputPart(Integer partIdIdpart) {
        this.partIdIdpart = partIdIdpart;
    }

    public Integer getPartIdIdpart() {
        return partIdIdpart;
    }

    public void setPartIdIdpart(Integer partIdIdpart) {
        this.partIdIdpart = partIdIdpart;
    }

    public String getPartDataRegist() {
        return partDataRegist;
    }

    public void setPartDataRegist(String partDataRegist) {
        this.partDataRegist = partDataRegist;
    }

    public String getPartNmPaciente() {
        return partNmPaciente;
    }

    public void setPartNmPaciente(String partNmPaciente) {
        this.partNmPaciente = partNmPaciente;
    }

    public String getPartOsOspart() {
        return partOsOspart;
    }

    public void setPartOsOspart(String partOsOspart) {
        this.partOsOspart = partOsOspart;
    }

    public Double getPartVlDebito() {
        return partVlDebito;
    }

    public void setPartVlDebito(Double partVlDebito) {
        this.partVlDebito = partVlDebito;
    }

    public Double getPartVlDesc() {
        return partVlDesc;
    }

    public void setPartVlDesc(Double partVlDesc) {
        this.partVlDesc = partVlDesc;
    }

    public Double getPartVlLiquido() {
        return partVlLiquido;
    }

    public void setPartVlLiquido(Double partVlLiquido) {
        this.partVlLiquido = partVlLiquido;
    }

    public Double getPartVlPago() {
        return partVlPago;
    }

    public void setPartVlPago(Double partVlPago) {
        this.partVlPago = partVlPago;
    }

    public Double getPartVlTotal() {
        return partVlTotal;
    }

    public void setPartVlTotal(Double partVlTotal) {
        this.partVlTotal = partVlTotal;
    }

    public SftInputAten getFkAten() {
        return fkAten;
    }

    public void setFkAten(SftInputAten fkAten) {
        this.fkAten = fkAten;
    }

    public SftInputUnid getFkUnid() {
        return fkUnid;
    }

    public void setFkUnid(SftInputUnid fkUnid) {
        this.fkUnid = fkUnid;
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
        hash += (partIdIdpart != null ? partIdIdpart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftOutputPart)) {
            return false;
        }
        SftOutputPart other = (SftOutputPart) object;
        if ((this.partIdIdpart == null && other.partIdIdpart != null) || (this.partIdIdpart != null && !this.partIdIdpart.equals(other.partIdIdpart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftOutputPart[ partIdIdpart=" + partIdIdpart + " ]";
    }
    
}
