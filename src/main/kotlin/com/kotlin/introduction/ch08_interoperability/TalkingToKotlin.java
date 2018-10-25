package com.kotlin.introduction.ch08_interoperability;

import com.kotlin.introduction.ch03_classes.CustomerKotlin;
import com.kotlin.introduction.ch03_classes.CustomerKotlinKt;
import com.kotlin.introduction.ch03_classes.Status;

import java.io.IOException;

public class TalkingToKotlin {

    public void loadStats(CustomerKotlin customerKotlin) {
        try {
            customerKotlin.loadStatistics("filename");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomerKotlin customerKotlin = new CustomerKotlin(1, "Hadi", "null");
        customerKotlin.setId(1);

        String someProperty = customerKotlin.someField;

        customerKotlin.changeStates(Status.CURRENT);
        customerKotlin.changeStates();

        customerKotlin.preferential();

        // extension function from java
        CustomerKotlinKt.extension(customerKotlin);

        UtilityClass.prefix("some", "value");
        int copyrightYear = UtilityClass.CopyrightYear;
        UtilityClass.getCopyrightYear2();

    }
}
