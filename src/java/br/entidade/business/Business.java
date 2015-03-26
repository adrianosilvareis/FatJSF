package br.entidade.business;

import br.conexao.CriaConexao;
import br.entidade.SftOutputInco;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Business {
    
    /*Notaão de Singleton*/
    public static Business getInstance() {
        return Business1Holder.INSTANCE;
    }
    
    private static class Business1Holder {

        private static final Business INSTANCE = new Business();
    }
    /*final de notações singleton*/
    
    private Business() {
        this.em = CriaConexao.getInstance().getEntityManager();
    }
    
    private final EntityManager em;
    
    public List<SftOutputInco> findAll(){
        return em.createNamedQuery("SftOutputInco.findAll", SftOutputInco.class).getResultList();
    }
    
    public List<SftOutputInco> findMes(){
        String ano = em.createNamedQuery("SftOutputInco.findMaxYear").getSingleResult().toString();
        String mes = em.createNamedQuery("SftOutputInco.findMaxMonth").setParameter("ano", ano).getSingleResult().toString();
        TypedQuery<SftOutputInco> q = em.createNamedQuery("SftOutputInco.findAtual",SftOutputInco.class);
        q.setParameter("ano", ano);
        q.setParameter("mes", mes);
        return q.getResultList();
    }
    
    private Date toDate(String data){
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public List<SftOutputInco> findPeriodo(String dataInicial, String dataFinal){
        TypedQuery<SftOutputInco> q = em.createNamedQuery("SftOutputInco.findPeriodo",SftOutputInco.class);
        q.setParameter("inicial", toDate(dataInicial));
        q.setParameter("fim", toDate(dataFinal));
        return q.getResultList();
    }
}
