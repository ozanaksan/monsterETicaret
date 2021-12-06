package ozanaksan.monster.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozanaksan.monster.business.abstracts.ProductService;
import ozanaksan.monster.core.utilities.results.DataResult;
import ozanaksan.monster.core.utilities.results.Result;
import ozanaksan.monster.core.utilities.results.SuccessDataResult;
import ozanaksan.monster.core.utilities.results.SuccessResult;
import ozanaksan.monster.dataAccess.abstracts.ProductDao;
import ozanaksan.monster.entities.concretes.Product;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;
    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll(){
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategoryId(productName,categoryId),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategoryId(productName,categoryId),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIdIn(categories),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
    }
}
