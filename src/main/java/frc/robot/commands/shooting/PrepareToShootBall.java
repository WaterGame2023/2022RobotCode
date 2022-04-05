package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.StorageSubsystem;

public class PrepareToShootBall extends CommandBase {
  private StorageSubsystem storageSubsystem;

  public PrepareToShootBall(StorageSubsystem storageSubsystem) {
    addRequirements(storageSubsystem);
    this.storageSubsystem = storageSubsystem;
  }

  @Override
  public void execute() {
    if (storageSubsystem.isBallBeforeShooter()) {
      storageSubsystem.stopBeforeShooter();
    } else {
      storageSubsystem.setBeforeShooterPower(0.13);
    }
  }

  @Override
  public void end(boolean interrupted) {
    storageSubsystem.stopBeforeShooter();
  }
}
