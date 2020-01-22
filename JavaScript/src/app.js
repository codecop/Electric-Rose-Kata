var rose = require('./electric_rose.js');

(function() {
    console.log("BZZ ZZZ!");

    var batteries = [
        new rose.Battery("Samsung Lithium-ion", false, 20), //
        new rose.Battery("Budget Nickel Cadmium", true, 7),
    ];

    var app = new rose.ElectricRose(batteries);

    var times = 2;
    if (process.argv.length > 2) {
        times = parseInt(process.argv[2]) + 1;
    }

    for (var t = 0; t < times; t++) {
        console.log("-------- usage " + t + " --------");
        console.log("type, dry, charge");
        for (var i = 0; i < batteries.length; i++) {
            console.log(batteries[i].type + ", " + batteries[i].dry + ", " + batteries[i].charge);
        }
        console.log();
        app.updateCharge();
    }

})();
