package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;

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
                {"Трансгендер", false}
        };
    }

    //Сделал, что просто тест падает. Пытался сделать модно через assertThrows, не получилось=(
    @Test
    public void checkManeOfLineCorrectSex() throws Exception{
        Lion lion = new Lion(actualSex, feline);
        Assert.assertEquals("Ожидается совпадение пола", expectedSex, lion.doesHaveMane());
    }

    //В целом, работает, но, мне кажется, т.к. вызывается feline.getKittens(), лучше вынести в отдельный тест с мокированием
    @Test
    public void shouldHaveKittens() throws Exception{
        int expectedKitten = 1;
        Lion lion = new Lion(actualSex, feline);
        Assert.assertEquals("Ждём одну живность",expectedKitten, lion.getKittens());
    }

    //Тут нет изоляции, потому что не могу вызвать feline.getFood("Хищник"), т.к. не могу запустить тест с @RunWith(MockitoJUnitRunner.class), он уже параметризирован или могу?
    //@Test
    //public void shouldHaveCorrectListOfMeal() throws Exception{
    //List<String> expectedMeal = List.of("Животные", "Птицы", "Рыба");
    //    Lion lion = new Lion(actualSex, feline);
    //    Assert.assertEquals("Ожидаем совпадение перекусика",expectedMeal, lion.getFood());
    //}
}
