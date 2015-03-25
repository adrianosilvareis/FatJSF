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
    
    public List<SftOutputInco> findPeriodo(String dataInicial, String dataFinal) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = format.parse(dataInicial);
        Date d2 = format.parse(dataFinal);
        TypedQuery<SftOutputInco> q = em.createNamedQuery("SftOutputInco.findPeriodo",SftOutputInco.class);
        q.setParameter("inicial", d1);
        q.setParameter("fim", d2);
        return q.getResultList();
    }
}
