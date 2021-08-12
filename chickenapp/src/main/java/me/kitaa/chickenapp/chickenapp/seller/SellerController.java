package me.kitaa.chickenapp.chickenapp.seller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "chickenapp/sellers")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping
	public List<Seller> getSellers(){
		return sellerService.getSellers();
	}

    @PostMapping
    public void enrollSeller(@RequestBody Seller seller){
        sellerService.addNewSeller(seller);
    }

    @DeleteMapping(path = "{sellerId}")
    public void deleteSeller(@PathVariable("sellerId") Long sellerId){
        sellerService.deleteSeller(sellerId);
    }

    // @PutMapping(path = "{sellerId}")
    // public void updateSeller(@PathVariable("sellerId") Long sellerId, @RequestBody Seller seller){
    //     sellerService.updateSellerInfo( sellerId, seller);
    // }

    @PutMapping(path = "{sellerId}")
    public void updateSeller(
        @PathVariable("sellerId") Long sellerId, 
        @RequestParam(required = false) String Contact,
        @RequestParam(required = false) String Email,
        @RequestParam(required = false) String Region,
        @RequestParam(required = false) String Estate,
        @RequestParam(required = false) String poultryType,
        @RequestParam(required = false) Integer Quantity,
        @RequestParam(required = false) String Price){
        sellerService.updateSellerInfo(sellerId, Contact, Email, Region, Estate, poultryType, Quantity, Price);
    }


    @GetMapping(path = "{sellerId}")
    public Optional<Seller> getSellerById(@PathVariable("sellerId") Long sellerId){
        return sellerService.getSellerById(sellerId);
    }
    
}