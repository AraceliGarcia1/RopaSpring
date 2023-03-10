package mx.edu.utez.ropa.ropa.service;

import mx.edu.utez.ropa.ropa.model.Ropa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRopaService extends JpaRepository<Ropa,Long> {
    List<Ropa> findAll();
    Ropa findById(long id);
    boolean existsById(long id);

}
