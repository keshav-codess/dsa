class Bank {
    private long[] balances;

    public Bank(long[] balance) {
        this.balances = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        if (balances[account1 - 1] < money) return false;
        balances[account1 - 1] -= money;
        balances[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;
        balances[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) return false;
        if (balances[account - 1] < money) return false;
        balances[account - 1] -= money;
        return true;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balances.length;
    }
}
