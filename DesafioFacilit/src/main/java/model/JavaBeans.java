package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String email;
	private String informacao;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcon, String nome, String email, String informacao) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.email = email;
		this.informacao = informacao;
	}

	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getinformacao() {
		return informacao;
	}
	public void setinformacao(String informacao) {
		this.informacao = informacao;
	}

}
