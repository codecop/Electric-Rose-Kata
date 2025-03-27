Electric Rose Requirements Specification
========================================

Hi and welcome to the Electric Rose App.
When batteries are used, their charge is reduced.
This innovative app keeps track of all your batteries in use and lets you manage them in one place.
Here is an introduction a part of to the system:

- All batteries have a Dry value which denotes if the battery still keeps its fluids inside.
- All batteries have a Charge value which denotes how much electricity is left in the battery.
- After each usage, the app lowers the Charge value for every battery.

Pretty simple, right? Well this is where it gets interesting:

- Once the battery is dry, Charge degrades twice as fast.
- The Charge of a battery is never negative.

Additional Requirements by [Christoph Stadlinger](https://github.com/codingStad)
-----------------------------------------------

We want to add user notifications to our app.

- Show a message for batteries with less than 10%: "need to be charged soon - battery can still be used"
- Show a message for batteries with less than 5%: "need to be charged - battery can still be used"
- Show a message for batteries with no charge left: "recharge now - battery can no longer be used"

There is a new type of batteries on the marked which we want to support as well: Rechargeable Batteries.

- Every rechargeable battery can define the percentage at which the recharge should begin.
