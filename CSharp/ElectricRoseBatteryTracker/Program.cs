
using ElectrictRoseBatteryTracker;
using ElectrictRoseBatteryTracker.Models;

Console.WriteLine("BZZ ZZZ!");

Battery[] batteries = [
    new Battery("Samsung Lithium-ion", false, 20),
    new Battery("Budget Nickel Cadmium", true, 7),
];

var app = new ElectricRose(batteries);

var times = 2;

if (args.Length > 0)
{
    times = int.Parse(args[0]);   
}

for (var t = 0; t < times; t++)
{
    Console.WriteLine("-------- usage " + t + " --------");
    Console.WriteLine("type, dry, charge");
    foreach (var battery in batteries)
    {
        Console.WriteLine(battery.Type + ", " + battery.Dry + ", " + battery.Charge);
    }
    Console.WriteLine();
    app.UpdateCharge();
}