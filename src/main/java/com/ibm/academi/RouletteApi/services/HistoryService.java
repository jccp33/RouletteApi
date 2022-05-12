package com.ibm.academi.RouletteApi.services;

import com.ibm.academi.RouletteApi.models.History;
import com.ibm.academi.RouletteApi.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public History create(History history){
        return historyRepository.save(history);
    }

    public List<History> getAll(){
        return historyRepository.findAll();
    }

    public History getById(Long id){
        return historyRepository.getById(id);
    }

    public boolean delete(History history){
        try{
            historyRepository.delete(history);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
