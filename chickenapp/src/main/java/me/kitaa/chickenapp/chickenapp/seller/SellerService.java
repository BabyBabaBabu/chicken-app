package me.kitaa.chickenapp.chickenapp.seller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerService {
    
	private final SellerRepository sellerRepository;

	@Autowired
    public SellerService(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	public List<Seller> getSellers(){
		return sellerRepository.findAll();
	}

	public void addNewSeller(Seller seller) {
		Optional<Seller> sellerOptional = sellerRepository.findSellerByEmail(seller.getEmail());
		if ( sellerOptional.isPresent()){
			throw new IllegalStateException("Seller with the email already enrolled!");
		} 
		sellerRepository.save(seller);
	}

    public void deleteSeller(Long sellerId) {
		boolean existsById = sellerRepository.existsById(sellerId);

		if (!existsById){
			throw new IllegalStateException("Seller with the id:" + sellerId + " does not exist!");
		}
		sellerRepository.deleteById(sellerId);
    }

    // public void updateSellerInfo(Long sellerId, Seller seller) {
	// 	boolean existsById = sellerRepository.existsById(sellerId);
	// 	if (!existsById){
	// 		throw new IllegalStateException("Seller with the id:" + sellerId + " does not exist!");
	// 	}
	// 	sellerRepository.save(seller);
    // }
	@Transactional
	public void updateSellerInfo(
			Long sellerId, 
			String Contact, 
			String Email, 
			String Region,
			String Estate,
			String poultryType,
			Integer Quantity,
			String Price) {
			Seller seller = sellerRepository.findById(sellerId)
			.orElseThrow(() -> new IllegalStateException("Seller with the id: " + sellerId + " does not exist!"));
		
			if (Contact != null && Contact.length() > 0 && !Objects.equals(seller.getContact(), Contact)){
				seller.setContact(Contact);
			}
			if (Email != null && Email.length() > 0 && !Objects.equals(seller.getEmail(), Email)){
				Optional<Seller> sellerOptional = sellerRepository.findSellerByEmail(seller.getEmail());
				if ( sellerOptional.isPresent()){
					throw new IllegalStateException("Email: "+ Email +" is already taken!");
				}
				seller.setEmail(Email);
			}
			if (Region != null && Region.length() > 0 && !Objects.equals(seller.getRegion(), Region)){
				seller.setRegion(Region);
			}
			if (Estate != null && Estate.length() > 0 && !Objects.equals(seller.getEstate(), Estate)){
				seller.setEstate(Estate);
			}
			
			if (poultryType != null && poultryType.length() > 0 && !Objects.equals(seller.getPoultryType(), poultryType)){
				seller.setPoultryType(poultryType);
			}

			if(Quantity != null && !Objects.equals(seller.getQuantity(), Quantity)){
				seller.setQuantity(Quantity);
			}

			if (Price!= null && Price.length() > 0 && !Objects.equals(seller.getPrice(), Price)){
				seller.setPrice(Price);
			}
	}


	public Optional<Seller> getSellerById(Long sellerId){
		return sellerRepository.findById(sellerId);
	}
}