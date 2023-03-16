package org.firstinspires.ftc.teamcode;

import android.os.Environment;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.configuration.DeviceConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GetRobotConfig extends LinearOpMode {

    @Override
    public void runOpMode() {

        // Initialize hardware map

        // Get the list of configured devices
        List<DeviceConfiguration> devices = hardwareMap.getAll(DeviceConfiguration.class);

        // Create a new file on the SD card
        File file = new File(Environment.getExternalStorageDirectory(), "robot_config.txt");

        try {
            // Create a FileWriter object to write to the file
            FileWriter writer = new FileWriter(file);

            // Write the port and device name for each device to the file
            for (DeviceConfiguration device : devices) {
                String line = "Port" + device.getPort() + ": " + device.getName() + "\n";
                writer.write(line);
                telemetry.addData("Port"+device.getPort()+": ",device.getName());
            }

            writer.close(); // Close the FileWriter object to save the changes

        } catch (IOException e) {
            e.printStackTrace();
        }

        telemetry.update();

        // Wait for start button to be pressed
        waitForStart();

        // Your code here

    }

}
