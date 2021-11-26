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
import fabricio.SpringAPI.Models.DisciplinaModel;
import fabricio.SpringAPI.Repositories.AlunoRepository;
import fabricio.SpringAPI.Repositories.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "REST APIs relacionada ao CRUD de Disciplinas!")
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@ApiOperation(value = "Retorna todos as disciplinas cadastradas", response = Iterable.class, tags = "getDisciplinas")
	@GetMapping
	public List<DisciplinaModel> listar() {

		return disciplinaRepository.findAll();
	}

	@ApiOperation(value = "Retorna uma disciplina conforme o ID(int) recebido da URL (PathVariable)")
	@GetMapping("/{id}")
	public Optional<DisciplinaModel> listarDisciplinaId(@PathVariable Long id) {

		try {
			return disciplinaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@ApiOperation(value = "Cadastra uma nova disciplina na base de dados!")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DisciplinaModel cadastrarDiscplina(@RequestBody DisciplinaModel disciplina) {
		System.out.println(disciplina.getNome());
		return disciplinaRepository.save(disciplina);
	}

	@ApiOperation(value = "Exclusão da disciplina pelo ID informado (@PathVariable)",
			response = Iterable.class, tags = "deleteDisciplina")
	@DeleteMapping("/{id}")
	public void deletarDisciplina(@PathVariable Long id) {
		System.out.println(id);
		disciplinaRepository.deleteById(id);
	}

	@ApiOperation(value = "Altera uma disciplina, recebendo os dados da disciplinas no RequestBody e o ID PathVariable",
			response = Iterable.class, tags = "putDisciplina")
	@PutMapping("/{id}")
	public DisciplinaModel updateDisciplina(@RequestBody DisciplinaModel disciplina, @PathVariable Long id) {
		DisciplinaModel p = disciplinaRepository.getOne(id);
		p.setNome(disciplina.getNome());

		return disciplinaRepository.save(p);
	}

}
