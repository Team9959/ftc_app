package org.firstinspires.ftc.teamcode;

/*
 * Created by pinkenbu on 10/21/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/*
 * Created by pinkenbu on 10/21/2017.
 */

@TeleOp(name="MecanumCode", group="TeleOp")
//@Disabled
public class MecanumCode extends OpMode {

    //Declare and initialize variables and motors
    DcMotor TapeMeasure;
    DcMotor FrontLeft;
    DcMotor FrontRight;
    DcMotor BackLeft;
    DcMotor BackRight;
    Servo Angle;
    boolean lfbump = false;
    boolean rtbump = false;
    float pwr = 0;

    @Override
    public void init() {
        //Set motors
        TapeMeasure = hardwareMap.dcMotor.get("TP");
        FrontLeft = hardwareMap.dcMotor.get("F1");
        FrontRight = hardwareMap.dcMotor.get("F2");
        BackLeft = hardwareMap.dcMotor.get("B1");
        BackRight = hardwareMap.dcMotor.get("B2");
        Angle = hardwareMap.servo.get("servo1");

        BackRight.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        TapeMeasure.setDirection(DcMotor.Direction.REVERSE);
        //Show that program has been initialized on phone screen
        telemetry.addData("start", "in init()");

        //startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        //runtime.reset();
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
        //Set variables
        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float right2Y = gamepad2.right_stick_y;
        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        FrontLeft.setPower(v1);
        FrontRight.setPower(v2);
        BackLeft.setPower(v3);
        BackRight.setPower(v4);

        //Driving
        //Gamepad 1 controls driving, Gamepad 2 controls the tape measure
        // normally power/2 puts us in a somewhat linear range which is between 0 and 0.5
        // on the ramp we have to slow down, so right bumper will divide power by 4
        // if we need full power pushing the left bumper will give us the full range
        double divisor = 2.;

        //if (gamepad1.right_bumper) {
        //  divisor = 6.;
        //}
        //if (gamepad1.left_bumper) {
        divisor = 1.;
        //}
        //BackLeft.setPower(leftY / divisor);
        //FrontLeft.setPower(leftY / divisor);
        //BackRight.setPower(rightY / divisor);
        //FrontRight.setPower(rightY / divisor);
        //telemetry.addData("pwr left", ":  " + String.format("%.2f", leftY/divisor));
        //telemetry.addData("pwr right", ":  " + String.format("%.2f", rightY/divisor));
        //telemetry.addData("div ", ":  " + String.format("%.2f", divisor));

        // Set tape measure
        //telemetry.addData("TP: ", "TapeTics:  " + String.format("%03d", TapeMeasure.getCurrentPosition()));
        // protection against pulling the tape in and breaking the hook off
        //if (TapeMeasure.getCurrentPosition() >= 0 && right2Y > 0 && !gamepad2.y)
        //{
        //   right2Y = 0;
        //}
        //TapeMeasure.setPower(right2Y / 2);

        //When bumper is pushed, servo moves .1
        //Since this is executed multiple times, this code sets a boolean in the first pass
        // when the button is pushed. This prevents a further increase while
        // the button is pushed. So each button push will increase the pwr by 0.1
        //telemetry.addData("TPpwr", String.format("%f", right2Y));
        //if (gamepad2.left_bumper) {
        //  if (!lfbump) {
        //    lfbump = true;
        //  pwr += .1;
        //if (pwr > 1) {
        //  pwr = 1;
        ///}
        //Angle.setPosition(pwr);
        //}
        //}
        //else {
        //  lfbump = false;
        //}
        //if (gamepad2.right_bumper) {
        //  if (!rtbump) {
        //    rtbump = true;
        //  pwr -= .1;
        //if (pwr < 0) {
        //  pwr = 0;
        //}
        //   Angle.setPosition(pwr);
        //}
        //    }
        //  else {
        //    rtbump = false;
        //}
        //}
        //  @Override
        //  public void stop() {
        //    telemetry.addData("0 stop: ", "in stop");
    }

}
