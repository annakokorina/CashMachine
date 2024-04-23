package DZ;

public class CashMachine {
    private final int nominal20;
    private final int nominal50;
    private final int nominal100;
    private int allMoney;

    public CashMachine(int nominal20, int nominal50, int nominal100) {
        this.nominal20 = nominal20;
        this.nominal50 = nominal50;
        this.nominal100 = nominal100;
    }

    public void AddMoney(int addAmount) {
        allMoney += addAmount;
        System.out.println("Баланс = " + allMoney);
    }

    public void WithdrawMoney(int withdrawAmount) {
        if (withdrawAmount < allMoney) {
            int withdrawSum = withdrawAmount;
            int hundred_to_out = 0;
            int fifty_to_out = 0;
            int twenty_to_out = 0;
            if ((nominal20 * 20 + nominal50 * 50 + nominal100 * 100) >= withdrawAmount) {
                if (withdrawAmount % 10 == 0) {// Проверка того что число не кратно 10
                    if (withdrawAmount % 50 != 0) {//Число не кратно 50. Нужно попрбовать привести его к кратности
                        for (int n = 0; nominal20 > n; n++) {
                            withdrawAmount = withdrawAmount - 20;
                            twenty_to_out++;
                            if (withdrawAmount % 50 == 0) {
                                break;
                            }
                        }
                    }
                    for (int n = 0; nominal100 > n; n++) {
                        if (withdrawAmount - 100 >= 0) {
                            withdrawAmount = withdrawAmount - 100;
                            hundred_to_out++;
                        }
                    }
                    for (int b = 0; nominal50 > b; b++) {
                        if (withdrawAmount - 50 >= 0) {
                            withdrawAmount = withdrawAmount - 50;
                            fifty_to_out++;
                        }
                    }
                    if (withdrawAmount % 20 == 0) {
                        for (int z = 0; nominal20 > z; z++) {
                            if (withdrawAmount - 20 >= 0) {
                                withdrawAmount = withdrawAmount - 20;
                                twenty_to_out++;
                            }
                        }
                        System.out.println("Для выдачи суммы " + withdrawSum + " необходимо: " + "\n" + hundred_to_out + " купюр 100" + "\n" + fifty_to_out + " купюр 50" + "\n" + twenty_to_out + " купюр 20");
                    } else {
                        System.out.println("Не удалось выдать данную сумму имеющимися купюрами");
                    }
                } else {
                    System.out.println("Невозможно выдать данную сумму");
                }
            } else {
                System.out.println("В банкомате недостаточно средств");
            }
            System.out.println("Текущий баланс: " + (allMoney - withdrawSum));
        } else {
            System.out.println("На карте недостаточно средств");
        }
    }
}
