package org.genesiscode.practicefour.controller;

import lombok.RequiredArgsConstructor;
import org.genesiscode.practicefour.dto.MixedResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeBinaryResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    @GetMapping("/mixed")
    private ResponseEntity<ResponseDTO<MixedResponseDTO>> mixed(
            @RequestParam Integer seed,
            @RequestParam(name = "multiplicative") Integer multiplicativeConstant,
            @RequestParam(name = "additive") Integer additiveConstant,
            @RequestParam Integer module) {
        return ResponseEntity.ok(mainService.mixed(seed, multiplicativeConstant, additiveConstant, module));
    }

    @GetMapping("/multiplicative")
    public ResponseEntity<ResponseDTO<MultiplicativeResponseDTO>> multiplicative(
            @RequestParam Integer seed,
            @RequestParam("multiplicative") Integer multiplicativeConstant,
            @RequestParam Integer module) {
        return ResponseEntity.ok(mainService.multiplicative(seed, multiplicativeConstant, module));
    }

    @GetMapping("/multiplicative/binary")
    public ResponseEntity<ResponseDTO<MultiplicativeBinaryResponseDTO>> multiplicativeBinary(
            @RequestParam Integer seed,
            @RequestParam("multiplicative") Integer multiplicativeConstant,
            @RequestParam Integer module) {
        return ResponseEntity.ok(mainService.multiplicativeBinary(seed, multiplicativeConstant, module));
    }
}
