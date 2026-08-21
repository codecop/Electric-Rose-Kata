import { Battery, ElectricRose } from './electric-rose';

console.log("BZZ ZZZ!");

const batteries = [
    new Battery("Samsung Lithium-ion", false, 20), //
    new Battery("Budget Nickel Cadmium", true, 7),
];

const app = new ElectricRose(batteries);

let times = 2;
if (process.argv.length > 2) {
    times = parseInt(process.argv[2]) + 1;
}

for (let t = 0; t < times; t++) {
    console.log("-------- usage " + t + " --------");
    console.log("type, dry, charge");
    batteries.forEach(element => {
        console.log(element.type + ', ' + element.dry + ', ' + element.charge);
    });
    console.log();
    app.updateCharge();
}