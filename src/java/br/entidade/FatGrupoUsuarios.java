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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "fat_grupo_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatGrupoUsuarios.findAll", query = "SELECT f FROM FatGrupoUsuarios f"),
    @NamedQuery(name = "FatGrupoUsuarios.findById", query = "SELECT f FROM FatGrupoUsuarios f WHERE f.id = :id"),
    @NamedQuery(name = "FatGrupoUsuarios.findByDescricao", query = "SELECT f FROM FatGrupoUsuarios f WHERE f.descricao = :descricao")})
public class FatGrupoUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @JoinTable(name = "fat_acessos_has_grupo_usuarios", joinColumns = {
        @JoinColumn(name = "acessos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "grupo_usuarios_id", referencedColumnName = "id")})
    @ManyToMany
    private List<FatAcessos> fatAcessosList;
    @OneToMany(mappedBy = "grupoUsuariosId")
    private List<FatUsuarios> fatUsuariosList;

    public FatGrupoUsuarios() {
    }

    public FatGrupoUsuarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FatAcessos> getFatAcessosList() {
        return fatAcessosList;
    }

    public void setFatAcessosList(List<FatAcessos> fatAcessosList) {
        this.fatAcessosList = fatAcessosList;
    }

    @XmlTransient
    public List<FatUsuarios> getFatUsuariosList() {
        return fatUsuariosList;
    }

    public void setFatUsuariosList(List<FatUsuarios> fatUsuariosList) {
        this.fatUsuariosList = fatUsuariosList;
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
        if (!(object instanceof FatGrupoUsuarios)) {
            return false;
        }
        FatGrupoUsuarios other = (FatGrupoUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatGrupoUsuarios[ id=" + id + " ]";
    }
    
}
