package DZ;

public class Main {
    public static void main(String[] args) {
        CashMachine machine = new CashMachine(5, 5, 5);
        machine.AddMoney(900);
        machine.WithdrawMoney(260);
    }
}
