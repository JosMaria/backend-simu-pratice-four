package org.genesiscode.practicefour.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"numberRow"})
@AllArgsConstructor
@Getter
@Setter
public class MultiplicativeResponseDTO {

    private int numberRow;
    private int valueOne;
    private int valueTwo;
    private int valueThree;
    private String valueFour;
}
