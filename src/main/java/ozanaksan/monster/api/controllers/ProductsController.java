package ozanaksan.monster.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozanaksan.monster.business.abstracts.ProductService;
import ozanaksan.monster.core.utilities.results.DataResult;
import ozanaksan.monster.core.utilities.results.Result;
import ozanaksan.monster.entities.concretes.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>>getAll(){
        return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return  this.productService.add(product);
    }


}


