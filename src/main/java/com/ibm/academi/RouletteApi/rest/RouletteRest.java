package com.ibm.academi.RouletteApi.rest;

import com.ibm.academi.RouletteApi.models.History;
import com.ibm.academi.RouletteApi.services.HistoryService;
import com.ibm.academi.RouletteApi.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/roulette")
public class RouletteRest {
    @Autowired
    private HistoryService historyService;

    RouletteService roulette;

    @GetMapping("/create")
    public String createRoulette(){
        try{
            roulette = new RouletteService();
            return "{'response':1, 'message':'created'}";
        }catch (Exception exc){
            String message = exc.getMessage().replace("\"", "");
            return "{'response':0, 'message':'" + message + "'}";
        }
    }

    // play?option=4&number=15&amount=250
    @GetMapping("/play")
    public String playRoulette(@RequestParam Integer option, @RequestParam Integer number, @RequestParam Integer amount){
        try{
            History temp = roulette.playRoulette(amount, option, number);
            historyService.create(temp);
            return temp.toString();
        }catch (Exception exc){
            String message = exc.getMessage().replace("\"", "");
            return "{'response':0, 'message':'" + message + "'}";
        }
    }

    @GetMapping("/close")
    public String close(){
        try{
            roulette = null;
            return "{'response':1, 'message':'eliminated'}";
        }catch (Exception exc){
            String message = exc.getMessage().replace("\"", "");
            return "{'response':0, 'message':'" + message + "'}";
        }
    }
}
