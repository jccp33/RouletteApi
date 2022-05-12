package com.ibm.academi.RouletteApi.rest;

import com.ibm.academi.RouletteApi.models.History;
import com.ibm.academi.RouletteApi.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/history")
public class HistoryRest {
    @Autowired
    private HistoryService historyService;

    @PostMapping("/save")
    private ResponseEntity<History> save(@RequestBody History history){
        History temp = historyService.create(history);
        try{
            return ResponseEntity.created(new URI("api/history/" + temp.getId())).body(temp);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<History>> getAll(){
        return ResponseEntity.ok(historyService.getAll());
    }

    @GetMapping("/getById/{id}")
    private String getById(@PathVariable("id") Long id){
        return historyService.getById(id).toString();
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Void> delete(@RequestBody History history){
        historyService.delete(history);
        return ResponseEntity.ok().build();
    }
}
