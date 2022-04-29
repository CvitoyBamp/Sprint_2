package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    public String actualSex;
    public boolean expectedSex;

    public LionTest(String actualSex, boolean expectedSex) {
        this.actualSex = actualSex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void checkManeOfLineCorrectSex() throws Exception{
        Lion lion = new Lion(actualSex);
        Assert.assertEquals("Ожидается совпадение пола",expectedSex,lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void checkManeOfLineInCorrectSex() throws Exception{
        Lion lion = new Lion("Трансгендер");
        Assert.assertEquals(new Exception("Используйте допустимые значения пола животного - самей или самка"),lion.doesHaveMane());
    }

    @Test
    public void shouldHaveKittens() throws Exception{
        int expectedKitten = 1;
        Lion lion = new Lion(actualSex);
        Assert.assertEquals("Ждём одну живность",expectedKitten, lion.getKittens());
    }

    @Test
    public void shouldHaveCorrectListOfMeal() throws Exception{
        List<String> expectedMeal = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(actualSex);
        Assert.assertEquals("Ожидаем совпадение перекусика",expectedMeal, lion.getFood());
    }

}
