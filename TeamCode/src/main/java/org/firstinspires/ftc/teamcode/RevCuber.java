package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.Range;

/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="RevCuber", group="The Cube")
@Disabled
public class RevCuber extends OpMode{

    /* Declare OpMode members. */
    DcMotor front,left,right,back;
    Servo frontC,leftC,rightC,backC;

    double frontClaw,leftClaw,rightClaw,backClaw;

    boolean frontClosed,frontOpen;
    boolean backClosed, backOpen;
    boolean rightClosed,rightOpen;
    boolean leftClosed,leftOpen;//closed 0, open 1

                                                         // could also use HardwarePushbotMatrix class.



    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */

        front = hardwareMap.dcMotor.get("front");
        back = hardwareMap.dcMotor.get("back");
        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");

        frontC=hardwareMap.servo.get("frontC");
        rightC=hardwareMap.servo.get("rightC");
        backC=hardwareMap.servo.get("backC");
        leftC=hardwareMap.servo.get("leftC");

        frontClaw = 0.0;
        backClaw = 0.0;
        rightClaw = 0.0;
        leftClaw = 0.0;

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //

        frontClosed=false;
        frontOpen=true;
        backClosed=false;
        backOpen=true;
        rightClosed=false;
        rightOpen=true;
        leftClosed=false;
        leftClosed=true;
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        if(gamepad1.y){
            if(backClosed=true){
                backClaw=1.0;
                backClosed=false;
                backOpen= true;

            }
            else{
                backClaw=0.0;
                backClosed=true;
                backOpen=false;
            }
        }
        if(gamepad1.a){
            if(frontClosed=true){
                frontClaw=1.0;
                frontClosed=false;
                frontOpen= true;

            }
            else{
                frontClaw=0.0;
                frontClosed=true;
                frontOpen=false;
            }
        }
        if(gamepad1.x){
            if(leftClosed=true){
                leftClaw=1.0;
                leftClosed=false;
                leftOpen= true;

            }
            else{
                leftClaw=0.0;
                leftClosed=true;
                leftOpen=false;
            }
        }
        if(gamepad1.b) {
            if (rightClosed = true) {
                rightClaw = 1.0;
                rightClosed = false;
                rightOpen = true;

            } else {
                rightClaw = 0.0;
                rightClosed = true;
                rightOpen = false;
            }

        }

        front.setPower(gamepad1.left_stick_y);
        left.setPower(gamepad1.left_stick_x);

        back.setPower(gamepad1.right_stick_y);
        back.setPower(gamepad1.right_stick_x);

        frontC.setPosition(frontClaw);
        leftC.setPosition(leftClaw);
        rightC.setPosition(rightClaw);
        backC.setPosition(backClaw);





    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {





    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
