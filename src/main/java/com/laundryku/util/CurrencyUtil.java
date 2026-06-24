package com.laundryku.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

// Utility untuk format mata uang Rupiah
public final class CurrencyUtil {
    private CurrencyUtil() {
    }

    // Ubah BigDecimal ke format Rupiah, contoh: Rp10.000,00
    public static String rupiah(BigDecimal value) {
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return format.format(value);
    }
}
