package com.example.shop14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;


    @PutMapping ("/PUT/products")
    public Product createProduct (@RequestBody Product product){
        if (!repository.existsById(product.getId()))
        return repository.save(product);
        else{
            System.out.println("This kind of product is already exist: " + product);
        }
            return null;
    }

    @DeleteMapping ("/DELETE/products/{id}")
    public void deleteProduct (@PathVariable Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        else {
            System.out.println("There is no Product with ID: " + id + "\n Please try again");
        }
    }

    @GetMapping("/GET/products/{id}")
    public Product getProductByProductId (@PathVariable Long id){
        if (repository.existsById(id)){
           return repository.findById(id).get();
        }
        else {
            System.out.println("There is no Product with ID: " + id + "\n Please try again");
        }
        return null;
    }

    @PostMapping("/PUT/products/{id}")
    public Product updateComment (@PathVariable Long id, @RequestBody Product product){
        if (repository.existsById(id) && product.getId().equals(id)){
            return repository.save(product);
        }
        System.out.println("There is no Product with ID: " + id + "\n Please try again");
        return null;
    }


}
