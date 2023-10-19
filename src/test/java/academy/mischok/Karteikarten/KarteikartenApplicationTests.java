package academy.mischok.Karteikarten;

import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KarteikartenApplicationTests {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private CardRepository cardRepo;

	@Test
	void contextLoads() {
		cardRepo.save(Card.builder().id(1).answer("Frage 2").tags("tag2").build());
		cardRepo.save(Card.builder().id(2).answer("Frage 1").tags("tag1").build());
		cardRepo.save(Card.builder().id(3).tags("tag1").build());

		List<Card> cards = cardRepo.findAll((root, query, builder) -> {
			Predicate isAnswer1 = builder.equal(root.get("answer"), "Frage 1");
			Predicate isAnswer2 = builder.equal(root.get("answer"), "Frage 2");
			return builder.or(isAnswer1, isAnswer2);
		});

		var builder = entityManager.getCriteriaBuilder();
		var query = builder.createQuery(String.class);
		var root = query.from(Card.class);

		query.select(root.get("tags"));
		query.orderBy(builder.asc(root.get("tags")));
		query.distinct(true);
		query.where(builder.or(builder.equal(root.get("answer"), "Frage 1"), builder.equal(root.get("answer"), "Frage 2")));

		List<String> tags = entityManager.createQuery(query).getResultList();
		System.out.println(cards);
		System.out.println(tags);

	}

}
