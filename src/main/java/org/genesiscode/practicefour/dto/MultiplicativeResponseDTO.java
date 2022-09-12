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

    public static void main(String[] args) {
        MultiplicativeResponseDTO row1 = new MultiplicativeResponseDTO(1, 10, 1, 1, "Jose Maria");
        MultiplicativeResponseDTO row2 = new MultiplicativeResponseDTO(100, 1, 1, 1, "Jose Maria");
        System.out.println(row1.equals(row2));
    }
}
