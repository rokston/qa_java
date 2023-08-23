package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean doesHaveMane;


    public LionParamTest(String sex, boolean doesHaveMane) {
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] LionTestParam() { //пол, наличие гривы
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
                };
    }

    @Test

    public void testDoesHaveMane() throws Exception {
        Lion testAnimal = new Lion(sex,new Feline()); //создаем животное
        boolean actualMane = testAnimal.doesHaveMane();
        assertEquals(doesHaveMane, actualMane); //проверяем, должна ли у него быть грива,и  есть ли она
    }
}
