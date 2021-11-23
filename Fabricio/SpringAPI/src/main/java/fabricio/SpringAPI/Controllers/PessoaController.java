package fabricio.SpringAPI.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fabricio.SpringAPI.Models.PessoaModel;
import fabricio.SpringAPI.Repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<PessoaModel> listar() {

		return pessoaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<PessoaModel> listarPessoas(@PathVariable Long id) {

		try {
			return pessoaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaModel cadastrar(@RequestBody PessoaModel pessoa) {
		System.out.println(pessoa.getNome());
		return pessoaRepository.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		System.out.println(id);
		pessoaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public PessoaModel updatePessoa(@RequestBody PessoaModel pessoa, @PathVariable Long id) {
		PessoaModel p = pessoaRepository.getOne(id);
		p.setNome(pessoa.getNome());

		return pessoaRepository.save(p);
	}

}
