package com.flyingV111.LottoBruteForce.Controller;

import com.flyingV111.LottoBruteForce.Logic.Lotto49;
import com.flyingV111.LottoBruteForce.Logic.Start;
import com.flyingV111.LottoBruteForce.Models.LottoBruteForceResponse;
import com.flyingV111.LottoBruteForce.Models.LottoBruteForceSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LottoBruteForceController {
    @PostMapping("/startAgain")
    public ResponseEntity<LottoBruteForceResponse> start(@RequestBody LottoBruteForceSettings settings) {
        if (!isValidInputNumbers(settings.getInputNumbers(), settings.getMinRange(), settings.getMaxRange(), settings.getSuperNumberMinRange(), settings.getSuperNumberMaxRange())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(Start.StartBruteForce(settings));
    }

    private boolean isValidInputNumbers(int[] inputNumbers, int minRange, int maxRange, int lastNumberMinRange, int lastNumberMaxRange) {
        for (int i = 0; i < inputNumbers.length; i++) {
            int num = inputNumbers[i];
            if (i == inputNumbers.length - 1) {
                if (num < lastNumberMinRange || num > lastNumberMaxRange) {
                    return false;
                }
            } else {
                if (num < minRange || num > maxRange) {
                    return false;
                }
            }
        }
        return true;
    }

}
