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
    public void validation_isCorrect() throws Exception {
        String businessID = "unique123key";
        String name = "ValidName";

        int businessNumber = 123456789;
        String primaryBusiness = "Fisher";
        String address = "123 Main St";
        String province = "QC";

        Business business = new Business(businessID, name, businessNumber, primaryBusiness, address, province);

        assertNotNull(business);
        assertEquals(business.name, "ValidName");

    }
}