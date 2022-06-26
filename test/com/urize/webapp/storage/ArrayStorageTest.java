package com.urize.webapp.storage;

import com.urize.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStorageTest extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}