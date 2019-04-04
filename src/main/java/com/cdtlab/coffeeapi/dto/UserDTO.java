package com.cdtlab.coffeeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDTO
 */
@Data
@NoArgsConstructor
public class UserDTO {

    private String name;
    private Integer remainingCoffee;
}