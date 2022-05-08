package service;

import java.util.Optional;

import entity.Product;
import persistence.ProductDao;
import persistence.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao dao=new ProductDaoImpl();
	private double totalCost=0;
	

	public double getTotalCost() {
		return totalCost;
	}


	@Override
	public String eachTransaction(int category, int typeOfCategory, int requiredQuantity) {
		Optional<Product> product=dao.getProduct(category, typeOfCategory);
		int newQuantity;
		double cost;
		if(product.isPresent()) {
			if(product.get().getNoOfItems()>=requiredQuantity) {
				cost=product.get().getPrice()*requiredQuantity;
				cost=cost+(product.get().getSalesTax()*cost/100);
				newQuantity=product.get().getNoOfItems()-requiredQuantity;
				if(!(dao.updateProductInventory(category, typeOfCategory,newQuantity)>0))
					return null;
//				builder.append("Product name:"+product.get().getProductName()+"No of items:"+requiredQuantity+"Price: "+cost+"\n");
				totalCost=totalCost+cost;
				return "Product name:"+product.get().getProductName()+" No of items:"+requiredQuantity+" Price: "+cost+"\n";
			}
			else
				System.out.println("Insufficient stock");
				return null;
		}
		
		return null;
	}


	
}
