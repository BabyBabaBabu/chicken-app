package me.kitaa.chickenapp.chickenapp.buyer;

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
@RequestMapping(path = "chickenapp/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @GetMapping
	public List<Buyer> getBuyers(){
		return buyerService.getBuyers();
	}

    @PostMapping
    public void enrollBuyer(@RequestBody Buyer buyer){
        buyerService.addNewBuyer(buyer);
    }

    @DeleteMapping(path = "{buyerId}")
    public void deleteBuyer(@PathVariable("buyerId") Long buyerId){
        buyerService.deleteBuyer(buyerId);
    }

    // @PutMapping(path = "{buyerId}")
    // public void updateBuyer(@PathVariable("buyerId") Long buyerId, @RequestBody Buyer buyer){
    //     buyerService.updateBuyerInfo( buyerId, buyer);
    // }

    @PutMapping(path = "{buyerId}")
    public void updateBuyer(
        @PathVariable("buyerId") Long buyerId, 
        @RequestParam(required = false) String Contact,
        @RequestParam(required = false) String Email,
        @RequestParam(required = false) String Region,
        @RequestParam(required = false) String Estate){
        buyerService.updateBuyerInfo(buyerId, Contact, Email, Region, Estate);
    }


    @GetMapping(path = "{buyerId}")
    public Optional<Buyer> getBuyerById(@PathVariable("buyerId") Long buyerId){
        return buyerService.getBuyerById(buyerId);
    }
    
}