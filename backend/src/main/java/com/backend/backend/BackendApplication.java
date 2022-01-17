package com.backend.backend;

import com.backend.backend.models.Producto;
import com.backend.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.productoRepository.save(new Producto("780504011", "Bolsa de manzanas 1 kg", formatter.parse("23/02/2022"), "Nacional", 1000));
		this.productoRepository.save(new Producto("780504022", "Pack de cervezas", formatter.parse("23/08/2022"), "Importado", 2000));
		this.productoRepository.save(new Producto("780504033", "Pan de Molde", formatter.parse("12/03/2022"), "Nacional", 1500));
		this.productoRepository.save(new Producto("780504044", "Botella de yogurt", formatter.parse("23/03/2022"), "Nacional", 1500));
		this.productoRepository.save(new Producto("780504055", "Galletas de chocolate", formatter.parse("10/10/2022"), "Importado", 500));
		this.productoRepository.save(new Producto("780504066", "Vino tinto", formatter.parse("23/01/2025"), "Importado", 4000));
		this.productoRepository.save(new Producto("780504077", "Papas fritas", formatter.parse("15/10/2022"), "Importado", 1800));
		this.productoRepository.save(new Producto("780504088", "Helado de vainilla 1L", formatter.parse("24/03/2022"), "Nacional", 2300));
		this.productoRepository.save(new Producto("780504099", "Arroz 1 kg", formatter.parse("04/04/2023"), "Nacional", 1200));
		this.productoRepository.save(new Producto("780504013", "Harina 1 kg", formatter.parse("20/05/2023"), "Nacional", 800));

	}
}
