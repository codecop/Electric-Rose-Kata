using ElectrictRoseBatteryTracker.Models;

namespace ElectrictRoseBatteryTracker;

public class ElectricRose
{
    private Battery[] batteries;

    public ElectricRose(Battery[] batteries)
    {
        this.batteries = batteries;
    }

    public void UpdateCharge()
    {
        foreach (var battery in batteries)
        {
            if (battery.Charge >= 0.1)
            {
                battery.Charge = Math.Max(0, battery.Charge - 0.01);
            }

            if (battery.Dry)
            {
                if (battery.Charge >= 0.1)
                {
                    battery.Charge = Math.Max(0, battery.Charge - 0.01);
                }
            }
        }
    }
}