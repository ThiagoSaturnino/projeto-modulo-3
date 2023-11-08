package modelo;

public class Viagem {
private int id,numPassageiros;
private String dataIda,dataVolta;
private float valor;
private Cliente cliente;
private Destino destino;
public Viagem() {
	super();
}
public Viagem(int numPassageiros, String dataIda, String dataVolta, float valor, Cliente cliente, Destino destino) {
	super();
	this.numPassageiros = numPassageiros;
	this.dataIda = dataIda;
	this.dataVolta = dataVolta;
	this.valor = valor;
	this.cliente = cliente;
	this.destino = destino;
}
public Viagem(int id, int numPassgeiros, String dataIda, String dataVolta, float valor, Cliente cliente,
		Destino destino) {
	super();
	this.id = id;
	this.numPassageiros = numPassgeiros;
	this.dataIda = dataIda;
	this.dataVolta = dataVolta;
	this.valor = valor;
	this.cliente = cliente;
	this.destino = destino;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNumPassageiros() {
	return numPassageiros;
}
public void setNumPassageiros(int numPassageiros) {
	this.numPassageiros = numPassageiros;
}
public String getDataIda() {
	return dataIda;
}
public void setDataIda(String dataIda) {
	this.dataIda = dataIda;
}
public String getDataVolta() {
	return dataVolta;
}
public void setDataVolta(String dataVolta) {
	this.dataVolta = dataVolta;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Destino getDestino() {
	return destino;
}
public void setDestino(Destino destino) {
	this.destino = destino;
}
public void mostrar () {
	System.out.println("===================================================================");
	System.out.println("id: "+id);
	System.out.println("cliente: "+cliente.getNome());
	System.out.println("destino: "+destino.getNome());
	System.out.println("dataIda: "+dataIda);
	System.out.println("dataVolta: "+dataVolta);
	System.out.println("numpassageiros: "+numPassageiros);
	System.out.println("valor: "+valor);
	System.out.println("===================================================================");
	
}

}
