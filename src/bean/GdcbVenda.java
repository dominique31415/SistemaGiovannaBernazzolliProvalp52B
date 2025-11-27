package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gdcb_venda", catalog = "db_giovanna_bernazzolli")
public class GdcbVenda implements java.io.Serializable {

    private Integer gdcbIdVenda;
    private GdcbCliente gdcbCliente;
    private GdcbFuncionario gdcbFuncionario;
    private Date gdcbDataVenda;
    private Double gdcbValorTotal;
    private Integer gdcbQuantidade;
    private Double gdcbValorUnitario;
    private List<GdcbVendasProdutos> gdcbVendasProdutos = new ArrayList<>();

    public GdcbVenda() {
    }

    public GdcbVenda(GdcbCliente gdcbCliente, GdcbFuncionario gdcbFuncionario, 
                    Date gdcbDataVenda, Double gdcbValorTotal) {
        this.gdcbCliente = gdcbCliente;
        this.gdcbFuncionario = gdcbFuncionario;
        this.gdcbDataVenda = gdcbDataVenda;
        this.gdcbValorTotal = gdcbValorTotal;
    }

    public GdcbVenda(GdcbCliente gdcbCliente, GdcbFuncionario gdcbFuncionario, 
                    Date gdcbDataVenda, Double gdcbValorTotal, Integer gdcbQuantidade, 
                    Double gdcbValorUnitario) {
        this.gdcbCliente = gdcbCliente;
        this.gdcbFuncionario = gdcbFuncionario;
        this.gdcbDataVenda = gdcbDataVenda;
        this.gdcbValorTotal = gdcbValorTotal;
        this.gdcbQuantidade = gdcbQuantidade;
        this.gdcbValorUnitario = gdcbValorUnitario;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "gdcb_idVenda", unique = true, nullable = false)
    public Integer getGdcbIdVenda() {
        return this.gdcbIdVenda;
    }

    public void setGdcbIdVenda(Integer gdcbIdVenda) {
        this.gdcbIdVenda = gdcbIdVenda;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gdcb_idCliente", nullable = false)
    public GdcbCliente getGdcbCliente() {
        return this.gdcbCliente;
    }

    public void setGdcbCliente(GdcbCliente gdcbCliente) {
        this.gdcbCliente = gdcbCliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gdcb_idFuncionario", nullable = false)
    public GdcbFuncionario getGdcbFuncionario() {
        return this.gdcbFuncionario;
    }

    public void setGdcbFuncionario(GdcbFuncionario gdcbFuncionario) {
        this.gdcbFuncionario = gdcbFuncionario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gdcb_dataVenda", nullable = false, length = 19)
    public Date getGdcbDataVenda() {
        return this.gdcbDataVenda;
    }

    public void setGdcbDataVenda(Date gdcbDataVenda) {
        this.gdcbDataVenda = gdcbDataVenda;
    }

    @Column(name = "gdcb_valorTotal", nullable = false, precision = 10)
    public Double getGdcbValorTotal() {
        return this.gdcbValorTotal;
    }

    public void setGdcbValorTotal(Double gdcbValorTotal) {
        this.gdcbValorTotal = gdcbValorTotal;
    }

    @Column(name = "gdcb_quantidade")
    public Integer getGdcbQuantidade() {
        return this.gdcbQuantidade;
    }

    public void setGdcbQuantidade(Integer gdcbQuantidade) {
        this.gdcbQuantidade = gdcbQuantidade;
    }

    @Column(name = "gdcb_valorUnitario", precision = 10)
    public Double getGdcbValorUnitario() {
        return this.gdcbValorUnitario;
    }

    public void setGdcbValorUnitario(Double gdcbValorUnitario) {
        this.gdcbValorUnitario = gdcbValorUnitario;
    }

    @OneToMany(mappedBy = "gdcbVenda", cascade = CascadeType.ALL, 
               fetch = FetchType.LAZY, orphanRemoval = true)
    public List<GdcbVendasProdutos> getGdcbVendasProdutos() {
        return this.gdcbVendasProdutos;
    }

    public void setGdcbVendasProdutos(List<GdcbVendasProdutos> gdcbVendasProdutos) {
        this.gdcbVendasProdutos = gdcbVendasProdutos;
    }

    public void addGdcbVendasProdutos(GdcbVendasProdutos gdcbVendasProduto) {
        gdcbVendasProduto.setGdcbVenda(this);
        this.gdcbVendasProdutos.add(gdcbVendasProduto);
    }

    public void removeGdcbVendasProdutos(GdcbVendasProdutos gdcbVendasProduto) {
        this.gdcbVendasProdutos.remove(gdcbVendasProduto);
        gdcbVendasProduto.setGdcbVenda(null);
    }
    
    public Double calcularTotalVenda() {
        Double total = 0.0;
        for (GdcbVendasProdutos item : gdcbVendasProdutos) {
            total += item.getGdcbValorTotal();
        }
        this.gdcbValorTotal = total;
        return total;
    }
}