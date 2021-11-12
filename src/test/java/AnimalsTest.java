import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsTest {

    @Test
    void getAnimal_name() {
        Animals animal1=new Animals("Kitty","fish","play");
        animal1.setAnimal_name("Twinkle");
        Assertions.assertEquals("Twinkle",animal1.getAnimal_name());
    }
}