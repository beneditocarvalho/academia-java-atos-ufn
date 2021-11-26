package fabricio.SpringAPI.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fabricio.SpringAPI.Models.MatriculaModel;
import fabricio.SpringAPI.Repositories.MatriculaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST APIs relacionada ao CRUD de Alunos!")
@RestController
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	MatriculaRepository matriculaRepository;

	@ApiOperation(value = "Retorna todas as matriculas cadastradas", response = Iterable.class, tags = "getMatriculas")
	@GetMapping
	public List<MatriculaModel> listar() {

		return matriculaRepository.findAll();
	}

	@ApiOperation(value = "Retorna uma matricula conforme o ID(int) recebido da URL (PathVariable)")
	@GetMapping("/{id}")
	public Optional<MatriculaModel> listarMatriculaId(@PathVariable Long id) {

		try {
			return matriculaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@ApiOperation(value = "Cadastra uma nova matricula na base de dados!")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MatriculaModel cadastrarMatricula(@RequestBody MatriculaModel matricula) {
		System.out.println(matricula.getAluno().getNome());
		System.out.println(matricula.getDisciplina().getNome());
		return matriculaRepository.save(matricula);
	}

//	@ApiOperation(value = "Exclusão do aluno pelo ID informado (@PathVariable)",
//			response = Iterable.class, tags = "deleteAluno")
//	@DeleteMapping("/{id}")
//	public void deletarAluno(@PathVariable Long id) {
//		System.out.println(id);
//		alunoRepository.deleteById(id);
//	}
//
//	@ApiOperation(value = "Altera um aluno, recebendo os dados do estudante no RequestBody e o ID PathVariable",
//			response = Iterable.class, tags = "putAluno")
//	@PutMapping("/{id}")
//	public AlunoModel updateAluno(@RequestBody AlunoModel aluno, @PathVariable Long id) {
//		AlunoModel p = alunoRepository.getOne(id);
//		p.setNome(aluno.getNome());
//
//		return alunoRepository.save(p);
//	}
	

}
