package com.springreactivemongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreactivemongo.dto.ProductDto;
import com.springreactivemongo.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public Flux<ProductDto> getAllProducts()
	{
		return productService.getProducts();
	}
	
	@GetMapping("/get/{id}")
	public Mono<ProductDto> getProducts(@PathVariable String id)
	{
		return productService.getProduct(id);
	}
	
	@PostMapping("/save")
	public Mono<ProductDto> saveProducts(@RequestBody Mono<ProductDto> productDtoMono)
	{
		return productService.saveProduct(productDtoMono);
	}
	
	@PutMapping("/update/{id}")
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono,@PathVariable String id)
	{
		return productService.updateProduct(productDtoMono, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void>  deleteProduct(@PathVariable String id)
	{
		return productService.deleteProduct(id);
	}
}
