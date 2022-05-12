package com.ibm.academi.RouletteApi.services;

import com.ibm.academi.RouletteApi.models.History;

import java.util.Date;
import java.util.Random;

public class RouletteService {
    static final int SQUARES = 36;
    private int[] rouletteNumbers;
    private int[] rouletteColors;

    public RouletteService() {
        this.rouletteNumbers = new int[SQUARES+1];
        this.rouletteColors = new int[SQUARES+1];
        for(int i=0; i<=SQUARES; i++){
            this.rouletteNumbers[i] = i;
            if(i%2 == 0){
                this.rouletteColors[i] = 0;
            }else{
                this.rouletteColors[i] = 1;
            }
        }
    }

    private int spinRoulette(){
        Random random = new Random();
        return random.nextInt(SQUARES);
    }

    /**
     * MENU
     * 1) Zero (0)          x15
     * 2) Specific number   x15";
     * 3) 1 - 12            x10";
     * 4) 13 - 24           x10";
     * 5) 25 - 36           x10";
     * 6) Red               x5";
     * 7) Black             x5";
     * 8) Pair              x5";
     * 9) Odd               x5";
     */
    public History playRoulette(int amount, int option, int number){
        int reward = 0;
        String message = "";
        int random = spinRoulette();

        if(option<1 || option>9) {
            reward = 0;
            message = "Invalid Option";
        }else if(option==1 && random==0){
            reward = amount * 15;
            message = "Roulette: " + random + ", Your number: 0";
        }else if(option==2 && random==number){
            reward = amount * 15;
            message = "Roulette: " + random + ", Your number: " + number;
        }else if(option==3 && (random>=1 && random<=12)){
            reward = amount * 10;
            message = "Roulette: " + random + " [1 - 12]";
        }else if(option==4 && (random>=13 && random<=24)){
            reward = amount * 10;
            message = "Roulette: " + random + " [13 - 24]";
        }else if(option==5 && (random>=25 && random<=36)){
            reward = amount * 10;
            message = "Roulette: " + random + " [25 - 36]";
        }else if(option==6 && random!=0 && this.rouletteColors[random]==1){
            reward = amount * 5;
            message = "Roulette: " + random + " [Red]";
        }else if(option==7 && random!=0 && this.rouletteColors[random]==0){
            reward = amount * 5;
            message = "Roulette: " + random + " [Black]";
        }else if(option==8 && random!=0 && random%2==0){
            reward = amount * 5;
            message = "Roulette: " + random + " [Pair]";
        }else if(option==9 && random!=0 && random%2!=0){
            reward = amount * 5;
            message = "Roulette: " + random + " [Odd]";
        }else{
            reward = 0;
            message = "Roulette: " + random + ", Your option: " + option + ", Your number: " + number;
        }

        History history = new History();
        history.setAmount(amount);
        history.setOption(option);
        history.setNumber(number);
        history.setResult(random);
        history.setReward(reward);
        history.setMessage(message);
        history.setCreatedDate(new Date());
        history.setCreatedBy("SYSTEM");

        return history;
    }
}
