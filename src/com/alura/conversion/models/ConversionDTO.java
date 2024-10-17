package com.alura.conversion.models;

public record ConversionDTO(String base_code,
                            String target_code,
                            double conversion_result,
                            Double amount,
                            String created_at) {}
