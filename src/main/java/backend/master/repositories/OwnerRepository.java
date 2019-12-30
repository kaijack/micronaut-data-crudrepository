package backend.master.repositories;

import java.util.List;
import java.util.Optional;

import backend.master.models.Owner;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import javax.validation.constraints.NotNull;

/**     
 * Author : kaijack.046@gmail.com | github.com/kaijack
 * inspired from the example 
 * https://micronaut-projects.github.io/micronaut-data/snapshot/api/index.html?io/micronaut/data/repository/CrudRepository.html
 */   

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Override
    List<Owner> findAll();
    
    Owner save(@NotNull Owner Owner);

    Optional<Owner> findByName(String name);
    Optional <Owner> findById(@NotNull Long id);
    boolean existsById(@NotNull Long id);
    Boolean existsByName(String name);

    void deleteById(Long id);
    void updateById(@NotNull Long id, String name, Integer age);

}