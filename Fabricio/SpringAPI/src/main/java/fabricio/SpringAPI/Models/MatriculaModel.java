package fabricio.SpringAPI.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class MatriculaModel {
	
	@ApiModelProperty(notes = "É o ID da matricula, é autoincremento", name = "id", required = true)
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne    
    private AlunoModel aluno;
    @ManyToOne    
    private DisciplinaModel disciplina;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AlunoModel getAluno() {
		return aluno;
	}
	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}
	public DisciplinaModel getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaModel disciplina) {
		this.disciplina = disciplina;
	}
    
}