package com.ndgs.NetflixDGS.accounts.dataloader

import com.ndgs.NetflixDGS.accounts.domain.Client
import com.ndgs.NetflixDGS.accounts.service.BankService
import com.netflix.graphql.dgs.DgsDataLoader
import org.dataloader.MappedBatchLoader
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage


@DgsDataLoader(name = "client")
class ClientDataLoader : MappedBatchLoader<Int, Client>{

    @Autowired
    val accountService = BankService()

    override fun load(keys: Set<Int>?): CompletionStage<Map<Int, Client>>? {
        if (keys != null) {
            return CompletableFuture.supplyAsync({accountService.getClients(keys.toList())})
        }else
            return null
    }

}