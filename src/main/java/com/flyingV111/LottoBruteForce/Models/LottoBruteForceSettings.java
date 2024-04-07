package com.flyingV111.LottoBruteForce.Models;

import lombok.Data;

@Data
public class LottoBruteForceSettings {
    private int lottoNumberLength;
    private int [] inputNumbers;
    private int minRange;
    private int maxRange;
    private int superNumberMinRange;
    private int superNumberMaxRange;
}
