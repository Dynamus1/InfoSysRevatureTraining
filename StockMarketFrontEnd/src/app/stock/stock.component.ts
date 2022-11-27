import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Stock } from '../models/stock';
import { StockService } from '../services/stock-service.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  // @Input() selectedStock: Stock | undefined;
  constructor(private stockService: StockService) { }

  selectedStockId: number = 0;
  selectedStock: Stock | undefined = undefined;
  allStocks: Stock[] = [];
  allStocksByMarketCap: Stock[] | undefined = undefined;
  purchaseShares: boolean = false;
  newStockPrice: number = 0;
  newMarketCap: number = 0;

  stockPurchaseForm = new FormGroup({
    numberOfSharesPurchased: new FormControl(''),
    priceOfSharesPurchased: new FormControl('')
  })

  ngOnInit(): void {
    this.stockService.getSelectedStock().subscribe(
      (data) => 
        this.selectedStock = data
      );
    console.log(this.selectedStock?.companyId); 
  }

  calculateNewStockPrice(stocksPurchased: number, purchasePrice: number): number  {
    if(this.selectedStock != undefined){
      this.newStockPrice = (((this.selectedStock.shares - stocksPurchased)/100) * this.selectedStock.stockPrice)+
      ((stocksPurchased/100) * purchasePrice);
      return this.newStockPrice;
    } else {
      return 0;
    }
  }

  purchaseSharesActivate(): boolean {
    if(this.purchaseShares != true){
      return this.purchaseShares = true;
    } else {
      return this.purchaseShares = false;
    }
  }

  updateMarketCapAndStockPrice(): void {
    if(this.selectedStock != undefined){
      this.newStockPrice = this.calculateNewStockPrice(Number(this.stockPurchaseForm.get('numberOfSharesPurchased')?.value),
      Number(this.stockPurchaseForm.get('priceOfSharesPurchased')?.value));

      this.newMarketCap = this.selectedStock?.shares * this.newStockPrice;
      
      this.stockService.updateStockPrice(this.selectedStock?.companyId, this.selectedStock?.companyName,
      this.selectedStock?.companyTickerSymbol, this.newStockPrice, this.selectedStock.shares, this.newMarketCap).subscribe();

      this.stockService.updateStockMarketCap(this.selectedStock?.companyId, this.selectedStock?.companyName,
      this.selectedStock?.companyTickerSymbol, this.newStockPrice, this.selectedStock.shares, this.newMarketCap).subscribe();
    }
  }
}

