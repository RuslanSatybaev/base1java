package com.urize.webapp.storage;

import com.urize.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size >= storage.length) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        int index = returnIndexByUuid(uuid);
        return storage[index];
    }

    public void delete(String uuid) {
        int indexDelete = returnIndexByUuid(uuid);
        if (size - 1 - indexDelete >= 0)
            System.arraycopy(storage, indexDelete + 1, storage, indexDelete, size - 1 - indexDelete);
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int returnIndexByUuid(String uuid) {
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
