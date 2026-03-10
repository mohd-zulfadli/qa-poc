package com.example.karate;

import com.intuit.karate.junit5.Karate;

// public class SampleKarateIT {
//     @Karate.Test
//     Karate testSample() {
//         return Karate.run("BasicAPIGet").relativeTo(getClass());
//     }
// }

public class SampleKarateIT {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
