package com.example.karate;

import com.intuit.karate.junit5.Karate;

public class SampleKarateIT {
    @Karate.Test
    Karate testSample() {
        return Karate.run("karateSample").relativeTo(getClass());
    }
}
