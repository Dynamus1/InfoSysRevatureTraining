package com.revature.repo;

/*
    Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()

    DOES NOT HAVE UPDATE methods

    When we are using the Query annotation, you have to add the wildcard(?) with param numbers that indicates
    the index of the values
    Example of an update using @Query:

*/

import com.revature.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StockRepo extends JpaRepository<Stock, Integer> {

    @Modifying
    @Query(value = "UPDATE stocks SET stock_price=?1 WHERE company_id=?2", nativeQuery = true)
    public int updateStockPriceById(long stockPrice, int companyId);

    @Modifying
    @Query(value = "UPDATE stocks SET market_capitalization=?1 WHERE company_id=?2", nativeQuery = true)
    public int updateMarketCapitalizationById(long marketCapitalization, int companyId);

    @Query(value = "SELECT * FROM stocks WHERE market_capitalization >= ?1", nativeQuery = true)
    public List<Stock> getAllByMarketCap(long marketCapitalization);
}

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int companyId;
//
//    @Column(nullable = false)
//    private String companyName;
//
//    @Column(nullable = false)
//    private String companyTickerSymbol;
//
//    @Column(nullable = false)
//    private long stockPrice;
//
//    @Column(nullable = false)
//    private long shares;
//
//    @Column(nullable = false)
//    private long marketCapitalization;
