using ElectrictRoseBatteryTracker;
using ElectrictRoseBatteryTracker.Models;

namespace ElectricRoseNUnit;

public class Tests
{
    [Test]
    public void ShouldFoo()
    {
        Battery[] batteries = [new Battery("foo", false, 1)];
        var app = new ElectricRose(batteries);
        app.UpdateCharge();
        Assert.That(batteries[0].Type, Is.EqualTo("fixme"));
    }
}