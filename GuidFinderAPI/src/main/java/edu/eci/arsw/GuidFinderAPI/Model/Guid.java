/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinderAPI.Model;

import edu.eci.arsw.GuidFinderDesktop.GuidFinder;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2134840
 */
public class Guid {
    private String date;
    private String UUIDS;
    private int count;
    public Guid(String UUIDS) {
        this.date = new Date().toString();
        this.UUIDS = UUIDS;
        this.count = findUUID(UUIDS);
        
    }
    
    public int findUUID(String UUIDString){
        try {
            GuidFinder gf = new GuidFinder();
            int count = gf.countGuids(UUID.fromString(UUIDString));
            
        } catch (Exception ex) {
            Logger.getLogger(Guid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }    

    public String getDate() {
        return date;
    }

    public String getUUIDS() {
        return UUIDS;
    }

    public int getCount() {
        return count;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUUIDS(String UUIDS) {
        this.UUIDS = UUIDS;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    
    
}
