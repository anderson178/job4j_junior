package ru.job4j.generic;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.02.2019
 */

public class UserStoreTest {

    private User uFirst = new User();
    private User uSecond = new User();
    private User uThird = new User();
    private String tempID = String.valueOf(System.currentTimeMillis() + (new Random().nextInt()));

    @Test
    public void whenAddStoreUserTest() {
        UserStore us = new UserStore(1);
        us.add(this.uFirst);
        assertThat(us.findByID(this.uFirst.getId()).getId(), is(this.uFirst.getId()));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddStoreUserTestException() {
        UserStore us = new UserStore(2);
        us.add(this.uFirst);
        us.add(this.uSecond);
        us.add(this.uThird);
    }

    @Test
    public void whenReplaceStoreUserTest() {
        UserStore us = new UserStore(1);
        us.add(this.uFirst);
        us.replace(this.uFirst.getId(), this.uSecond);
        assertThat(us.findByIndex(0), is(this.uSecond));
    }

    @Test
    public void whenReplaceStoreUserTestFalse() {
        UserStore us = new UserStore(1);
        us.add(this.uFirst);
        assertThat(us.replace(this.tempID, this.uSecond), is(false));
    }

    @Test
    public void whenDeleteStoreUserTest() {
        UserStore us = new UserStore(2);
        us.add(this.uFirst);
        us.add(this.uSecond);
        us.delete(this.uFirst.getId());
        assertThat(us.fillSize(), is(1));
        assertThat(us.findByIndex(0).getId(), is(this.uSecond.getId()));
    }

    @Test
    public void whenDeleteStoreUserTestFalse() {
        UserStore us = new UserStore(2);
        us.add(this.uFirst);
        us.add(this.uSecond);
        assertThat(us.delete(this.tempID), is(false));
    }

    @Test
    public void whenFindByIDStoreUserTest() {
        UserStore us = new UserStore(2);
        us.add(this.uFirst);
        us.add(this.uSecond);
        assertThat(us.findByID(this.uFirst.getId()), is(this.uFirst));
    }

    @Test
    public void whenFindByIDStoreUserTestNull() {
        UserStore us = new UserStore(2);
        us.add(this.uFirst);
        us.add(this.uSecond);
        assertThat(us.findByID(this.tempID), is(nullValue()));
    }
}
