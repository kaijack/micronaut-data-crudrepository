package backend.master.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import backend.master.models.NameDTO;
import backend.master.models.Pet;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface PetRepository extends PageableRepository<Pet, UUID> {

    List<NameDTO> list(Pageable pageable);

    @Join("owner")
    Optional<Pet> findByName(String name);
}