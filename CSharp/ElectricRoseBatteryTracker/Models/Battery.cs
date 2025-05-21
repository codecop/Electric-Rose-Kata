namespace ElectrictRoseBatteryTracker.Models;

public class Battery
{
    public string Type { get; init; }
    public bool Dry { get; set; }
    public double Charge { get; set; }

    public Battery(string type, bool dry, double charge)
    {
        Type = type;
        Dry = dry;
        Charge = charge;
    }
}