package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.MerchantData;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    private static final String FILE_PATH =
            System.getProperty("user.dir") +
            "/test-data/merchantData.json";

    public static void writeMerchantData(
            MerchantData merchantData
    ) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            new File(FILE_PATH),
                            merchantData
                    );

            System.out.println(
                    "Merchant data saved to JSON"
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to write merchant JSON",
                    e
            );
        }
    }


    public static MerchantData readMerchantData() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            return mapper.readValue(
                    new File(FILE_PATH),
                    MerchantData.class
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to read merchant JSON",
                    e
            );
        }
    }
}