package ibf2022.assessment.paf.batch3.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	// TODO: Task 5
	public void insertOrder(){
		//mongoTemplate.insert(Document.parse(<order in json format>), <collection name>);
	}
}
