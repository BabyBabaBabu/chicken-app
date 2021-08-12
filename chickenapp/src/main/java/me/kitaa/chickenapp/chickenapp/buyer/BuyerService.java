package me.kitaa.chickenapp.chickenapp.buyer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BuyerService {
    

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> getBuyers(){
        return buyerRepository.findAll();
    }

    public void addNewBuyer(Buyer buyer) {
        Optional<Buyer> buyerOptional = buyerRepository.findBuyerByEmail(buyer.getEmail());
		if ( buyerOptional.isPresent()){
			throw new IllegalStateException("Buyer with the email already enrolled!");
		} 
		buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long buyerId) {
        boolean existsById = buyerRepository.existsById(buyerId);
		if (!existsById){
			throw new IllegalStateException("Buyer with the id:" + buyerId + " does not exist!");
		}
		buyerRepository.deleteById(buyerId);
    }

    public void updateBuyerInfo(Long buyerId,
            String Contact, 
            String Email, 
            String Region,
            String Estate) {
                Buyer buyer = buyerRepository.findById(buyerId)
			.orElseThrow(() -> new IllegalStateException("Buyer with the id: " + buyerId + " does not exist!"));
		
			if (Contact != null && Contact.length() > 0 && !Objects.equals(buyer.getContact(), Contact)){
				buyer.setContact(Contact);
			}
			if (Email != null && Email.length() > 0 && !Objects.equals(buyer.getEmail(), Email)){
				Optional<Buyer> buyerOptional = buyerRepository.findBuyerByEmail(buyer.getEmail());
				if ( buyerOptional.isPresent()){
					throw new IllegalStateException("Email: "+ Email +" is already taken!");
				}
				buyer.setEmail(Email);
			}
			if (Region != null && Region.length() > 0 && !Objects.equals(buyer.getRegion(), Region)){
				buyer.setRegion(Region);
			}
			if (Estate != null && Estate.length() > 0 && !Objects.equals(buyer.getEstate(), Estate)){
				buyer.setEstate(Estate);
			}
    }

    public Optional<Buyer> getBuyerById(Long buyerId) {
        return buyerRepository.findById(buyerId);
    }

   


}