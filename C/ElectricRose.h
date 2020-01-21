typedef struct
{
    char *type;
    bool dry;
    float charge;
} Battery;

extern Battery* init_battery(Battery* battery, const char *type, bool dry, float charge);
extern int print_battery(Battery *battery);
extern void update_charge(Battery batteries[], int size);
