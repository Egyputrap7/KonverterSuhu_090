/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konverter.Suhu;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */

@Controller
public class SuhuController {
    public double CelciusToKelvin(int Celcius){
   return (Celcius + 273.15);   
}
public double CelciusToFahrenheit(int Celcius){
    return (Celcius * 9/5) + 32;
}   
    public double CelciusToReamur(float Celcius){
   return (Celcius * 4 / 5);
    }
   
@ResponseBody
@RequestMapping("/suhu")
public String getResult(HttpServletRequest data){
    double hasil = 0.0;
    
    int getSuhu = Integer.parseInt(data.getParameter("suhu"));
    String option = data.getParameter("pilihan");
    
    if(option.equals("Kelvin")){
        hasil = CelciusToKelvin(getSuhu); 
    }else if(option.endsWith("Fahrenheit")){
         hasil = CelciusToFahrenheit(getSuhu) ;
    }else{
         hasil = CelciusToReamur(getSuhu) ;
    }

    return option +"  =  " + String.valueOf(hasil);   
    }

}   
    
    
    
    

