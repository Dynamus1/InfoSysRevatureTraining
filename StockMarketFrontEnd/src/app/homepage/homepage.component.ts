import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../models/stock';
import { StockService } from '../services/stock-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private stockService: StockService, private router: Router) { }

  allStocks: Stock[] = []
  allStocksLength: number = 0;
  selectedStock: Stock | undefined = undefined;

  ngOnInit(): void {
    this.stockService.getAllStocks().subscribe(
      (data) => {
        this.allStocks = data;
      },
      // () => this.allStocksLength = this.allStocks.length,
      // () => console.log(this.allStocks.length)
    );
  }

  stockInfo(id: number){
    // console.log("Selected id: "+id);
    this.stockService.getStockById(id).subscribe(
      (data) => {
        this.stockService.setSelectedStock(data);
        this.selectedStock = data;
        // console.log(this.selectedStock);
      },
    )
    this.router.navigate(['stock']);
  }

}
