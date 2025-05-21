using ElectrictRoseBatteryTracker;
using ElectrictRoseBatteryTracker.Models;

namespace ElectricRoseMSTest;

[TestClass]
public sealed class Tests
{
    [TestMethod]
    public void ShouldFoo()
    {
        Battery[] batteries = [new("foo", false, 1)];
        var app = new ElectricRose(batteries);
        app.UpdateCharge();
        Assert.AreEqual("fixme", batteries[0].Type);
    }
}