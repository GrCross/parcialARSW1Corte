/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinderAPI.Controllers;


import edu.eci.arsw.GuidFinderAPI.Model.Guid;
import edu.eci.arsw.GuidFinderAPI.Services.GuidFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2134840
 */
@RestController
@RequestMapping("/uuids")
@Service
public class GuidFinderAPIController {
    
    /*static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    GuidFinderService gfc = ac.getBean(GuidFinderService.class);*/
    @Autowired
    GuidFinderService gfc;
    
    //GuidFinderService gfc = new GuidFinderService();
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUuids(){
        try {
            System.out.println("edu.eci.arsw.Controllers.GuidFinderAPIController.getAllUuids()");
            //Object data = gfc.getGuids();
            
            return new ResponseEntity<>(gfc.getGuids(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("recursos no encontrados",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postUuid(@RequestBody Guid guid){
        try {
            
            gfc.addGuid(guid);
            
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("recursos no encontrados",HttpStatus.FORBIDDEN);
        }
    }
    
    
    
}
