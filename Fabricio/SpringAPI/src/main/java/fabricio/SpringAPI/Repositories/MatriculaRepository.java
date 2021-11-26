package fabricio.SpringAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fabricio.SpringAPI.Models.MatriculaModel;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {

}
