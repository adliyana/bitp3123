package my.edu.utem.ftmk.dad.restoredrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.restoredrapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
