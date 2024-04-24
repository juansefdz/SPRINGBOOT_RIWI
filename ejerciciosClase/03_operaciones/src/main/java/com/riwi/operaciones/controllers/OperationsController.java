package com.riwi.operaciones.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operaciones.entities.Operations;

@RestController
@RequestMapping("api/v1/operations")
public class OperationsController {

    @PostMapping(path = "/sum")
    public String sum(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1()+objOperations.getNum2());

        return objOperations.getNum1()+" + "+objOperations.getNum2()+" = "+message;

    }


    @PostMapping(path = "/res")
    public String res(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1()- objOperations.getNum2());

        return objOperations.getNum1()+" - "+objOperations.getNum2()+" = "+message;
    }

    @PostMapping(path = "/mul")
    public String mul(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1()* objOperations.getNum2());

        return objOperations.getNum1()+" * "+objOperations.getNum2()+" = "+message;
    }
    
    @PostMapping(path = "/div")
    public String div(@RequestBody Operations objOperations){
        if (objOperations.getNum2()==0) {
            return "no se puede dividir números entre 0"; 
        }
        String message = String.valueOf(objOperations.getNum1()/ objOperations.getNum2());

        return objOperations.getNum1()+" / "+objOperations.getNum2()+" = "+message;
    }

    @PostMapping(path = "/pow")
    public String pow(@RequestBody Operations objOperations){
        String message = String.valueOf(Math.pow(objOperations.getNum1(),objOperations.getNum2()));

        return objOperations.getNum1()+" ^ "+objOperations.getNum2()+" = "+message;
    }
    
    
    

    


    
}
