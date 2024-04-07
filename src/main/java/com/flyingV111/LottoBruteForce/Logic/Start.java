package com.flyingV111.LottoBruteForce.Logic;

import com.flyingV111.LottoBruteForce.Models.LottoBruteForceResponse;
import com.flyingV111.LottoBruteForce.Models.LottoBruteForceSettings;

import java.time.LocalDateTime;

public class Start {
    public static LottoBruteForceResponse StartBruteForce(LottoBruteForceSettings settings) {
        Lotto49 lotto49 = new Lotto49(settings.getLottoNumberLength(), settings.getInputNumbers(), settings);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < lotto49.lottoNumberLength; i++) {
            if (i > lotto49.lottoNumberLength - 2) {
                lotto49.randomNumberGenerator(settings.getSuperNumberMinRange(), settings.getSuperNumberMaxRange() + 1, i);
            } else {
                lotto49.randomNumberGenerator(settings.getMinRange(), settings.getMaxRange() + 1, i);
            }
        }

        lotto49.compareLottoNumbers();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        long seconds = duration / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        hours %= 24;
        minutes %= 60;
        seconds %= 60;

        LottoBruteForceResponse lottoBruteForceResponse = new LottoBruteForceResponse();
        lottoBruteForceResponse.setDays(days);
        lottoBruteForceResponse.setHours(hours);
        lottoBruteForceResponse.setMinutes(minutes);
        lottoBruteForceResponse.setSeconds(seconds);
        lottoBruteForceResponse.setRightNumbers(lotto49.rightNumbersInAllRuns);
        lottoBruteForceResponse.setRuns(lotto49.runs);


        return (lottoBruteForceResponse);
    }
}
