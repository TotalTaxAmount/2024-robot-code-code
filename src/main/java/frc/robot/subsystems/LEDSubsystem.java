package frc.robot.subsystems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    private Spark BlinkinDriver = new Spark(9);
    private  DoublePublisher LED_NT = NetworkTableInstance.getDefault().getTable("LEDs").getDoubleTopic("LEDValue").publish();
    @Override
    public void periodic() {
        super.periodic();
        LED_NT.set(BlinkinDriver.get());
    }

    /**
     * Set led color
     * @param value Color to set between -1 and 1 (no clue what is what)
     */
    public void setLED(double value) {
        BlinkinDriver.set(value);
    }
}
