package persistence;

import java.util.Optional;

import entity.Product;

public interface ProductDao {
	Optional<Product> getProduct(int category,int typeOfCategory);
	int updateProductInventory(int category,int typeOfCategory,int updatedQuantity);

}
