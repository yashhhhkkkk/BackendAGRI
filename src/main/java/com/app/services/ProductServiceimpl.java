package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ProductDTO;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.entity.Category;
import com.app.entity.Product;

@Service
@Transactional
public class ProductServiceimpl implements ProductService{
	private ModelMapper mapper=new ModelMapper();
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductDTO> products = productDao.findAll().stream()
				                    .map(product -> mapper.map(product,ProductDTO.class)).collect(Collectors.toList());
		return products ;
	}
	
	@Override
	public String deleteProduct(Long productId) {

		 	if (productDao.existsById(productId)) {
		 		Product p = productDao.findById(productId).orElseThrow();
		 		System.out.println("product Found");

		 		Long cat_id = p.getProductCategory().getId();
		 		System.out.println("Prodcuts category is :=======>" + cat_id);
	 		    Category c = categoryDao.findById(cat_id).orElseThrow();
		 		System.out.println("Category is :=======>" + c.getCategoryName());
		 		c.removeProduct(p);
		 		System.out.println("Helper called");
		 		productDao.delete(p);

		 		

//				List<Cart> carts = cartRepo.findCartsByProductId(productId);
//
//				carts.forEach(cart -> cartService.deleteProductFromCart(cart.getCartId(), productId));
//
		 		
		 		
		    } else {
		    	return "Product Not Found";
		    }

		return "Product with productId: " + productId + " deleted successfully !!!";
	}

	@Override
	public ProductDTO addProduct(Product product, Long cat_id) {
		
		Category c = categoryDao.findById(cat_id).orElseThrow();
		c.addProduct(product);
		productDao.save(product);
		
		return mapper.map(product, ProductDTO.class);
			
	}
	
	@Override
	public ProductDTO updateProduct(Long pid, ProductDTO prod) {
		Product product = productDao.findById(pid).get();
		
		System.out.println(product.getProductName());
		
		Category cat = product.getProductCategory();
		
		product.setProductName(prod.getProductName());
		product.setPrice(prod.getPrice());
		product.setStockQuantity(prod.getStockQuantity());
		product.setDescription(prod.getDescription());
		
		categoryDao.save(cat);
		cat.getId();
		
		
		return mapper.map(product, ProductDTO.class);
	}

}
