import { Injectable } from '@angular/core';
import { Stock } from '../models/stock';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }

  apiURL: string = environment.baseUrl;
  private allStocks = new BehaviorSubject<Stock[]>([]);
  private allStocks$ = this.allStocks.asObservable();
  private allStocksByMarketCap = new BehaviorSubject<Stock[]>([]);
  private allStocksByMarketCap$ = this.allStocksByMarketCap.asObservable();
  private selectedStockId: number = 0;
  private selectedStock = new BehaviorSubject<Stock|undefined>(undefined);
  private selectedStock$ = this.selectedStock.asObservable();
  

  getStocks(): Observable<Stock[]> {
    return this.allStocks$;
  }

  setAllStocks(allstocks: Stock[]){
    return this.allStocks.next(allstocks);
  }

  getAllStocksByMarketCap(marketCapitalization: number):Observable<Stock[]> {
    return this.allStocksByMarketCap$
  }

  setAllStocksByMarketCap(allStocksByMarketCap: Stock[]){
    return this.allStocksByMarketCap.next(allStocksByMarketCap);
  }

  getSelectedStock(): Observable<Stock | undefined> {
    return this.selectedStock$;
  }

  setSelectedStock(stock: Stock){
    return this.selectedStock.next(stock);
  }

  public getAllStocks(): Observable<Stock[]>{
   return this.http.get<any>(this.apiURL + '/stocks');
  }

  public getStockById(id: number): Observable<Stock>{
    this.selectedStockId = id;
    return this.http.get<Stock>(this.apiURL + '/stock?id=' + this.selectedStockId,
    {headers: environment.headers, withCredentials: environment.withCredentials});
  }

  public getAllStocksByMarketCapApiCall(marketCapitalization: number): Observable<Stock[]> {
    return this.http.get<Stock[]>(this.apiURL + '/stocksByMarketCap?marketCapitalization=' + marketCapitalization);
  }
}
