package br.entidade.beans;
    
import br.entidade.SftOutputInco;
import br.entidade.business.Business;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ViewInco")
@SessionScoped
public class IncoBeans {
    
    @PostConstruct
    public void init() {
        findMes();
    }
    
    private List<SftOutputInco> list;
    private SftOutputInco selecionado;
    private String dataInicial;
    private String dataFinal;
    
    public List<SftOutputInco> getList() {
        return list;
    }
    
    public void periodo(){
        list = Business.getInstance().findPeriodo(getDataInicial(), getDataFinal());
        setDataInicial("");
        setDataFinal("");
    }
    
    public void findMes() {
        this.list = Business.getInstance().findMes();
    }
    
    public void setList(List<SftOutputInco> list) {
        this.list = list;
    }

    public SftOutputInco getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(SftOutputInco selecionado) {
        this.selecionado = selecionado;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
}
