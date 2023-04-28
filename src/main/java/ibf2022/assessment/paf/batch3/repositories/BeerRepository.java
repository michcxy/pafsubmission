package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		List<Style> styles = new ArrayList<Style>();
		
        SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_STYLES);

        while (rs.next()) {
			Style s = new Style();
			s.setName(rs.getString("style_name"));
			s.setBeerCount(rs.getInt("beer_count"));
			s.setStyleId(rs.getInt("id"));
			styles.add(s);
        }

		return styles;
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(String id) {
		// TODO: Task 3
		List<Beer> beers = new ArrayList<Beer>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BREWERIES_BY_BEER, id);
		while (rs.next()) {
			Beer b = new Beer();
			b.setBeerName(rs.getString("beer_name"));
			b.setBeerDescription(rs.getString("beer_description"));
			b.setBeerId(rs.getInt("beer_id"));
			b.setBreweryName(rs.getString("brewery_name"));
			b.setBreweryId(rs.getInt("brewery_id"));
			beers.add(b);
        }
		return beers;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(String id) {
		// TODO: Task 4
		Brewery brewery = new Brewery();
		List<Beer> beers = new ArrayList<>();
       
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEERS_FROM_BREWERY, id);

		while(rs.next()){
			if(brewery.getName() == null){
				brewery.setName(rs.getString("brewery_name"));
				brewery.setAddress1(rs.getString("address1"));
				brewery.setCity(rs.getString("city"));
				brewery.setPhone(rs.getString("phone"));
				brewery.setWebsite(rs.getString("website"));
				brewery.setDescription(rs.getString("brewery_description"));
			}
			
			Beer beer = new Beer();
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_description"));
			beers.add(beer);	
		}
		brewery.setBeers(beers);
		return Optional.ofNullable(brewery);
		//return Optional.empty();
	}
	
}
