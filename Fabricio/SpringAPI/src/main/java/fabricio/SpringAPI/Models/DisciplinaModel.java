package fabricio.SpringAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class DisciplinaModel {

	@ApiModelProperty(notes = "É o ID da disciplina, é autoincremento...", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(notes = "Nome da disciplina", name = "nome", required = true, value = "Nome da disciplina")
	@Column(nullable = false)
	private String nome;

	private Integer vagas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	@Override
	public String toString() {
		return "DisciplinaModel [id=" + id + ", nome=" + nome + ", vagas=" + vagas + "]";
	}
	
}