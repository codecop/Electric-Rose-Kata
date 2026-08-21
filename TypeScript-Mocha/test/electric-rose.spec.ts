import { expect } from 'chai';
import { Battery, ElectricRose } from '../app/electric-rose';

describe('Electric Rose', function () {

    it('should foo', function () {
        const batteries = [new Battery('foo', false, 1)];
        const app = new ElectricRose(batteries);
        app.updateCharge();
        expect(batteries[0].type).to.equal('fixme');
    });

});
