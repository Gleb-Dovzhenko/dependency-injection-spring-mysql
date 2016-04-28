package edu.university.application;

import edu.university.domain.Product;
import edu.university.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gleb on 15.04.16.
 */
@Service
@Scope("singleton")
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ProductRepository repository;


    @Transactional
    public List<Product> getEntitiesWithEvenID() {

        List<Product> products = repository.getProducts();

        for (Product product: products) {
            if((product.getId()%2)!=0)
                products.remove(product);
        }

        return products;
    }

    @Transactional
    public void addWordToNameOfEntityWithE() {

        List<Product> products = repository.getProducts();

        for (Product product: products) {
            if(product.getName().startsWith("E"))
                product.setName(product.getName()+"_3");
                repository.updateProduct(product);
        }
    }
}