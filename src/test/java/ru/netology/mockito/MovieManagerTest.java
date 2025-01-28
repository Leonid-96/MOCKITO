package ru.netology.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MovieManagerTest {

    @Test
    public void test1FindAll() {

        MovieManager manager = new MovieManager();

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");
        manager.addNewMovie("Film III");
        manager.addNewMovie("Film IV");
        manager.addNewMovie("Film V");
        manager.addNewMovie("Film VI");
        manager.addNewMovie("Film VII");

        String[] actual = manager.findAll();
        String[] expected = {"Film I", "Film II", "Film III", "Film IV", "Film V", "Film VI", "Film VII"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test2AddZero() {

        MovieManager manager = new MovieManager();

        String[] actual = manager.findLast();
        String[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test3AddOne() {

        MovieManager manager = new MovieManager();

        manager.addNewMovie("Film I");

        String[] actual = manager.findLast();
        String[] expected = {"Film I"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test4AddTwo() {

        MovieManager manager = new MovieManager();

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");

        String[] actual = manager.findLast();
        String[] expected = {"Film II", "Film I"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test5ShouldLimit() {

        MovieManager manager = new MovieManager(7);

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");
        manager.addNewMovie("Film III");
        manager.addNewMovie("Film IV");
        manager.addNewMovie("Film V");
        manager.addNewMovie("Film VI");
        manager.addNewMovie("Film VII");

        String[] actual = manager.findLast();
        String[] expected = {"Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test6ShouldLimit5() {

        MovieManager manager = new MovieManager(7);

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");
        manager.addNewMovie("Film III");
        manager.addNewMovie("Film IV");
        manager.addNewMovie("Film V");

        String[] actual = manager.findLast();
        String[] expected = {"Film V", "Film IV", "Film III", "Film II", "Film I",};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test7FindLast() {

        MovieManager manager = new MovieManager(7);

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");
        manager.addNewMovie("Film III");
        manager.addNewMovie("Film IV");
        manager.addNewMovie("Film V");
        manager.addNewMovie("Film VI");

        String[] actual = manager.findLast();
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(actual, expected);
    }


    @Test
    public void test8ShouldAboveLimit() {

        MovieManager manager = new MovieManager(7);

        manager.addNewMovie("Film I");
        manager.addNewMovie("Film II");
        manager.addNewMovie("Film III");
        manager.addNewMovie("Film IV");
        manager.addNewMovie("Film V");
        manager.addNewMovie("Film VI");
        manager.addNewMovie("Film VII");
        manager.addNewMovie("Film VIII");

        String[] actual = manager.findLast();
        String[] expected = {"Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II"};
        Assertions.assertArrayEquals(actual, expected);
    }


}