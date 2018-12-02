package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name= "BasicAutoOpMode2", group= "Lovelace")
public class BasicAutoOpMode2 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    static final double FORWARD_SPEED = 0.5;

    @Override
    public void runOpMode() {

        leftDrive = hardwareMap.get(DcMotor.class, "LeftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "RightDrive");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status:","Ready to run");
        telemetry.update();

        waitForStart();
        // Step 5:  Drive forward for 5 seconds
        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);


    }
}
