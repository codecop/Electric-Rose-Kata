#include <stdio.h>      /* printf */
#include <stdlib.h>     /* atoi */
#include "ElectricRose.h"

int main(int argc, char *argv[])
{
    Battery batteries[2];
    int last = 0;
    int times = 2;
    int i;
    int index;

    puts("BZZ ZZZ!");

    init_battery(batteries + last++, "Samsung Lithium-ion", 0, 20);
    init_battery(batteries + last++, "Budget Nickel Cadmium", 1, 7);

    if (argc > 1) {
        times = atoi(argv[1]) + 1;
    }

    for (i  = 0; i < times; i ++)
    {
        printf("-------- usage %d --------\n", i);
        printf("type, dry, charge\n");
        for(index = 0; index < last; index++) {
            print_battery(batteries + index);
        }
        printf("\n");
        update_charge(batteries, last);
    }

    return 0;
}
