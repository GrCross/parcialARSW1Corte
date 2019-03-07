package edu.eci.arsw.GuidFinderDesktop;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author carlo
 */
public class GuidFinderThread extends Thread {

    private int segmentoIni;
    private int segmentoFin;
    private UUID[] guids;
    private AtomicInteger count;
    private UUID guidToFind;

    public GuidFinderThread(int segmentoIni, int segmentoFin, UUID[] guids, UUID guidToFind, AtomicInteger count) {
        this.segmentoIni = segmentoIni;
        this.segmentoFin = segmentoFin;
        this.guids = guids;
        this.count = count;
        this.guidToFind = guidToFind;
    }

    @Override
    public void run() {
        for (int i = segmentoIni; i < segmentoFin; i++) {
            if (guids[i].equals(guidToFind)) {
                count.incrementAndGet();
            }
        }
    }

}
