package capstone.carru.repository.product;

import capstone.carru.entity.Product;
import java.util.Optional;
import java.util.List;

import capstone.carru.entity.User;
import capstone.carru.entity.status.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    Optional<Product> findByIdAndDeletedDateIsNullAndApprovedDateIsNotNull(Long id);
    List<Product> findAllByWarehouse_UserAndProductStatus(User user, ProductStatus status);
    Optional<Product> findByIdAndProductStatus(Long id, ProductStatus status);
    Optional<Product> findByIdAndWarehouseUserEmailAndApprovedDateIsNull(Long id, String email);
}
