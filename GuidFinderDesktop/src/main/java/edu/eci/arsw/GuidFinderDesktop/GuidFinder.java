package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuidFinder {

    private static UUID[] guids;

    public GuidFinder() throws Exception {
        getGuids();
    }

    public static UUID[] getGuids() throws Exception {

        if (guids == null) {
            System.out.println("es nulo");
            FileInputStream fi;

            fi = new FileInputStream(new File("guids.eci"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            guids = (UUID[]) oi.readObject();

            oi.close();
            fi.close();
        }
        return guids;

    }

    public int countGuids(UUID guidToFind) {
        
        int hilos = 4;
        
        GuidFinderThread[] threads = new GuidFinderThread[hilos];
        AtomicInteger count = new AtomicInteger(0);
        
        int cantGuids = guids.length;
        int segmento = cantGuids/hilos;
        int cuentaSegmento = 0;
        
        int i;
        for (i = 0; i < hilos-1; i++) {
            threads[i] = new GuidFinderThread(cuentaSegmento, cuentaSegmento+segmento, guids, guidToFind, count);
            cuentaSegmento += segmento;
        }
        threads[i] = new GuidFinderThread(cuentaSegmento, cantGuids, guids, guidToFind, count);
        
        for (GuidFinderThread guidT : threads) {
            guidT.start();
        }
        
        for (GuidFinderThread guidT : threads) {
            try {
                guidT.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuidFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return count.get();

    }

}
