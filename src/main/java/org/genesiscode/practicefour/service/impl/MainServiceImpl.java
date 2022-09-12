package org.genesiscode.practicefour.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    @Override
    public ResponseDTO<MultiplicativeResponseDTO> multiplicative(final Integer seed, final Integer multiplicativeConstant, Integer module) {
        List<MultiplicativeResponseDTO> list = new ArrayList<>();
        int seedTemp = seed;
        boolean isFirstIteration = true, isRepeat = false;
        MultiplicativeResponseDTO firstRow = null;

        for (int i = 0; i <= module && !isRepeat; i++) {
            int valueTwo = seedTemp * multiplicativeConstant;
            int valueThree = valueTwo % module;
            String valueFour = valueThree == 0 ? String.valueOf(valueThree) : String.format("%s/%s", valueThree, module);
            MultiplicativeResponseDTO row = new MultiplicativeResponseDTO(i + 1, seedTemp, valueTwo, valueThree, valueFour);
            if(isFirstIteration) {
                firstRow = row;
            } else {
                isRepeat = firstRow.equals(row);
            }
            isFirstIteration = false;
            list.add(row);
            seedTemp = valueThree;
        }
        log.info("multiplicative returns with successfully");
        return new ResponseDTO<>(list, messagesMultiplicative());
    }

    private List<String> messagesMultiplicative() {
        return new ArrayList<>();
    }
}
