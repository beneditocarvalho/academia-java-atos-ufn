package com.atosufn.SpringBootCalculadora.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atosufn.SpringBootCalculadora.Model.CalculadoraModel;

@Controller
public class CalculadoraController {

	@GetMapping("/calc")
	public String enviarForm(CalculadoraModel calc) {
		System.out.println("get - formCalc" );
		return "FormCalc";
	} 
	
	@PostMapping("/calcular")
	public String processarForm(@ModelAttribute CalculadoraModel calc, 
			@RequestParam(value = "action", required = true) String action) {

		
		try {
			if(action.equals("somar")) {
				calc.setResultado(calc.getPrimeiro() + calc.getSegundo());
			}
			
			if(action.equals("subtrair")) {
				calc.setResultado(calc.getPrimeiro() - calc.getSegundo());
			}
			
			if(action.equals("dividir")) {
				calc.setResultado(calc.getPrimeiro() / calc.getSegundo());
			}
			if(action.equals("multiplicar")) {
				calc.setResultado(calc.getPrimeiro() * calc.getSegundo());
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FormCalc";
		}

		return "ResultCalculo";
	}
	
}