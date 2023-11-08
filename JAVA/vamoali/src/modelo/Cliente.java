package modelo;

public class Cliente {
private int id;
private String nome;
private String telefone;
private String email;
private String endereco;
private String cpf;
public Cliente() {
	super();
}
public Cliente(String nome, String telefone, String email, String endereco, String cpf) {
	super();
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
	this.cpf = cpf;
}
public Cliente(int id, String nome, String telefone, String email, String endereco, String cpf) {
	super();
	this.id = id;
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
	this.cpf = cpf;
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
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}

public void mostrar () {
	System.out.println("===================================================================");
	System.out.println("id: "+id);
	System.out.println("telefone: "+telefone);
	System.out.println("email: "+email);
	System.out.println("endereco: "+endereco);
	System.out.println("cpf: "+cpf);
	System.out.println("nome: "+nome);
	System.out.println("===================================================================");
}
}
