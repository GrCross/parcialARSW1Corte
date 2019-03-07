/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinderAPI.Services;


import edu.eci.arsw.GuidFinderAPI.Model.Guid;
import java.util.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2134840
 */

@Service
public class GuidFinderService {
    
    private List<Guid> guids = new ArrayList<>();
    
    public GuidFinderService() {
        
    }
    
    
    public void addGuid(Guid guid){
        
        guids.add(guid);
        
    }

    public List<Guid> getGuids() {
        return guids;
    }
    
    
    
    
}
