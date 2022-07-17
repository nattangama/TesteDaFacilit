package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Parametros de conexao
	private String driver = "com.mysql.cs.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/desafiotec?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "ano2022";

	// Metodos de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, email, informacao) values" + "(?,?,?)";

		try {
			// abrir conexao
			Connection con = conectar();
			// Preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo das variaveis javabeans

			pst.setString(1, contato.getnome());
			pst.setString(2, contato.getemail());
			pst.setString(3, contato.getinformacao());
			// Executar a query
			pst.executeUpdate();
			// Encerrar conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContato() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contato = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laco abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String informacao = rs.getString(4);
				// populando o ArrayList
				contato.add(new JavaBeans(idcon, nome, email, informacao));
			}
			con.close();
			return contato;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}
}
