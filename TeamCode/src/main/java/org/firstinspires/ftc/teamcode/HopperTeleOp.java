package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Hopper TeleOp", group="Hopper")
public class HopperTeleOp extends OpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor linearSlideDrive;
    private DcMotor collectorDrive;
    private Servo boxDrive;

    private double linearSlidePowerUp = .7;
    private double linearSlidePowerDown = -.7;
    private double collectorOut = -1;
    private double collectorIn = 1;
    private double boxDriveUp = 1;
    private double boxDriveDown = 0;


    @Override
    public void init(){
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        linearSlideDrive = hardwareMap.get(DcMotor.class, "linearSlide");
        collectorDrive = hardwareMap.get(DcMotor.class, "collector");
        boxDrive = hardwareMap.get(Servo.class, "box");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    @Override
    public void loop() {
        double leftPower = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        //This sets the collectorIn using the right trigger
        // on the controller and the collectorOut using the right bumber
        if (gamepad2.right_trigger > 0){
            collectorDrive.setPower(collectorIn);
        } else if (gamepad2.right_bumper){
            collectorDrive.setPower(collectorOut);
        } else {
            collectorDrive.setPower(0);
        }

        //This sets the linear slideUp to the dpad up button
        // and the linear slideDown to the dpad down button
        if (gamepad2.dpad_up) {
            linearSlideDrive.setPower(linearSlidePowerUp);
        } else if (gamepad2.dpad_down) {
            linearSlideDrive.setPower(linearSlidePowerDown);
        } else {
            linearSlideDrive.setPower(0);
        }

        // TODO: add an if else statement to set the servo to a button on gamepad2
        if (gamepad2.left_trigger > 0) {
            boxDrive.setPosition(boxDriveDown);
        } else if (gamepad2.left_bumper) {
            boxDrive.setPosition(boxDriveUp);
        }



        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
        telemetry.update();
    }
}
