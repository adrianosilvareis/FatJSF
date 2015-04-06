package br.entidade.business;

import br.conexao.CriaConexao;
import br.entidade.SftOutputGlos;
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

    private Date toDate(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }

    public <T extends Object> List<T> findAll(Class<T> type) {
        if (type == SftOutputInco.class) {
            return em.createNamedQuery("SftOutputInco.findAll", type).getResultList();
        }
        if (type == SftOutputGlos.class) {
            return em.createNamedQuery("SftOutputGlos.findAll", type).getResultList();
        }
        return null;
    }

    public <T extends Object> List<T> findMes(Class<T> type) {
        TypedQuery<T> q = null;
        if (type == SftOutputInco.class) {
            String ano = em.createNamedQuery("SftOutputInco.findMaxYear").getSingleResult().toString();
            String mes = em.createNamedQuery("SftOutputInco.findMaxMonth").setParameter("ano", ano).getSingleResult().toString();
            q = em.createNamedQuery("SftOutputInco.findAtual", type);
            q.setParameter("ano", ano);
            q.setParameter("mes", mes);
        }
        if (type == SftOutputGlos.class) {
            String ano = em.createNamedQuery("SftOutputGlos.findMaxYear").getSingleResult().toString();
            String mes = em.createNamedQuery("SftOutputGlos.findMaxMonth").setParameter("ano", ano).getSingleResult().toString();
            q = em.createNamedQuery("SftOutputGlos.findAtual", type);
            q.setParameter("ano", ano);
            q.setParameter("mes", mes);
        }

        return q.getResultList();
    }

    public <T extends Object> List<T> findPeriodo(Class<T> type, String dataInicial, String dataFinal) {
        TypedQuery<T> q = null;
        if (type == SftOutputInco.class) {
            q = em.createNamedQuery("SftOutputInco.findPeriodo", type);
            q.setParameter("inicial", toDate(dataInicial));
            q.setParameter("fim", toDate(dataFinal));
        }
        if (type == SftOutputGlos.class) {
            q = em.createNamedQuery("SftOutputGlos.findPeriodo", type);
            q.setParameter("inicial", toDate(dataInicial));
            q.setParameter("fim", toDate(dataFinal));
        }
        return q.getResultList();
    }

}
