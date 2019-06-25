package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static edu.iis.mto.multithread.RepeatRule.*;
import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private static PatriotBattery batteryMock;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 1000)
    public void patriotsShouldBeLaunched5Times() {
        batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock,5, new ExecutorImplementation("sameThread"));
        betterRadar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();
    }
}
