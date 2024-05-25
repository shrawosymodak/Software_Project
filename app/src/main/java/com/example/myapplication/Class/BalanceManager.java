package com.example.myapplication.Class;

public class BalanceManager
{
    private static BalanceManager instance;
    private BalanceClass balance;
    private BalanceManager() {}

    public static synchronized  BalanceManager getInstance()
    {
        if( instance == null)
        {
            instance = new BalanceManager();
        }
        return instance;
    }
    public BalanceClass setBalance(int balanceId , int user_id , int previousBalance , int currentBalance , int lastTransaction)
    {

        this.balance = new BalanceClass(previousBalance, currentBalance, lastTransaction);
        this.balance.balanceId = balanceId;
        this.balance.user_id = user_id;
        return balance;
    }
    public BalanceClass getBalance()
    {
        return balance;
    }
    public void addCurrentBalance(int balance)
    {
        this.balance.setCurrentBalance(this.balance.getCurrentBalance() + balance);
    }
    public int getCurrentBalance()
    {
        return balance.getCurrentBalance();
    }
    public void updateBalance(int balance)
    {
        this.balance.setPreviousBalance(this.balance.getCurrentBalance());
        this.balance.setLastTransaction(balance);
        this.balance.setCurrentBalance(this.balance.getCurrentBalance()+balance);
    }

}
