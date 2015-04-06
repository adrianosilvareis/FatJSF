package br.entidade.beans;

import br.entidade.SftOutputGlos;
import br.entidade.business.Business;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ViewGlos")
@SessionScoped
public class GlosaBeans implements Serializable {
    private static final long serialVersionUID = 1L;

    @PostConstruct
    public void init() {
        findMes();
    }

    private List<SftOutputGlos> list;
    private SftOutputGlos selecionado;
    private String dataInicial;
    private String dataFinal;

    public List<SftOutputGlos> getList() {
        return list;
    }

    public void setList(List<SftOutputGlos> list) {
        this.list = list;
    }

    public SftOutputGlos getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(SftOutputGlos selecionado) {
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

    public void findMes() {
        this.list = Business.getInstance().findMes(SftOutputGlos.class);
    }

    public void findPeriodo() {
        list = Business.getInstance().findPeriodo(SftOutputGlos.class, getDataInicial(), getDataFinal());
        setDataInicial("");
        setDataFinal("");
    }
}
