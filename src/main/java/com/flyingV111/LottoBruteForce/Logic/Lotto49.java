package com.flyingV111.LottoBruteForce.Logic;

import com.flyingV111.LottoBruteForce.Models.LottoBruteForceSettings;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto49 {

    public Lotto49(int numberLength, int[] input, LottoBruteForceSettings setting) {
        lottoNumberLength = numberLength;
        inputNumbers = input;
        generatedNumbers = new int[numberLength];
        settings = setting;
    }

    public int lottoNumberLength;
    private final int[] generatedNumbers;
    private final int[] inputNumbers;
    private final Scanner scanner = new Scanner(System.in);
    private final LottoBruteForceSettings settings;

    public long runs = 0;
    public long rightNumbersInAllRuns = 0;

    public void randomNumberGenerator(int min, int max, int index) {
        double r = Math.random();
        int randomNum = (int) (r * (max - min)) + min;
        generatedNumbers[index] = randomNum;
//        System.out.println(Arrays.toString(generatedNumbers));
    }

    private int returnSameNumbers() {
        int rightNumbersInRun = 0;
        for (int i = 0; i < lottoNumberLength; i++) {
            if (inputNumbers[i] == generatedNumbers[i]) {
                rightNumbersInRun++;
            }
        }
        return rightNumbersInRun;
    }

    public void compareLottoNumbers() {
        System.out.println("\n");
        System.out.println("-----------------------------------");
        while (!Arrays.equals(inputNumbers, generatedNumbers)) {
            rightNumbersInAllRuns += returnSameNumbers();
            for (int i = 0; i < lottoNumberLength; i++) {
                if (i > lottoNumberLength - 2) {
                    randomNumberGenerator(settings.getSuperNumberMinRange(), settings.getSuperNumberMaxRange() + 1, i);
                } else {
                    randomNumberGenerator(settings.getMinRange(), settings.getMaxRange() + 1, i);
                }
            }
            runs++;
            System.out.println("\n");
            System.out.println(Arrays.toString(generatedNumbers));
            System.out.println(Arrays.toString(inputNumbers));
        }
        System.out.println("\n");
        System.out.println("-----------------------------------");
        System.out.printf("Runs: %s | RightNumbers: %s \n", runs, rightNumbersInAllRuns);
        System.out.println("Jackpot!!!!!");
    }
}
