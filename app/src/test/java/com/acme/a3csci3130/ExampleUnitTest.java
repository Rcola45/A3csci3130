package com.acme.a3csci3130;

import org.junit.Test;
import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validation_isCorrect() throws Exception {
        FirebaseDatabase firebaseDBInstance = FirebaseDatabase.getInstance();
        DatabaseReference  firebaseReference = firebaseDBInstance.getReference("businesses");

        String businessID = firebaseReference.push().getKey();
        String name = "ValidName";


    }
}