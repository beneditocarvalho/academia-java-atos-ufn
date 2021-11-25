package com.atos.ufn.Servicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import com.atos.ufn.Models.PessoaModel;
import com.atos.ufn.bd.ConexaoBD;

public class PessoaServico {
	
	public Connection connection;
	public Statement statement;
	public ResultSet rs;
	
	ConexaoBD bd;
	
	public PessoaServico() {
		bd = new ConexaoBD();
	}

	public void obterTodos(HttpServletResponse response) throws IOException {

		bd.conectar();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<html>\r\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<body>");

		// EXIBIR TODAS AS PESSOAS CADASTRADAS NO BD

		try {
			out.println("<h2>Lista de Pessoas cadastradas no banco de dados</h2>");
			rs = bd.statement.executeQuery("SELECT * FROM Pessoa");
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}

		if (rs != null) {
			try {
				while (rs.next()) {
					out.println("<strong>ID: </strong>" + rs.getString("ID") + "<br>");
					out.println("<strong>Nome: </strong>" + rs.getString("nome") + "<br>");
					out.println("<strong>Email: </strong>" + rs.getString("email") + "<br>");
					out.println("<strong>Cidade: </strong>" + rs.getString("cidade") + "<br><br>");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		out.println("</body>\r\n");
		out.println("</html>");
	}

		public void inserirPessoa(PessoaModel pessoa, HttpServletResponse response) throws IOException {
		
		bd.conectar();
			
		// INSERIR A PESSOA
		String query = "INSERT INTO Pessoa (nome, email, cidade) " + "values ('" + pessoa.getNome() + "', '" + pessoa.getEmail() + "', '"
				+ pessoa.getCidade() + "')";
		int status = bd.executeUpdate(query);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>\r\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<body>");
		if (status == 1) {
			out.println("<h3>A Pessoa " + pessoa.getNome() + " foi cadastrada com sucesso!</h3>");
		}

		// EXIBIR TODAS AS PESSOAS CADASTRADAS NO BD
		
		out.println("</body>\r\n");
		out.println("</html>");

	}


}
