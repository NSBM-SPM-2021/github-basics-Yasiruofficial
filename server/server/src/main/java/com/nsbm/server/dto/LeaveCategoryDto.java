package com.nsbm.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveCategoryDto {

    private String id;
    private String dateTime;
    private String type;

}
