import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FinanceServiceUrls } from '../utils/api-constants';

@Injectable({
  providedIn: 'root'
})
export class FinanceService {

  constructor(private http: HttpClient) {}
  public testConnection():Observable<any>{
    return this.http.get(FinanceServiceUrls.FETCH_ALL_FINACE_RECORD);
  }
  public saveFinaceRecord(queryParams: Map<string, any>): Observable<any> {
    const headers = new HttpHeaders()
   .set('Access-Control-Allow-Origin', '*');
    return this.http.post(FinanceServiceUrls.SAVE_FINACE_RECORD, queryParams.get('model'),{headers:headers});
  }
}
