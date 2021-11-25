package com.atos.ufn.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atos.ufn.Models.PessoaModel;
import com.atos.ufn.Servicos.PessoaServico;

@WebServlet("/ServletPessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PessoaModel pessoa;
	PessoaServico servico;
	
    public ServletPessoa() {
    	pessoa = new PessoaModel();
    	servico = new PessoaServico();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		servico.obterTodos(response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cidade = request.getParameter("cidade");
		
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCidade(cidade);
		
		servico.inserirPessoa(pessoa, response);
		
	}
	
}