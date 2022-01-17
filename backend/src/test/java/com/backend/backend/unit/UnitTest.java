package com.backend.backend.unit;

import org.junit.jupiter.api.Test;
import com.backend.backend.models.Producto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitTest {
    @Test
    public void createTest(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1;
        try{
            date1 = formatter.parse("11/03/2022");
        }
        catch(Exception e){
            date1 = null;
        }
        Producto prod1 = new Producto("690504011", "Peras", date1, "Nacional", 1200);
        String url = "http://localhost:9000/api/producto/create";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Producto> request = new HttpEntity<>(prod1);
        Producto prodRes = null;
        try {
            prodRes = restTemplate.postForObject(url, request, Producto.class);
            assertNotNull(prodRes);
            assertEquals("Peras", prodRes.getNombre());
        }catch (Exception e){
            System.out.println("Error");
        }

    }
    @Test
    public void countTest(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1;
        try{
            date1 = formatter.parse("11/03/2022");
        }
        catch(Exception e){
            date1 = null;
        }
        Producto prod1 = new Producto("690504011", "Peras", date1, "Nacional", 1200);
        String url = "http://localhost:9000/api/producto/count";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(url, String.class);
            assertEquals("10", response.getBody());
        }catch(Exception e){
            System.out.println("Error");
        }

    }
    @Test
    public void deleteTest(){
        RestTemplate restTemplate = new RestTemplate();
        Integer id = 2;
        String deleteUrl = "http://localhost:9000/api/producto/delete/"+id.toString();
        try {
            restTemplate.delete(deleteUrl);
        }catch(Exception e){
            System.out.println("Error");
        }
        String existUrl = "http://localhost:9000/api/producto/"+id.toString();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(existUrl, String.class);
            assertEquals("false", response.getBody());
        }catch (Exception e){
            System.out.println("Error");
        }


    }
}
