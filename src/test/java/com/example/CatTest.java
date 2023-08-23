package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat testCat = new Cat(new Feline());

    @Test
    public void testGetSound(){
        String expectedSound = "Мяу";
        assertEquals(expectedSound, testCat.getSound());
        }
    @Test
    public void testCatFood() throws Exception {

        List<String> actualCatFood = testCat.getFood(); //получили список актуальной пищи
        String actualFood = String.join(", ", actualCatFood); //преобразовали список в строку

        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба"); //составили список ожидаемой пищи
        String expectedFood = String.join(", ", expectedCatFood); //преобразовали список в строку

        assertEquals(expectedFood, actualFood); //сравнили актуальную и ожидаемую пищу
    }
    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void testCatFoodSpy() throws Exception {
        Cat testCat = new Cat(felineSpy);
        List<String> actualCatFood = testCat.getFood(); //получили список актуальной пищи
        Mockito.verify(testCat.predator,Mockito.times(1)).eatMeat();

    }

}
