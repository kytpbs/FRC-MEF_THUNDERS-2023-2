package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class DiyEncoder {
    public DigitalInput sensor1;
    public DigitalInput sensor2;
    public Timer timer = new Timer();
    public double rotationPeriod;
    public int direction;
    public int partitions;
    private boolean wasOn = false;

    public DiyEncoder(int sens1, int sens2, int parts){
        sensor1 = new DigitalInput(sens1);
        sensor2 = new DigitalInput(sens2);
        partitions = parts;
    }

    public void poll(){
        if (wasOn) {
            if (sensor1.get() == false){
                wasOn = false;
            }
        } else {
                if (sensor1.get()){
                    wasOn = true;
                    rotationPeriod = timer.get() / partitions;
                    timer.reset();
                }
            }
        if (sensor1.get()){
            Boolean sensor2Val = sensor2.get();
            if (sensor2Val) direction = 1;
            else direction = -1;
        }
    }

    public double getRPM(){
        return 60 / rotationPeriod;
    }
}
