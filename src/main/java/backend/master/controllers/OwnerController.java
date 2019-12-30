package backend.master.controllers;

import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;

import javax.validation.constraints.NotBlank;

import backend.master.models.Owner;
import backend.master.repositories.OwnerRepository;
import backend.master.response.OwnerResponse;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Put;

import javax.validation.constraints.NotNull;

/**     
 * Author : kaijack.046@gmail.com | github.com/kaijack
 * inspired from the example 
 * https://micronaut-projects.github.io/micronaut-data/snapshot/api/index.html?io/micronaut/data/repository/CrudRepository.html
 */   

@Controller("/owners")
class OwnerController {

    private final OwnerRepository ownerRepository;

    OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Get("/")
    public String index(){
        try {
                List<Owner> owner = ownerRepository.findAll();
                OwnerResponse response = new OwnerResponse ("ok", "data owner", owner );

                return new Gson().toJson(response);

            } catch (Exception e) {
                String message = e.getMessage();
                OwnerResponse response = new OwnerResponse ("error", message);

                return new Gson().toJson(response);
        }
    }

    // @Get("/{name}")
    // Optional<Owner> byName(@NotBlank String name) {
    //     return ownerRepository.findByName(name);
    // }

    @Get("/{id}")
    Optional<Owner> byId(@NotBlank Long id) {
        return ownerRepository.findById(id);
    }

    @Post("/")
    String save(@NotNull Owner owner) {
      try {
          Boolean exist = ownerRepository.existsByName(owner.getName());
          if(owner.getName() == null || owner.getName() == ""){
              OwnerResponse response = new OwnerResponse("error", "name tidak boleh kosong");    
                 return new Gson().toJson(response);
          } 
          if(owner.getAge() == 0){
              OwnerResponse response = new OwnerResponse("error", "Age tidak boleh kosong");    
                 return new Gson().toJson(response);
          } 
          if(exist == true ){
              OwnerResponse response = new OwnerResponse("error", "nama sudah ada");    
                 return new Gson().toJson(response);

          } else {
                Owner result = ownerRepository.save(owner);
                if(result != null){
                    OwnerResponse response = new OwnerResponse("ok", "Insert data is successfull:", result);
                    return new Gson().toJson(response);
                } else {
                    OwnerResponse response = new OwnerResponse("error", "failed", result);
                    return new Gson().toJson(response);

                }
          }
       
      }  
      catch (Exception e) {
            return (e.getMessage());
        }
    }

    @Put("/{id}")
    public String update(@NotNull Long id, Owner owner ) {
       try {
           boolean getOwner = ownerRepository.existsById(id);
           if(getOwner == true){
                Boolean exist = ownerRepository.existsByName(owner.getName());
          if(owner.getName() == null || owner.getName() == ""){
              OwnerResponse response = new OwnerResponse("error", "name tidak boleh kosong");    
                return new Gson().toJson(response);
          } 
          if(owner.getAge() == 0){
              OwnerResponse response = new OwnerResponse("error", "Age tidak boleh kosong");    
                return new Gson().toJson(response);
          } 
          if(exist == true ){
                OwnerResponse response = new OwnerResponse("error", "nama sudah ada");    
                return new Gson().toJson(response);
          } else {
              ownerRepository.updateById(id, owner.getName(), owner.getAge());
                    OwnerResponse response = new OwnerResponse ("ok","Berhasil memperbaharui data owner");
                    return new Gson().toJson(response);

          } 
               
           } else {
            OwnerResponse response = new OwnerResponse("error", "Data owner tidak ditemukan");
                    return new Gson().toJson(response);
           }
            
        }
        catch (Exception e) {
            return (e.getMessage());
        }

    }

    @Delete("/{id}")
    String delete(Long id) {
         boolean getOwners = ownerRepository.existsById(id);
        try {
            if(getOwners == true){
                ownerRepository.deleteById(id);
                // return "oke";
                OwnerResponse response = new OwnerResponse("ok","Berhasil menghapus data owner");
                return new Gson().toJson(response);
           } else {
            //    return "data not found";
            OwnerResponse response = new OwnerResponse("error", "Data owner tidak ditemukan");
            return new Gson().toJson(response);
           }
        }
        catch (Exception e) {
            return (e.getMessage());
        }
    }
}