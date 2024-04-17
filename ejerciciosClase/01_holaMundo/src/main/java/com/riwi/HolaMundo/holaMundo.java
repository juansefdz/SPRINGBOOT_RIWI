package com.riwi.HolaMundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*indica que esta clase será un controlador */
@Controller
/*crea la ruta base del controlador */
@RequestMapping("/controller")
public class holaMundo {

    /*getMapping: crea una ruta especifica para el método */
    @GetMapping("/holamundo")
    /*ResponseBody: imprimir por pantalla */
    @ResponseBody
    public String mostrarMensaje(){

        return "hola mundo";
    }


    @GetMapping("/suma")
    @ResponseBody
    public String sumanumeros(){
        int num1= 2;
        int num2=2;
        int suma=num1+num2;
        

        return String.valueOf(suma);
    }

    
}