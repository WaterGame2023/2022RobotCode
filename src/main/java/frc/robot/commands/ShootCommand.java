package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShootSubsystem;

public class ShootCommand extends CommandBase {
  private ShootSubsystem shootSubsystem;
  private double targetShooterPosition = 0;

  public ShootCommand(ShootSubsystem shootSubsystem) {
    this.shootSubsystem = shootSubsystem;
    addRequirements(shootSubsystem);

    SmartDashboard.putNumber("Intake Target RPM", 0);
    SmartDashboard.putNumber("Revwheel Target RPM", 0);
  }
  
  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    // targetShooterPosition += RobotContainer.gamepad.getY() / 50;
    // shootSubsystem.setTurretPosition(targetShooterPosition);

    shootSubsystem.setIntakeRPM(SmartDashboard.getNumber("Intake Target RPM", 0));
    shootSubsystem.setRevwheelRPM(SmartDashboard.getNumber("Revwheel Target RPM", 0));
  }

  @Override
  public void end(boolean interrupted) {
    shootSubsystem.stopEverything();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}