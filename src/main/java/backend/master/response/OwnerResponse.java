package backend.master.response;


import java.util.ArrayList;
import java.util.List;

import backend.master.models.Owner;

/** 
 * Author : supi.core@gmail.com | github.com/sup1core
 */ 

 public class OwnerResponse {
    
     public String status;
     public String message;
     public ArrayList<Owner> data;

     public OwnerResponse (String status, String message, List<Owner> Owner) {
         this.status = status;
         this.message = message;         
         this.data = new ArrayList<Owner>();

         for (Owner item:Owner) {
             this.data.add(item);
         }
     }  
        
     public OwnerResponse (String status, String message, Owner Owner) { 
         this.status = status;
         this.message = message;
         this.data = new ArrayList<Owner>();
      
         if (Owner != null) {
             this.data.add(Owner);
         }
     }

     public OwnerResponse(String status, String message) {
         this.status = status;
         this.message = message;
     }
 }