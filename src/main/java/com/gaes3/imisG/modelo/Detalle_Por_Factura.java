package com.gaes3.imisG.modelo;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_por_factura")
public class Detalle_Por_Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdDetalle;
	
	private long CantidadDetalle;
	
	private String ValorUnitario;
	
	private String Iva;
	
	private String SubTotal;
	
	private String TotalGeneral;

	@ManyToOne 
	@JoinColumn(name="fk_idFactura")
	private Factura factura;
	
	@ManyToOne 
	@JoinColumn(name="fk_IdProductos")
	private Producto producto;
	
	
	
	
	public long getIdDetalle() {
		return IdDetalle;
	}
	public void setIdDetalle(long idDetalle) {
		IdDetalle = idDetalle;
	}
	public long getCantidadDetalle() {
		return CantidadDetalle;
	}
	public void setCantidadDetalle(long cantidadDetalle) {
		CantidadDetalle = cantidadDetalle;
	}
	public String getValorUnitario() {
		return ValorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		ValorUnitario = valorUnitario;
	}
	public String getIva() {
		return Iva;
	}
	public void setIva(String iva) {
		Iva = iva;
	}
	public String getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(String subTotal) {
		SubTotal = subTotal;
	}
	public String getTotalGeneral() {
		return TotalGeneral;
	}
	public void setTotalGeneral(String totalGeneral) {
		TotalGeneral = totalGeneral;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Detalle_Por_Factura [IdDetalle=" + IdDetalle + ", CantidadDetalle=" + CantidadDetalle
				+ ", ValorUnitario=" + ValorUnitario + ", Iva=" + Iva + ", SubTotal=" + SubTotal + ", TotalGeneral="
				+ TotalGeneral + ", factura=" + factura + ", producto=" + producto + "]";
	}
	public Detalle_Por_Factura(long idDetalle, long cantidadDetalle, String valorUnitario, String iva, String subTotal,
			String totalGeneral, Factura factura, Producto producto) {
		super();
		IdDetalle = idDetalle;
		CantidadDetalle = cantidadDetalle;
		ValorUnitario = valorUnitario;
		Iva = iva;
		SubTotal = subTotal;
		TotalGeneral = totalGeneral;
		this.factura = factura;
		this.producto = producto;
	}
	public Detalle_Por_Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
