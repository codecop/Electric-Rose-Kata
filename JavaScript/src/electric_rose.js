function Battery(type, dry, charge) {
  this.type = type;
  this.dry = dry;
  this.charge = charge;
}

function ElectricRose(batteries) {
  this.batteries = batteries;
}
ElectricRose.prototype.updateCharge = function() {
  for (var i = 0; i < this.batteries.length; i++) {
    if (this.batteries[i].charge >= 0.1) {
      this.batteries[i].charge = Math.max(0, this.batteries[i].charge - 0.1);
    }

    if (this.batteries[i].dry) {
      if (this.batteries[i].charge >= 0.1) {
        this.batteries[i].charge = Math.max(0, this.batteries[i].charge - 0.1);
      }
    }
  }
}

module.exports = {
  Battery,
  ElectricRose
}
