package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import javax.lang.model.type.NullType;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.02.2019
 */

public class RoleStoreTest {

    private Role rFirst = new Role();
    private Role rSecond = new Role();
    private Role rThird = new Role();
    private String tempID = String.valueOf(System.currentTimeMillis() + (new Random().nextInt()));

    @Test
    public void whenAddStoreRoleTest() {
        RoleStore rs = new RoleStore(1);
        rs.add(this.rFirst);
        assertThat(rs.findByID(this.rFirst.getId()).getId(), is(this.rFirst.getId()));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddStoreRoleTestException() {
        RoleStore rs = new RoleStore(2);
        rs.add(this.rFirst);
        rs.add(this.rSecond);
        rs.add(this.rThird);
    }

    @Test
    public void whenReplaceStoreRoleTest() {
        RoleStore rs = new RoleStore(1);
        rs.add(this.rFirst);
        rs.replace(this.rFirst.getId(), this.rSecond);
        assertThat(rs.findByIndex(0), is(this.rSecond));
    }

    @Test
    public void whenReplaceStoreRoleTestFalse() {
        RoleStore rs = new RoleStore(1);
        rs.add(this.rFirst);
        assertThat(rs.replace(this.tempID, this.rSecond), is(false));
    }

    @Test
    public void whenDeleteStoreRoleTest() {
        RoleStore rs = new RoleStore(2);
        rs.add(this.rFirst);
        rs.add(this.rSecond);
        rs.delete(this.rFirst.getId());
        assertThat(rs.fillSize(), is(1));
        assertThat(rs.findByIndex(0).getId(), is(this.rSecond.getId()));
    }

    @Test
    public void whenDeleteStoreRoleTestFalse() {
        RoleStore rs = new RoleStore(2);
        rs.add(this.rFirst);
        rs.add(this.rSecond);
        assertThat(rs.delete(this.tempID), is(false));
    }

    @Test
    public void whenFindByIDStoreRoleTest() {
        RoleStore rs = new RoleStore(2);
        rs.add(this.rFirst);
        rs.add(this.rSecond);
        assertThat(rs.findByID(this.rFirst.getId()), is(this.rFirst));
    }

    @Test
    public void whenFindByIDStoreRoleTestNull() {
        RoleStore rs = new RoleStore(2);
        rs.add(this.rFirst);
        rs.add(this.rSecond);
        assertThat(rs.findByID(this.tempID), is(nullValue()));
    }
}
