package com.example.karate;

import com.intuit.karate.junit5.Karate;

public class SimpleKarateIT {
    @Karate.Test
    Karate testSimple() {
        return Karate.run("simple").relativeTo(getClass());
    }
}
