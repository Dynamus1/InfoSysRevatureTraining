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
  private selectedStockid: number = 0;

  getStocks(): Observable<Stock[]> {
    return this.allStocks$;
  }

  setAllStocks(allstocks: Stock[]){
    return this.allStocks.next(allstocks);
  }

  public getAllStocks(): Observable<Stock[]>{
   return this.http.get<any>(this.apiURL + '/stocks');
  }

  public getStockById(id: number): Observable<Stock>{
    this.selectedStockid = id;
    return this.http.get<Stock>(this.apiURL + '/stock?id=' + this.selectedStockid,
    {headers: environment.headers, withCredentials: environment.withCredentials});
  }
}
