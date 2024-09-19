package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.WasteGeneratedDTO;

@Data
public class WasteGeneratedForm {
    private Long loginId;
    private List<WasteGeneratedDTO> wasteGeneratedList;
}
