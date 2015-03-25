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
@Table(name = "sft_input_aten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SftInputAten.findAll", query = "SELECT s FROM SftInputAten s"),
    @NamedQuery(name = "SftInputAten.findByAtenIdIdaten", query = "SELECT s FROM SftInputAten s WHERE s.atenIdIdaten = :atenIdIdaten"),
    @NamedQuery(name = "SftInputAten.findByAtenNmNmaten", query = "SELECT s FROM SftInputAten s WHERE s.atenNmNmaten = :atenNmNmaten"),
    @NamedQuery(name = "SftInputAten.findByAtenUsUsaten", query = "SELECT s FROM SftInputAten s WHERE s.atenUsUsaten = :atenUsUsaten")})
public class SftInputAten implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aten_id_idaten")
    private Integer atenIdIdaten;
    @Column(name = "aten_nm_nmaten")
    private String atenNmNmaten;
    @Column(name = "aten_us_usaten")
    private String atenUsUsaten;
    @OneToMany(mappedBy = "fkAten")
    private List<SftOutputInco> sftOutputIncoList;
    @OneToMany(mappedBy = "fkAten")
    private List<SftOutputGlos> sftOutputGlosList;
    @OneToMany(mappedBy = "fkAten")
    private List<SftOutputPart> sftOutputPartList;

    public SftInputAten() {
    }

    public SftInputAten(Integer atenIdIdaten) {
        this.atenIdIdaten = atenIdIdaten;
    }

    public Integer getAtenIdIdaten() {
        return atenIdIdaten;
    }

    public void setAtenIdIdaten(Integer atenIdIdaten) {
        this.atenIdIdaten = atenIdIdaten;
    }

    public String getAtenNmNmaten() {
        return atenNmNmaten;
    }

    public void setAtenNmNmaten(String atenNmNmaten) {
        this.atenNmNmaten = atenNmNmaten;
    }

    public String getAtenUsUsaten() {
        return atenUsUsaten;
    }

    public void setAtenUsUsaten(String atenUsUsaten) {
        this.atenUsUsaten = atenUsUsaten;
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
        hash += (atenIdIdaten != null ? atenIdIdaten.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SftInputAten)) {
            return false;
        }
        SftInputAten other = (SftInputAten) object;
        if ((this.atenIdIdaten == null && other.atenIdIdaten != null) || (this.atenIdIdaten != null && !this.atenIdIdaten.equals(other.atenIdIdaten))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.SftInputAten[ atenIdIdaten=" + atenIdIdaten + " ]";
    }
    
}
