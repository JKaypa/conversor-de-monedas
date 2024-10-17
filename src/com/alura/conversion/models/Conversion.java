package com.alura.conversion.models;

import java.time.Instant;
import java.time.LocalDateTime;

public class Conversion {
    double amount;
    String base_code;
    String target_code;
    double conversion_result;
    String created_at;

    public Conversion (ConversionDTO dto, Double amount) {
        if (dto.amount() == null) this.amount = amount;
        else this.amount = dto.amount();

        this.base_code = dto.base_code();
        this.target_code = dto.target_code();
        this.conversion_result = dto.conversion_result();

        if (dto.created_at() == null) created_at = String.valueOf(LocalDateTime.now());
        else this.created_at = dto.created_at();
    }

    @Override
    public String toString() {
        return amount + " " + base_code + " are " + conversion_result + " " + target_code + " created at: " + created_at + "\n";
    }

    public String getResult() {
        return amount + " " + base_code + " are " + conversion_result + " " + target_code;
    }
}
