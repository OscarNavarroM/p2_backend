package com.backend.backend.controllers;

import com.backend.backend.models.Producto;
import com.backend.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("producto/count")
    public Integer countProducto(){
        List<Producto> total = this.productoRepository.findAll();
        return total.size();
    }

    @GetMapping("producto")
    public List<Producto> getAllProducto(){
        return this.productoRepository.findAll();
    }

    @GetMapping("producto/{id}")
    public Boolean existProducto(@PathVariable Integer id){
        Optional<Producto> opProducto = this.productoRepository.findById(id);
        return opProducto.isPresent();
    }

    @PostMapping("producto/create")
    @ResponseBody
    public Producto createProducto(@RequestBody Producto producto){

        return this.productoRepository.save(producto);
    }

    @DeleteMapping(value="producto/delete/{id}")
    @ResponseBody
    public String deleteProducto(@PathVariable Integer id){
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if(optionalProducto.isPresent()){
            productoRepository.delete(optionalProducto.get());
            return "Registro eliminado";
        }
        return "Registro no encontrado";
    }
}
