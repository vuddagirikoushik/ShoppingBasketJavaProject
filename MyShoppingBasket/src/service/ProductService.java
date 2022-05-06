package service;

public interface ProductService {
	boolean eachTransaction(int category,int typeOfCategory,int requiredQuantity);
	double getTotalCost();

}
