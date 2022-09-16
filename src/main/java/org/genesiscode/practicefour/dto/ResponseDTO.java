package org.genesiscode.practicefour.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> {

    private List<T> response;
    private List<String> messages;
}
