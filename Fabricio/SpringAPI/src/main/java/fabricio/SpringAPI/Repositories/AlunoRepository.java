package fabricio.SpringAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabricio.SpringAPI.Models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

}
