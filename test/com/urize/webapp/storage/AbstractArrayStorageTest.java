package com.urize.webapp.storage;

import com.urize.webapp.exception.NotExistStorageException;
import com.urize.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AbstractArrayStorageTest {
    private final Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    Resume resume = new Resume(UUID_1);
    Resume r = new Resume(UUID_2);
    Resume r1 = new Resume(UUID_3);

    Resume[] resumes = new Resume[]{resume, r, r1};

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume);

        storage.save(r);

        storage.save(r1);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] expected = storage.getAll();
        Resume[] actual = resumes;
        assertEquals(expected, actual);
    }

    @Test
    public void save() {
        storage.save(new Resume("uuid4"));
        assertEquals(4, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Resume resume = new Resume("uuid1");
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

//    @Test
//    public void whenAdded100ElementsThenSizeMustBe100() {
//        assertEquals(100, carList.size());
//    }

//    @Test
//    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
//        assertTrue(carList.removeAt(5));
//        assertEquals(99, carList.size());
//    }
//
//    @Test
//    public void whenElementRemovedThenSizeMustBeDecreased() {
//        Car car = new Car("Toyota", 15);
//        carList.add(car);
//        assertEquals(101, carList.size());
//        assertTrue(carList.remove(car));
//        assertEquals(100, carList.size());
//    }
//
//    @Test
//    public void whenNonExistentElementRemovedThenReturnFalse() {
//        Car car = new Car("Toyota", 15);
//        assertFalse(carList.remove(car));
//        assertEquals(100, carList.size());
//    }
//
//    @Test
//    public void whenListClearedThenSizeMustBe0() {
//        carList.clear();
//        assertEquals(0, carList.size());
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void whenIndexOutOfBoundsThenThrownException() {
//        carList.get(100);
//    }
//
//    @Test
//    public void methodGetReturnedRightValue() {
//        Car car = carList.get(0);
//        assertEquals("Brand0", car.getBrand());
//    }
}