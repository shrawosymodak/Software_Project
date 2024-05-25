package com.example.myapplication.mainfragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.Class.BalanceClass;
import com.example.myapplication.Class.BalanceManager;
import com.example.myapplication.Class.ExpenseClass;
import com.example.myapplication.Class.ExpenseManager;
import com.example.myapplication.Class.User;
import com.example.myapplication.Class.UserSingleton;
import com.example.myapplication.R;
import com.example.myapplication.adapters.expenseAdapter;
import com.example.myapplication.expenseFactory.Items;
import com.example.myapplication.expenseFactory.ItemsFactory;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.BalanceDao;
import com.example.myapplication.room.ExpenseDao;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class expenseFragment extends Fragment {
    private Button expenseButton, statusButton, addBalance;
    private TextView PreviousBalance, CurrentBalance, LastTransaction, date;
    private EditText balance;
    private RecyclerView recyclerView;
    private List<ExpenseClass> mylist;
    private expenseAdapter adapter1;
    private ExpenseDao expenseDao;
    private BalanceDao balanceDao;
    private User loggedUser;
    private BalanceManager BalanceManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_expense, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Initializing views
        expenseButton = view.findViewById(R.id.addExpense);
        statusButton = view.findViewById(R.id.status);
        PreviousBalance = view.findViewById(R.id.previousBalance);
        CurrentBalance = view.findViewById(R.id.currentBalance);
        LastTransaction = view.findViewById(R.id.lastTransaction);
        recyclerView = view.findViewById(R.id.recycler);
        date = view.findViewById(R.id.date);
        balance = view.findViewById(R.id.addBalance);
        addBalance = view.findViewById(R.id.addButton);
        loggedUser = UserSingleton.getInstance().getUser();
        BalanceManager = BalanceManager.getInstance();

        // Initializing database and list
        AppDatabase db = AppDatabase.getInstance(getContext());
        expenseDao = db.expenseDao();
        balanceDao = db.balanceDao();
        mylist =  expenseDao.getAll(loggedUser.getUid());

        // Setting up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter1 = new expenseAdapter(mylist, getContext());
        recyclerView.setAdapter(adapter1);

        // Setting up date
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        date.setText(currentDate);
        //setting up balance
        if(balanceDao.getAll(loggedUser.getUid()).size() ==  0 )
        {
            BalanceClass balanceClass = BalanceManager.setBalance(loggedUser.getUid(), loggedUser.getUid(), 0, 0, 0);
            PreviousBalance.setText(String.valueOf(BalanceManager.getBalance().getPreviousBalance()));
            CurrentBalance.setText(String.valueOf(BalanceManager.getBalance().getCurrentBalance()));
            LastTransaction.setText(String.valueOf(BalanceManager.getBalance().getLastTransaction()));
            balanceDao.insertAll(BalanceManager.getBalance());

        }
        else
        {
            BalanceClass balanceClass = BalanceManager.setBalance( loggedUser.getUid(), loggedUser.getUid(), balanceDao.getAll(loggedUser.getUid()).get(0).getPreviousBalance() , balanceDao.getAll(loggedUser.getUid()).get(0).getCurrentBalance(), balanceDao.getAll(loggedUser.getUid()).get(0).getLastTransaction());;
            PreviousBalance.setText(String.valueOf(BalanceManager.getBalance().getPreviousBalance()));
            CurrentBalance.setText(String.valueOf(BalanceManager.getBalance().getCurrentBalance()));
            LastTransaction.setText(String.valueOf(BalanceManager.getBalance().getLastTransaction()));
            balanceDao.update(BalanceManager.getBalance());
        }

        addBalance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String balanceText = balance.getText().toString();
                CurrentBalance.setText(balanceText);
                BalanceManager.updateBalance(Integer.parseInt(balanceText));
                PreviousBalance.setText(String.valueOf(BalanceManager.getBalance().getPreviousBalance()));
                CurrentBalance.setText(String.valueOf(BalanceManager.getBalance().getCurrentBalance()));
                LastTransaction.setText(String.valueOf(BalanceManager.getBalance().getLastTransaction()));
                balanceDao.update(BalanceManager.getBalance());
            }
        });

        // Adding an expense
        expenseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                View expenseDialogue = LayoutInflater.from(getContext()).inflate(R.layout.expensedialogue, null);
                Spinner spinner = expenseDialogue.findViewById(R.id.spinner);
//                Implementation of Factory Design Pattern
                ItemsFactory itemsFactory = new ItemsFactory();
                Items itemBills = itemsFactory.getItems("Bills");
                itemBills.setItemName();
                Items itemFood = itemsFactory.getItems("Food");
                itemFood.setItemName();
                Items itemGroceries = itemsFactory.getItems("Groceries");
                itemGroceries.setItemName();
                Items itemShopping = itemsFactory.getItems("Shopping");
                itemShopping.setItemName();
                Items itemTransport = itemsFactory.getItems("Transport");
                itemTransport.setItemName();
                Items itemMiscellaneous = itemsFactory.getItems("Miscellaneous");
                itemMiscellaneous.setItemName();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(itemBills.getItemName());
                arrayList.add(itemFood.getItemName());
                arrayList.add(itemGroceries.getItemName());
                arrayList.add(itemShopping.getItemName());
                arrayList.add(itemTransport.getItemName());
                arrayList.add(itemMiscellaneous.getItemName());
//                arrayList.add("Bills");
//                arrayList.add("Food");
//                arrayList.add("Snacks");
//                arrayList.add("Groceries");
//                arrayList.add("Hangout");
//                arrayList.add("Others");

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinnerview, R.id.spinnerText, arrayList);
                spinner.setAdapter(adapter);

                AlertDialog alertDialog = new MaterialAlertDialogBuilder(getContext())
                        .setView(expenseDialogue)
                        .setTitle("Add Expense")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                EditText amount = expenseDialogue.findViewById(R.id.amount);
                                EditText description = expenseDialogue.findViewById(R.id.details);
                                String type = spinner.getSelectedItem().toString();
                                String amountText = amount.getText().toString();
                                String descriptionText = description.getText().toString();

                                int key = mylist.size() + 1;

                                //ExpenseClass expenseClass = new ExpenseClass(Integer.parseInt(amountText), descriptionText, type, key, 1);
                                ExpenseManager expenseManager = new ExpenseManager();
                                int uid = loggedUser.getUid();

                                expenseDao.insertAll(expenseManager.addExpense(type, descriptionText, Integer.parseInt(amountText), key, uid));
                                mylist.clear();
                                mylist.addAll(expenseDao.getAll(uid));
                                adapter1.notifyDataSetChanged();
                                // Updating balance
                                BalanceManager.updateBalance(-Integer.parseInt(amountText));
                                PreviousBalance.setText(String.valueOf(BalanceManager.getBalance().getPreviousBalance()));
                                CurrentBalance.setText(String.valueOf(BalanceManager.getBalance().getCurrentBalance()));
                                LastTransaction.setText(String.valueOf(BalanceManager.getBalance().getLastTransaction()));
                                balanceDao.update(BalanceManager.getBalance());
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
    }
}
