package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParam {

    private final int kittensCount;
    private final int resultKittensCount;

    public FelineTestParam(int kittensCount, int resultKittensCount) {
        this.kittensCount = kittensCount;
        this.resultKittensCount = resultKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] FelineTest() { //заданный аргумент, ожидаемое количество котят
        return new Object[][]{
                {1, 1},
                {0, 0},
                {5, 5},
        };
    }

    @Test
    public void testKittens() { //проверяем количество котят для метода с непустым аргументом
        Feline testFeline = new Feline();
        assertEquals(testFeline.getKittens(kittensCount), resultKittensCount);
    }
}