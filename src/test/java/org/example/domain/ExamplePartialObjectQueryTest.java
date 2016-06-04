package org.example.domain;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import org.example.ExampleBaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExamplePartialObjectQueryTest extends ExampleBaseTestCase {

    @Autowired
    EbeanServer server;

    @Test
    public void test() {

        Customer customer =
                Customer.find.select("name, email")
                        .where().idEq(12)
                        .findUnique();
    }

    @Test
    public void automaticallyAddJoins() {

        Country country = Ebean.getReference(Country.class, "NZ");
        Customer customer =
                Customer.find
                        .select("name")
                        .where().eq("billingAddress.country", country)
                        .findUnique();


    }
}
