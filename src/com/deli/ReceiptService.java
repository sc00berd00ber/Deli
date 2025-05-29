package com.deli;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class ReceiptService {
    public static void saveReceipt(Order order) {
        String timestamp = order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String filename = "receipts/" + timestamp + ".txt";

        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()) {
            receiptsDir.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(order.generateReceipt());
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }
}
