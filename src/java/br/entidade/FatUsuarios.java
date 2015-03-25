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
import javax.persistence.ManyToOne;
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
@Table(name = "fat_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FatUsuarios.findAll", query = "SELECT f FROM FatUsuarios f"),
    @NamedQuery(name = "FatUsuarios.findById", query = "SELECT f FROM FatUsuarios f WHERE f.id = :id"),
    @NamedQuery(name = "FatUsuarios.findByLogin", query = "SELECT f FROM FatUsuarios f WHERE f.login = :login"),
    @NamedQuery(name = "FatUsuarios.findByNome", query = "SELECT f FROM FatUsuarios f WHERE f.nome = :nome"),
    @NamedQuery(name = "FatUsuarios.findBySenha", query = "SELECT f FROM FatUsuarios f WHERE f.senha = :senha"),
    @NamedQuery(name = "FatUsuarios.findByStatus", query = "SELECT f FROM FatUsuarios f WHERE f.status = :status")})
public class FatUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "usuariosId")
    private List<SftCtrlHistorico> sftCtrlHistoricoList;
    @JoinColumn(name = "grupo_usuarios_id", referencedColumnName = "id")
    @ManyToOne
    private FatGrupoUsuarios grupoUsuariosId;
    @OneToMany(mappedBy = "usuariosId")
    private List<FatHistorico> fatHistoricoList;

    public FatUsuarios() {
    }

    public FatUsuarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<SftCtrlHistorico> getSftCtrlHistoricoList() {
        return sftCtrlHistoricoList;
    }

    public void setSftCtrlHistoricoList(List<SftCtrlHistorico> sftCtrlHistoricoList) {
        this.sftCtrlHistoricoList = sftCtrlHistoricoList;
    }

    public FatGrupoUsuarios getGrupoUsuariosId() {
        return grupoUsuariosId;
    }

    public void setGrupoUsuariosId(FatGrupoUsuarios grupoUsuariosId) {
        this.grupoUsuariosId = grupoUsuariosId;
    }

    @XmlTransient
    public List<FatHistorico> getFatHistoricoList() {
        return fatHistoricoList;
    }

    public void setFatHistoricoList(List<FatHistorico> fatHistoricoList) {
        this.fatHistoricoList = fatHistoricoList;
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
        if (!(object instanceof FatUsuarios)) {
            return false;
        }
        FatUsuarios other = (FatUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.entidade.FatUsuarios[ id=" + id + " ]";
    }
    
}
