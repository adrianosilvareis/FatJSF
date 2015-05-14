package br.entidade.beans;
    
import br.entidade.SftCtrlHistorico;
import br.entidade.SftOutputPart;
import br.entidade.business.Business;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ViewPart")
@SessionScoped
public class PartBeans implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @PostConstruct
    public void init() {
        findAll();
    }
    
    private List<SftOutputPart> list;
    private SftOutputPart selecionado;
    private SftCtrlHistorico hist;

    public List<SftOutputPart> getList() {
        return list;
    }

    public void setList(List<SftOutputPart> list) {
        this.list = list;
    }

    public SftOutputPart getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(SftOutputPart selecionado) {
        this.selecionado = selecionado;
    }

    public SftCtrlHistorico getHist() {
        return hist;
    }

    public void setHist(SftCtrlHistorico hist) {
        this.hist = hist;
    }
    
    public void findAll() {
        this.list = Business.getInstance().findAll(SftOutputPart.class);
    }
}
