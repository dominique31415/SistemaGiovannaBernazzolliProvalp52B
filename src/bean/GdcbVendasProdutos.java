package bean;

import java.lang.Double;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gdcb_vendas_produtos", catalog="db_giovanna_bernazzolli")
public class GdcbVendasProdutos implements java.io.Serializable {

     private Integer gdcbIdItemVenda;
     private GdcbProdutos gdcbProdutos;
     private GdcbVenda gdcbVenda;
     private int gdcbQuantidade;
     private Double gdcbValorUnitario;
     private Double gdcbValorTotal;

    public GdcbVendasProdutos() {
    }

    public GdcbVendasProdutos(GdcbProdutos gdcbProdutos, GdcbVenda gdcbVenda, int gdcbQuantidade, Double gdcbValorUnitario, Double gdcbValorTotal) {
       this.gdcbProdutos = gdcbProdutos;
       this.gdcbVenda = gdcbVenda;
       this.gdcbQuantidade = gdcbQuantidade;
       this.gdcbValorUnitario = gdcbValorUnitario;
       this.gdcbValorTotal = gdcbValorTotal;
    }
   
    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="gdcb_idItemVenda", unique=true, nullable=false)
    public Integer getGdcbIdItemVenda() {
        return this.gdcbIdItemVenda;
    }
    
    public void setGdcbIdItemVenda(Integer gdcbIdItemVenda) {
        this.gdcbIdItemVenda = gdcbIdItemVenda;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gdcb_idProduto", nullable=false)
    public GdcbProdutos getGdcbProdutos() {
        return this.gdcbProdutos;
    }
    
    public void setGdcbProdutos(GdcbProdutos gdcbProdutos) {
        this.gdcbProdutos = gdcbProdutos;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gdcb_idVenda", nullable=false)
    public GdcbVenda getGdcbVenda() {
        return this.gdcbVenda;
    }
    
    public void setGdcbVenda(GdcbVenda gdcbVenda) {
        this.gdcbVenda = gdcbVenda;
    }

    @Column(name="gdcb_quantidade", nullable=false)
    public int getGdcbQuantidade() {
        return this.gdcbQuantidade;
    }
    
    public void setGdcbQuantidade(int gdcbQuantidade) {
        this.gdcbQuantidade = gdcbQuantidade;
    }

    @Column(name="gdcb_valorUnitario", nullable=false, precision=10)
    public Double getGdcbValorUnitario() {
        return this.gdcbValorUnitario;
    }
    
    public void setGdcbValorUnitario(Double gdcbValorUnitario) {
        this.gdcbValorUnitario = gdcbValorUnitario;
    }

    @Column(name="gdcb_valorTotal", nullable=false, precision=10)
    public Double getGdcbValorTotal() {
        return this.gdcbValorTotal;
    }
    
    public void setGdcbValorTotal(Double gdcbValorTotal) {
        this.gdcbValorTotal = gdcbValorTotal;
    }
}