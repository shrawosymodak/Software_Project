package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class BalanceClass
{
        @PrimaryKey(autoGenerate = true)
        public int balanceId;
        public int user_id;
        @ColumnInfo(name = "previousBalance")
        private int PreviousBalance;
        @ColumnInfo(name = "currentBalance")
        private int CurrentBalance;
        @ColumnInfo(name = "lastTransaction")
        private int LastTransaction;

        public BalanceClass(int previousBalance, int currentBalance, int lastTransaction) {
            PreviousBalance = previousBalance;
            CurrentBalance = currentBalance;
            LastTransaction = lastTransaction;
        }
        public BalanceClass()
        {
        }

        public int getPreviousBalance() {
            return PreviousBalance;
        }

        public void setPreviousBalance(int previousBalance) {
            PreviousBalance = previousBalance;
        }

        public int getCurrentBalance() {
            return CurrentBalance;
        }

        public void setCurrentBalance(int currentBalance) {
            CurrentBalance = currentBalance;
        }

        public int getLastTransaction() {
            return LastTransaction;
        }

        public void setLastTransaction(int lastTransaction) {
            LastTransaction = lastTransaction;
        }
}