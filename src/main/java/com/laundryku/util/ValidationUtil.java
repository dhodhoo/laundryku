package com.laundryku.util;

import java.math.BigDecimal;

// Utility untuk validasi input dari form
public final class ValidationUtil {
    private ValidationUtil() {
    }

    // Cek apakah string kosong atau null
    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Parse string ke BigDecimal, lempar exception dengan pesan field name
    public static BigDecimal parseDecimal(String value, String fieldName) {
        try {
            return new BigDecimal(value.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException(fieldName + " harus berupa angka valid.");
        }
    }

    // Parse string ke Integer, lempar exception dengan pesan field name
    public static int parseInteger(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException(fieldName + " harus berupa bilangan bulat valid.");
        }
    }
}
