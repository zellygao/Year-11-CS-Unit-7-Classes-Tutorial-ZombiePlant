# Year-11-CS-Unit-6-Classes-Tutorial-ZombiePlant

Your job is to create one class called ZombiePlant. 
You should pass all of the tests in the ZombiePlantTester class (provided).

This question involves the implementation of a zombie plant treatment system that is represented by the ZombiePlant class. A ZombiePlant object is created with parameters that specify the maximum potency for a successful treatment and the initial number of successful treatments required to cure the plant.
The ZombiePlant class provides a constructor and the following methods.

* treatmentsNeeded, which returns the number of successful treatments required to cure the plant.
* isDangerous, which returns true if the plant requires treatment, false otherwise.
* treat, which administers a treatment with the specified potency.

The following table contains a sample code execution sequence and the corresponding results. 

| Statements and Expressions                  | Value Returned (blank if no value) | Comment                  |
| ------------------------------------------- | ---------------------------------- | ------------------------ |
| ZombiePlant plant = new ZombiePlant(10, 3); |                                    | The plant requires treatments with a potency <= 10. The plant initially needs 3 successful treatments to be cured.             |
| plant.treatmentsNeeded();                   | 3                                  | The plant has not yet been treated, so it still needs 3 treatments to be cured.             |
| plant.isDangerous();                        | true                               | The plant still needs at least 1 treatment to be cured, so it is dangerous.
| plant.treat(7);                             |                                    | The treatment potency is <= 10, so the treatment is successful
| plant.treatmentsNeeded();                   | 2                                  | The plant now needs 2 successful treatments to be cured.
| plant.treat(11);                            |                                    | The treatment potency is not <= 10, so the treatment is not successful.
| plant.treatmentsNeeded();                   | 3                                  | The failed treatment increased the number of successful treatments needed for the plant to be cured by 1.
| plant.treat(10);                            |                                    | The treatment potency is <= 10, so the treatment is successful.
| plant.treatmentsNeeded();                   | 2                                  | The plant now needs 2 successful treatments to be cured.
| plant.isDangerous();                        | true                               | The plant still needs at least 1 treatment to be cured, so it is dangerous. 
| plant.treat(8);                             |                                    | The treatment potency is <= 10, so the treatment is successful.
| plant.treat(4);                             |                                    | The treatment potency is <= 10, so the treatment is successful.
| plant.treatmentsNeeded();                   | 0                                  | The successful treatments reduced the number of treatments needed to 0.
| plant.isDangerous();                        | false                              | The plant has been cured. It is no longer dangerous. 
| plant.treat(4);                             |                                    | Additional treatments with a potency <= 10 have no effect.
| plant.treatmentsNeeded();                   | 0                                  | The additional treatment with a potency <= 10 had no effect.
| plant.isDangerous();                        | false                              | The plant remains cured.
