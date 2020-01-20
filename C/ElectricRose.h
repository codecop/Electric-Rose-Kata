typedef struct
{
    char *type;
    int dry;
    double charge;
} Battery;

extern Battery* init_battery(Battery* battery, const char *type, int dry, double charge);
extern int print_battery(Battery *battery);
extern void update_charge(Battery batteries[], int size);
