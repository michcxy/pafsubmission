package ibf2022.assessment.paf.batch3.repositories;


public class DBQueries {
    public static final String  GET_STYLES = "SELECT styles.id, styles.style_name, COUNT(beers.style_id) as beer_count FROM styles LEFT JOIN beers ON styles.id = beers.style_id GROUP BY styles.id ORDER BY beer_count DESC, styles.style_name ASC";
    
    public static final String GET_BREWERIES_BY_BEER = "SELECT beers.name AS beer_name, beers.id AS beer_id, beers.descript AS beer_description, beers.brewery_id AS brewery_id, breweries.name as brewery_name, styles.style_name AS style_name FROM BEERS LEFT JOIN breweries ON beers.brewery_id = breweries.id LEFT JOIN styles ON beers.style_id = styles.id where styles.id = ? ORDER BY beers.name ASC";

    public static final String GET_BEERS_FROM_BREWERY = "SELECT breweries.name AS brewery_name, breweries.address1, breweries.city, breweries.phone, breweries.website, breweries.descript AS brewery_description, beers.name as beer_name, beers.descript as beer_description FROM breweries LEFT JOIN beers ON breweries.id = beers.brewery_id where breweries.id = ? ORDER BY beers.name";

}
