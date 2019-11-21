var expect = require('chai').expect;
var rose = require('../src/electric_rose.js');

describe("Electric Rose", function() {

  it("should foo", function() {
    var batteries = [new rose.Battery("foo", false, 1)];
    var app = new rose.ElectricRose(batteries);
    app.updateCharge();
    expect(batteries[0].type).to.equal("fixme");
  });

});
