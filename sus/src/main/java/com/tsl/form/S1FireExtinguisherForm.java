package com.tsl.form;

import lombok.Data;
import java.util.List;

import com.tsl.dto.S1FireExtinguisherDTO;

@Data
public class S1FireExtinguisherForm {
    private Long loginId;
    private List<S1FireExtinguisherDTO> extinguishers;
}
