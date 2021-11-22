package AtosUFN.projeto1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import AtosUFN.projeto1.Models.PessoaModel;



@Controller
public class PessoaController 
{
	
	@GetMapping("/index")
	public String abrirIndex()
	{
		
		return "index";
	}
	
	@GetMapping("/formulario")
	public String enviarForm(PessoaModel pessoa) {
		return "formulario";
	}
	
	@PostMapping("/formulario")
	public String processarForm(PessoaModel pessoa)
	{
		//código do banco
		
		return "resultado";
	}
}
