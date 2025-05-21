using ElectrictRoseBatteryTracker;
using ElectrictRoseBatteryTracker.Models;

namespace ElectricRoseXUnit;

public class Tests
{
    [Fact]
    public void ShouldFoo()
    {
        Battery[] batteries = [new("foo", false, 1)];
        var app = new ElectricRose(batteries);
        app.UpdateCharge();
        Assert.Equal("fixme", batteries[0].Type);
    }
}