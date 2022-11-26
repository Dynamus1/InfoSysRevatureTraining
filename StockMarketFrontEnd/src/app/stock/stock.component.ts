import { Component, Input, OnChanges, OnInit } from '@angular/core';
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

  ngOnInit(): void {
    this.stockService.getSelectedStock().subscribe(
      (data) => 
        this.selectedStock = data
      );
    console.log(this.selectedStock?.companyId); 
  }

  purchaseSharesActivate(): boolean {
    if(this.purchaseShares != true){
      return this.purchaseShares = true;
    } else {
      return this.purchaseShares = false;
    }
  }
}
