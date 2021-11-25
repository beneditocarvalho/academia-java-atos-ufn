package com.atos.ufn;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletJDBC
 */
@WebServlet("/ServletPessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	ResultSet rs;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		conectar();
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>\r\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<body>");

		//EXIBIR TODAS AS PESSOAS CADASTRADAS NO BD
		
		try {
			out.println("<h2>Lista de Pessoas cadastradas no banco de dados</h2>");
            rs = statement.executeQuery("SELECT * FROM Pessoa");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cidade = request.getParameter("cidade");
		
		conectar();
		
		// INSERIR A PESSOA
		String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('"+nome+"', '"+email+"', '"+cidade+"')";
        int status = executeUpdate(query);
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>\r\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<body>");
		if (status == 1) {
			out.println("<h3>A Pessoa "+ nome + " foi cadastrada com sucesso!</h3>");
		}
		

		//EXIBIR TODAS AS PESSOAS CADASTRADAS NO BD
		
		try {
			out.println("<h2>Lista de Pessoas cadastradas no banco de dados</h2>");
            rs = statement.executeQuery("SELECT * FROM Pessoa");
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
	
	private void conectar() {
    	try {
			String address = "localhost";
			String port = "3306";
			String dataBaseName = "atos02";
			String user = "root";
			String password = "12345";
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+ address + ":" + port +"/"+ dataBaseName + "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC"); 
			statement = connection.createStatement();
			
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    	
    }
	
	// Para inserções, alterações e exclusões   
    public int executeUpdate(String query) {     
        int status = 0;
        try {
        	statement = connection.createStatement();           
            status = statement.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return status;
    }
    
    // Para consultas
    public ResultSet executeQuery(String query) {
        try {
        	statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rs;   
    }

}
