package fabricio.SpringAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabricio.SpringAPI.Models.AlunoModel;
import fabricio.SpringAPI.Models.DisciplinaModel;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

}
