package com.ndgs.NetflixDGS.accounts.datafetcher

import com.ndgs.NetflixDGS.accounts.dataloader.ClientDataLoader
import com.ndgs.NetflixDGS.accounts.domain.Account
import com.ndgs.NetflixDGS.accounts.domain.Client
import com.ndgs.NetflixDGS.accounts.service.BankService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsQuery
import org.dataloader.DataLoader
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CompletableFuture

@DgsComponent
class AccountsDataFetcher {

    @Autowired
    val accountsService = BankService()

    @DgsQuery
    fun accounts():List<Account>{
        return accountsService.accounts()
    }

    /*
    query MyQuery {
  accounts {
    id
    balance
    currency
    status
    client {
      firstName
      id
      lastName
      middleName
    }
  }

}

     */

    @DgsData(parentType = "Account", field = "client")
    fun client ( dfe : DgsDataFetchingEnvironment): CompletableFuture<Client> {
        val clientsDataLoader :  DataLoader<Int, Client>  = dfe.getDataLoader(ClientDataLoader::class.java)

        var account : Account?  = dfe.getSource()

        return clientsDataLoader.load(account?.id)

    }
}