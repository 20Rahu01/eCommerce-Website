package com.shopping.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.Entities.ProductDetails;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.ProductRepositoy;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	private ProductRepositoy productRepository;
	
	@Override
	public ProductDetails createProduct(int productNo,ProductDetails product) {
		ProductDetails productDetails = productRepository.findById(productNo).get();
		
		float price= productDetails.getProductOrginalPrice()-
				((productDetails.getProductOrginalPrice()*productDetails.getDiscount())/100);
		productDetails.setProductPrice(price);
		return productRepository.save(product);
	}
	
	@Override
	public String deleteProduct(int id) {
		String message=null;
		Optional<ProductDetails> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.deleteById(id);
			message=new String("Product record deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("Product","id",id);
		}
		return message;
	}


	@Override
	public ProductDetails updateProduct(int id, ProductDetails product) {
		ProductDetails existingProduct = productRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Product", "id", id));
		existingProduct.setCategory(product.getCategory());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductOrginalPrice(product.getProductOrginalPrice());
		existingProduct.setDiscount(product.getDiscount());
		existingProduct.setProductPrice(product.getProductPrice());
		existingProduct.setTotalAmountPresent(product.getTotalAmountPresent());
		existingProduct.setRatings(product.getRatings());
		existingProduct.setTotalPurchase(product.getTotalPurchase());
		
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public ProductDetails getProductById(int id) {
		ProductDetails productById = productRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Product", "id", id));
		
		return productById;
	}

	@Override
	public List<ProductDetails> getAllProduct() {
		List<ProductDetails> productAll = productRepository.findAll();
		return productAll;
	}

	@Override
	public List<ProductDetails> getProductByName(String productName) {
		List<ProductDetails> productByName= productRepository.getProductByName(productName);
		return productByName;
	}
}
