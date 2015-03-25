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
import javax.persistence.ManyToMany;
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
@Table(name = "fat_acessos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatAcessos.findAll", query = "SELECT f FROM FatAcessos f"),
    @NamedQuery(name = "FatAcessos.findById", query = "SELECT f FROM FatAcessos f WHERE f.id = :id"),
    @NamedQuery(name = "FatAcessos.findByCodigo", query = "SELECT f FROM FatAcessos f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "FatAcessos.findByDescricao", query = "SELECT f FROM FatAcessos f WHERE f.descricao = :descricao")})
public class FatAcessos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "fatAcessosList")
    private List<FatGrupoUsuarios> fatGrupoUsuariosList;

    public FatAcessos() {
    }

    public FatAcessos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FatGrupoUsuarios> getFatGrupoUsuariosList() {
        return fatGrupoUsuariosList;
    }

    public void setFatGrupoUsuariosList(List<FatGrupoUsuarios> fatGrupoUsuariosList) {
        this.fatGrupoUsuariosList = fatGrupoUsuariosList;
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
        if (!(object instanceof FatAcessos)) {
            return false;
        }
        FatAcessos other = (FatAcessos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatAcessos[ id=" + id + " ]";
    }
    
}
