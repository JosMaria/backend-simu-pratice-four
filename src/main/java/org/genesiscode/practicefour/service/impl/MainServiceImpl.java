package org.genesiscode.practicefour.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.genesiscode.practicefour.dto.MultiplicativeBinaryResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.genesiscode.practicefour.util.Operations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    @Override
    public ResponseDTO<MultiplicativeResponseDTO> multiplicative(final Integer seed, final Integer multiplicativeConstant, final Integer module) {
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
        return new ResponseDTO<>(list, messagesMultiplicative(seed, module));
    }

    private List<String> messagesMultiplicative(int seed, int module) {
        List<String> messages = new ArrayList<>();
        messageOfDivisibleAndRelativelyPrimes(messages, seed, module);
        return messages;
    }

    @Override
    public ResponseDTO<MultiplicativeBinaryResponseDTO> multiplicativeBinary(Integer seed, Integer multiplicativeConstant, Integer module) {
        List<MultiplicativeBinaryResponseDTO> list = new ArrayList<>();
        int seedTemp = seed;
        boolean isFirstIteration = true, isRepeat = false;
        MultiplicativeBinaryResponseDTO firstRow = null;

        for (int i = 0; i <= module && !isRepeat; i++) {
            int valueTwo = seedTemp * multiplicativeConstant;
            int valueThree = valueTwo % module;
            MultiplicativeBinaryResponseDTO row = new MultiplicativeBinaryResponseDTO(i + 1, valueThree);
            if(isFirstIteration) {
                firstRow = row;
            } else {
                isRepeat = firstRow.equals(row);
            }
            isFirstIteration = false;
            list.add(row);
            seedTemp = valueThree;
        }

        log.info("multiplicative binary returns with successfully");
        return new ResponseDTO<>(list, messagesMultiplicativeBinary(seed, module));
    }

    private List<String> messagesMultiplicativeBinary(int seed, int module) {
        List<String> messages = new ArrayList<>();
        messageOfDivisibleAndRelativelyPrimes(messages, seed, module);
        return messages;
    }

    private void messageOfDivisibleAndRelativelyPrimes(List<String> messages, int seed, int module) {
        if (seed % 2 == 0 || seed % 5 == 0) {
            messages.add(String.format("Warning: La semilla %s es divisible entre 2 o 5", seed));
        }
        if (!Operations.areRelativelyPrime(seed, module)) {
            messages.add(String.format("Warning: La semilla %s no es relativamente primo al modulo: %s", seed, module));
        }
    }
}
