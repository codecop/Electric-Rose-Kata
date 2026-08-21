export class Battery {
    type: string;
    dry: boolean;
    charge: number;

    constructor(type: string, dry: boolean, charge: number) {
        this.type = type;
        this.dry = dry;
        this.charge = charge;
    }
}

export class ElectricRose {
    batteries: Battery[];

    constructor(batteries: Battery[] = []) {
        this.batteries = batteries;
    }

    updateCharge() {
        for (let i = 0; i < this.batteries.length; i++) {
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
}