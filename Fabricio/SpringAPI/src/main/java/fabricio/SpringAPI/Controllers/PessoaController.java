package fabricio.SpringAPI.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST APIs relacionada aos CRUD de PESSOAS!")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@ApiOperation(value = "Retorna todas as pessoas cadastradas", response = Iterable.class, tags = "getPessoas")
	@GetMapping
	public List<PessoaModel> listar() {

		return pessoaRepository.findAll();
	}

	@ApiOperation(value = "Retorna uma pessoa conforme o ID(int) recebido da URL (PathVariable)")
	@GetMapping("/{id}")
	public Optional<PessoaModel> listarPessoas(@PathVariable Long id) {

		try {
			return pessoaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@ApiOperation(value = "Cadastra uma nova pessoa na base de dados!")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaModel cadastrar(@RequestBody PessoaModel pessoa) {
		System.out.println(pessoa.getNome());
		return pessoaRepository.save(pessoa);
	}

	@ApiOperation(value = "Exclusão da pessoa pelo ID informado (@PathVariable)",
			response = Iterable.class, tags = "deletePessoa")
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		System.out.println(id);
		pessoaRepository.deleteById(id);
	}

	@ApiOperation(value = "Altera uma pessoa, recebendo os dados da pessoa no RequestBody e o ID PathVariable",
			response = Iterable.class, tags = "putPessoa")
	@PutMapping("/{id}")
	public PessoaModel updatePessoa(@RequestBody PessoaModel pessoa, @PathVariable Long id) {
		PessoaModel p = pessoaRepository.getOne(id);
		p.setNome(pessoa.getNome());

		return pessoaRepository.save(p);
	}

}
