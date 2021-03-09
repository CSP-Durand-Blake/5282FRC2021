
package org.usfirst.frc5282.Robot2019b;                     

import org.usfirst.frc5282.Robot2019b.subsystems.*;         

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5282.Robot2019b.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


//import edu.wpi.first.cameraserver.CameraServer; USB Camera (on roboRio?)

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

 
import edu.wpi.first.networktables.NetworkTable;            //!! Limelight
import edu.wpi.first.networktables.NetworkTableEntry;       //!! Limelight
import edu.wpi.first.networktables.NetworkTableInstance;    //!! Limelight




public class Robot extends TimedRobot {

    public static DriveTrain driveTrain;
    public static LimeLight limeLight;
    public static Intake intake;
    public static Barrel barrel;
    public static Winch winch;
    public static Fire fire;
    public static Rotator rotator;
    public static IntakeSlider intakeSlider;
    
    
    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

   

    



    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    
    
        
        
        //NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        //NetworkTableEntry tx = table.getEntry("tx");
        //NetworkTableEntry ty = table.getEntry("ty");
        //NetworkTableEntry ta = table.getEntry("ta");
        //NetworkTableEntry tv = table.getEntry("tv");
        //NetworkTableEntry tstream = table.getEntry("stream");
      

        

        //CameraServer.getInstance().startAutomaticCapture();    // Start capturing and start sending to SmartDashboard
        

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        driveTrain = new DriveTrain();
        intake = new Intake();
        oi = new OI();
        limeLight = new LimeLight();
        barrel = new Barrel(); 
        intakeSlider = new IntakeSlider();
        rotator = new Rotator();
        winch = new Winch();
        fire = new Fire();
        
        // Add commands to Autonomous Sendable Chooser
        
       // chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());
        
        // SmartDashboard
        

        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData(driveTrain);     
    
        

    }

    
     @Override
    public void disabledInit(){

    }

    
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() {
        
        autonomousCommand = chooser.getSelected();
        //if (autonomousCommand != null) autonomousCommand.start();  // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.cancel();   // don't run the command called "AtonomousCommand"
      //new AutoInFront().start();
       //new AutoCurved().start();
      // new AutonRight().start();
     //  new AutoFeed().start();
     new GalacticSearch().start();
        
    }

    
    @Override
    public void autonomousPeriodic() {
      
        Scheduler.getInstance().run();
        
    }


    @Override
    public void teleopInit() {
        

        if (autonomousCommand != null) autonomousCommand.cancel();  



    }

    
    @Override
    public void teleopPeriodic() {
        
        Scheduler.getInstance().run();
    
    }

	
}
