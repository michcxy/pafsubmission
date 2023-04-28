package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Item;
import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.services.BeerService;

@Controller
public class BeerController {

	@Autowired
	BeerService beerSvc;

	//TODO Task 2 - view 0
	@GetMapping(path="/")
	public String showIndex(Model model){
		List<Style> styles = beerSvc.getStyles();
		model.addAttribute("styles", styles);
		return "view0";
	}
	
	//TODO Task 3 - view 1
	@GetMapping(path="/beer/style/{id}")
	public String getBreweriesByBeer(Model model, @PathVariable String id, @RequestParam String styleName){
		Style style = new Style();
		style.setName(styleName);
		
		List<Beer> beer = beerSvc.getBreweriesByBeers(id);
		model.addAttribute("style", style);
		model.addAttribute("beer", beer);
		return "view1";
	}

	//TODO Task 4 - view 2
	@GetMapping(path="/brewery/{id}")
	public String getBeersFromBrewery(Model model, @PathVariable String id){

		Brewery brewery = beerSvc.getBeersFromBrewery(id).get();
		model.addAttribute("brewery", brewery);
		return "view2";
	}

	
	//TODO Task 5 - view 2, place order
	@PostMapping(path="/brewery/{breweryId}/order")
	public String placeOrder(Model model, @PathVariable String breweryId, @RequestParam MultiValueMap<String, String> map){
		Order order = new Order();

		for(String s : map.keySet()) {
			Item i = new Item(Integer.parseInt(s), Integer.parseInt(map.get(s).get(0)));
			order.getOrders().add(i);
		}
		
		return "view3";
	}

}
