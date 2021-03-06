package backend.master.controllers;

import java.util.List;
import java.util.Optional;

import backend.master.models.NameDTO;
import backend.master.models.Pet;
import backend.master.repositories.PetRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/pets")
class PetController {

    private final PetRepository petRepository;

    PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Get("/")
    List<NameDTO> all(Pageable pageable) {
        return petRepository.list(pageable);
    }

    @Get("/{name}")
    Optional<Pet> byName(String name) {
        return petRepository.findByName(name);
    }

}