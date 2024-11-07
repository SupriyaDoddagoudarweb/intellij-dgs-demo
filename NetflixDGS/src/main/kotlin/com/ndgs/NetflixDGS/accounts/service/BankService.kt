package com.ndgs.NetflixDGS.accounts.service

import com.ndgs.NetflixDGS.accounts.domain.Account
import com.ndgs.NetflixDGS.accounts.domain.Client
import com.ndgs.NetflixDGS.accounts.domain.Currency
import org.springframework.stereotype.Service

@Service
class BankService{

    companion object{
        val bankAccounts = listOf(
            Account(100, "C100", Currency.USD, 1500.00f, "Active"),
            Account(100, "C101", Currency.CAD, 3000.00f, "Active"),
            Account(102, "C102", Currency.EUR, 2500.00f, "Inactive"),
            Account(103, "C103", Currency.USD, 5000.00f, "Active"),
            Account(104, "C104", Currency.EUR, 7500.00f, "Active")
        )

        val clients = listOf(
            Client("C100", 100, "John", "T.", "Doe"),
         Client("C101", 101, "Emma", "B.", "Smith"),
         Client("C102", 102, "James", "R.", "Brown"),
         Client("C103", 103, "Olivia", "S.", "Johnson"),
         Client("C104", 104, "William", "K.", "Jones")

        )
    }
    fun accounts():List<Account>{
        return bankAccounts
    }

    /*
    public Map<Integer, Client> getClients (List<Integer> accountIds) {
        Map<Integer, Client> accountToClients = new HashMap<>();

        for (Integer accountId : accountIds) {

            // Search for clients with the matching account ID and add them to the list
            for (Client client : clients) {
                if (client.accountId().intValue() == accountId.intValue()) {
                    accountToClients.put(accountId, client);
                }
            }
        }

        return accountToClients;
    }

     */
    fun getClients (accountIds : List<Int>) : Map<Int, Client>{
        var accountToClients : MutableMap<Int, Client> = mutableMapOf()

        for(accountId  in  accountIds){
            for(client:Client in clients){
                 if(client.accountId == accountId){
                    accountToClients[accountId]=client
                 }
            }

        }

        return accountToClients
    }


}