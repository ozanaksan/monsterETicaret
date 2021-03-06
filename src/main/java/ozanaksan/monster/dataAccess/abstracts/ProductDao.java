package ozanaksan.monster.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ozanaksan.monster.entities.concretes.Product;

import java.util.List;

public interface ProductDao  extends JpaRepository<Product,Integer> {

        Product getByProductName(String productName);

        Product getByProductNameAndCategoryId(String productName, int categoryId);

        List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

        List<Product> getByCategoryIdIn(List<Integer> categories);

        List<Product> getByProductNameContains(String productName);

        List<Product> getByProductNameStartsWith(String productName);

        @Query("From Product where productName=:productName and categoryId=:categoryId")
        List<Product> getByNameAndCategory(String productName , int categoryId);


        //
}
