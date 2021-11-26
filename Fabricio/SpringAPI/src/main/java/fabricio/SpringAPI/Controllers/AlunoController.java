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

import fabricio.SpringAPI.Models.AlunoModel;
import fabricio.SpringAPI.Repositories.AlunoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST APIs relacionada ao CRUD de Alunos!")
@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;

	@ApiOperation(value = "Retorna todos os alunos cadastrados", response = Iterable.class, tags = "getAlunos")
	@GetMapping
	public List<AlunoModel> listar() {

		return alunoRepository.findAll();
	}

	@ApiOperation(value = "Retorna um aluno conforme o ID(int) recebido da URL (PathVariable)")
	@GetMapping("/{id}")
	public Optional<AlunoModel> listarAlunosId(@PathVariable Long id) {

		try {
			return alunoRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@ApiOperation(value = "Cadastra um novo aluno na base de dados!")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlunoModel cadastrarAluno(@RequestBody AlunoModel aluno) {
		System.out.println(aluno.getNome());
		return alunoRepository.save(aluno);
	}

	@ApiOperation(value = "Exclusão do aluno pelo ID informado (@PathVariable)",
			response = Iterable.class, tags = "deleteAluno")
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable Long id) {
		System.out.println(id);
		alunoRepository.deleteById(id);
	}

	@ApiOperation(value = "Altera um aluno, recenendo os dados do estudante no RequestBody e o ID PathVariable",
			response = Iterable.class, tags = "putEstudante")
	@PutMapping("/{id}")
	public AlunoModel updateAluno(@RequestBody AlunoModel aluno, @PathVariable Long id) {
		AlunoModel p = alunoRepository.getOne(id);
		p.setNome(aluno.getNome());

		return alunoRepository.save(p);
	}

}
