package com.tsl.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormsDataDto {
    private List<Form1Dto> form1List;
    private List<Form2Dto> form2List;

    // You can add additional fields or methods if needed
}
