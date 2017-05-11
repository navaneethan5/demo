package myretail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myretail.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product> findByCategory(String category);

}
