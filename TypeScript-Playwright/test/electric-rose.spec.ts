import { test, expect } from "@playwright/test";
import {Battery, ElectricRose} from "../app/electric-rose";


test.describe("Electric Rose", () => {
  test("should foo", async () => {
    const batteries = [new Battery("foo", false, 1)];
    const app = new ElectricRose(batteries);
    app.updateCharge();
    expect(batteries[0].type).toEqual("fixme");
  });
});
