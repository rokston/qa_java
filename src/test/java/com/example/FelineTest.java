package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline testFeline = new Feline();//создали свежий экземпляр Feline
    @Spy
    private Feline felineSpy;

    @Test
    public void testKittensEmptyArg(){ //проверяем количество котят, если аргумент метода не задан
        // количество котят с заданным аргументом проверяется в параметризованном тесте
        felineSpy.getKittens();
        Mockito.verify(felineSpy).getKittens(1);
    }

    @Test
    public void testFood() throws Exception {

        List<String> actualFelineFood = testFeline.eatMeat(); //получили список актуальной пищи
        String actualFood = String.join(", ", actualFelineFood); //преобразовали список в строку

        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба"); //составили список ожидаемой пищи
        String expectedFood = String.join(", ", expectedFelineFood); //преобразовали список в строку

        assertEquals(expectedFood, actualFood); //сравнили актуальную и ожидаемую пищу
    }


    @Test
    public void testFoodWithSpy() throws Exception{

        felineSpy.eatMeat();
        Mockito.verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void testFamily() {

        String actualFamily = testFeline.getFamily(); //получили семейство животного
        String expectedFamily = "Кошачьи"; //ожидаемое семейство для Feline
        assertEquals(expectedFamily, actualFamily); //сравнили актуальное и ожидаемое семейство
    }
}
