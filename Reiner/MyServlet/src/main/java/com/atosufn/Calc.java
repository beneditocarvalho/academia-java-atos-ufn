package com.atosufn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	int resposta = 0;
	
    public Calc() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = "<a href=\"http://localhost:8080/MyServlet\"><button>Calculadora</button></a>";
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Bem-vindo ao Servlet MyServlet</h1>");
		printWriter.println("<h2>Resposta do método GET</h2>");
		printWriter.println(curso);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor1 = request.getParameter("valor1");
		String valor2 = request.getParameter("valor2");
		String op = request.getParameter("action");
		
		Calculadora calculadora = new Calculadora();
		
		if (op.equalsIgnoreCase("somar")) {
			resposta = calculadora.somar(Integer.parseInt(valor1),Integer.parseInt(valor2));
		};
		
		if (op.equalsIgnoreCase("subtrair")) {
			resposta = calculadora.subtrair(Integer.parseInt(valor1),Integer.parseInt(valor2));
		};
		
		if (op.equalsIgnoreCase("dividir")) {
			resposta = calculadora.dividir(Integer.parseInt(valor1),Integer.parseInt(valor2));
		};
		
		if (op.equalsIgnoreCase("multiplicar")) {
			resposta = calculadora.multiplicar(Integer.parseInt(valor1),Integer.parseInt(valor2));
		};
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//RESPOSTA HTML
		PrintWriter printWriter = response.getWriter();
		printWriter.append("<!DCOTYPE html>")
		.append("<html>\r\n")
		.append("    <head>")
		.append("        <title>Resposta HTML do método doPost</title>")
		.append("    </head>")
		.append("    <body>")
		.append("       Resultado: " + resposta +"<br>")
		.append("    </body>")
		.append("</html>\r\n");
	}


}