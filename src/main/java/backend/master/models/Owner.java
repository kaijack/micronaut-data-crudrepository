package backend.master.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

/**     
 * Author : kaijack.046@gmail.com | github.com/kaijack
 * inspired from the example 
 * https://micronaut-projects.github.io/micronaut-data/snapshot/api/index.html?io/micronaut/data/repository/CrudRepository.html
 */   
@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GenericGenerator(name="incrementId",strategy="increment")
    @GeneratedValue(generator = "incrementId")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Nama harus di isi")
    private String name;
    

    @NotNull(message = "Age harus diisi.")
    private int age;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_date;

    @Column(name = "updated_date", nullable = false, updatable =false)
    @CreationTimestamp
    private Date updated_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreated_date(){
        return created_date;
    }
    
    public void setCreated_Date(Date created_date){
        this.created_date = created_date;
    }

    public Date getUpdated_Date(){
        return updated_date;
    }

    public void setUpdated_Date(Date updated_date){
        this.updated_date = updated_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
}