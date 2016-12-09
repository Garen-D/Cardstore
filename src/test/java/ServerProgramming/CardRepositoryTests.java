package ServerProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ServerProgramming.Card.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryTests {

    @Autowired
    private CardRepository repository;

    @Test
    public void findByLastnameShouldReturnCard() {
        List<Card> Cards = repository.findByLastName("Johnson");
        
        assertThat(Cards).hasSize(1);
        assertThat(Cards.get(0).getFirstName()).isEqualTo("John");
    }
    
    @Test
    public void createNewCard() {
    	Card Card = new Card("Mickey", "Mouse", "mm@mouse.com", new Category("BITE"));
    	repository.save(Card);
    	assertThat(Card.getId()).isNotNull();
    }    

}