package br.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class CriaConexao {
    
    private CriaConexao() {
        setConexao("JPAPU");
    }
    
    public static CriaConexao getInstance() {
        return CriaConexaoHolder.INSTANCE;
    }
    
    private static class CriaConexaoHolder {

        private static final CriaConexao INSTANCE = new CriaConexao();
    }
    
    private String conexao;

    public String getConexao() {
        return conexao;
    }

    public void setConexao(String conexao) {
        this.conexao = conexao;
    }
    
    private EntityManagerFactory getFactory(){
        return Persistence.createEntityManagerFactory(getConexao());
    }
    
    public EntityManager getEntityManager(){
        return getFactory().createEntityManager();
    }
}
