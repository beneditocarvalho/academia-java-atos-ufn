package ServerFaces.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "alunoBean")
@RequestScoped
public class AlunoBean {
	public String cadastrar(String nome, String email) {
		return "O aluno " + nome + " com email " + email + " foi cadastrado com sucesso!";
	}

	public String hello() {
		return "olá mundo";
	}
}
