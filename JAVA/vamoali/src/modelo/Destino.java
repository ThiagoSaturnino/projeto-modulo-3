package modelo;

public class Destino {
private int id; 
private String nome;
private String dataEmbarque;
private String estado;
public Destino() {
	super();
}
public Destino(String nome, String dataEmbarque, String estado) {
	super();
	this.nome = nome;
	this.dataEmbarque = dataEmbarque;
	this.estado = estado;
}
public Destino(int id, String nome, String dataEmbarque, String estado) {
	super();
	this.id = id;
	this.nome = nome;
	this.dataEmbarque = dataEmbarque;
	this.estado = estado;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDataEmbarque() {
	return dataEmbarque;
}
public void setDataEmbarque(String dataEmbarque) {
	this.dataEmbarque = dataEmbarque;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public void mostrar () {
	System.out.println("===================================================================");
	System.out.println("id: "+id);
	
	System.out.println("estado: "+estado);
	System.out.println("data: "+dataEmbarque);

	System.out.println("nome: "+nome);
	System.out.println("===================================================================");
}

}
