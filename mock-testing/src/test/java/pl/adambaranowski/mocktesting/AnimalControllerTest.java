package pl.adambaranowski.mocktesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnimalControllerTest {


    //nie działa bo to jest lista immutable
    public List<Animal> prepareData(){
        return Arrays.asList(new Animal("dog"), new Animal("cat"));
    }

    @Test
    void getAnimals() {
        //given

        List<Animal> animals = prepareData();
        List<Animal> animals2 = prepareData();

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list1.add("red");
        list1.add("green");
        list1.add("orange");

        list2.add("red");
        list2.add("green");
        list2.add("orange");

        AnimalController animalController = mock(AnimalController.class);


        //when
        when(animalController.getAnimals()).thenReturn(animals);
        //then
        assertThat(animalController.getAnimals(), equalTo(animals));
        assertEquals(list1, list2);

    }
}